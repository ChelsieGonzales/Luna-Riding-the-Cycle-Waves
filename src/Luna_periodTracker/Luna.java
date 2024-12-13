package Luna_periodTracker;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

class Luna {
    private static final Scanner scanner = new Scanner(System.in); //shared across all methods because it’s static
    public static void main(String [] args) {
        User user = initializeUser();
        PeriodTracker tracker = new PeriodTracker(user);

        while (true) {
            try {
                displayMenu();
                System.out.print("\nPlease input the number in chronological order: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
    
    
                switch (choice) {
                    case 1 :
                        logPeriod(tracker);
                        break;
                    case 2:
                        tracker.predictNextPeriod(5);
                        break;
                    case 3: 
                        checkPregnancyChance(tracker);
                        break;
                    case 4:
                        tracker.displayUsersInfo();
                        break;
                    case 5:
                        System.out.println("Thank you for using Luna. Stay healthy and happy!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                scanner.nextLine();
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("|This is the step-by-step guide to your Luna experience                  |");
            System.out.println("|1. Record a new period entry and track your cycle.                      |");
            System.out.println("|2. Get a sneak peek into your next menstruation with period predictions.|");
            System.out.println("|3. Check out your chance of pregnancy.                                  |");
            System.out.println("|4. View your personal cycle insights and details.                       |");
            System.out.println("|5. Exit Luna.                                                           |");
            System.out.println("-------------------------------------------------------------------------");
    }


    private static User initializeUser() {
        System.out.println("Hello! Welcome to Luna: Riding the Cycle Waves. We're here to help you track, understand, and embrace your cycle journey!");
        System.out.println("Let's get to know each other!");


        System.out.print("\nWhat would you like Luna to call you? ");
        String name = scanner.nextLine();
       
        System.out.println("Nice to meet you, " + name + "!");
        return new User(name);
    }
   
    private static void logPeriod(PeriodTracker tracker) {
        int cycleLength;
        LocalDate periodDate;
    
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("\n===============================LOG PERIOD====================================");
        System.out.println("\nFor us to assist you better, we need your cycle length.");
        System.out.print("Do you know your cycle length? (yes/no): ");
        String yesNoCycleLength = scanner.nextLine().trim().toLowerCase();
    
        try {
            if (yesNoCycleLength.equals("yes")) {
                // User knows their cycle length
                System.out.print("\nEnter your cycle length (in days): ");
                cycleLength = Integer.parseInt(scanner.nextLine().trim()); // Use nextLine to avoid newline issues
    
                System.out.print("\nLog your period date (yyyy-mm-dd): ");
                periodDate = LocalDate.parse(scanner.nextLine().trim());
    
            } else if (yesNoCycleLength.equals("no")) {
                // User does not know their cycle length
                System.out.print("\nFirst day of your last period (yyyy-mm-dd): ");
                LocalDate lastPeriod = LocalDate.parse(scanner.nextLine().trim());
    
                System.out.print("\nLog your period date (yyyy-mm-dd): ");
                periodDate = LocalDate.parse(scanner.nextLine().trim());
    
                cycleLength = (int) ChronoUnit.DAYS.between(lastPeriod, periodDate);
                System.out.println("\nHere is your calculated cycle length: " + cycleLength + " days");
            } else {
                System.out.println("Invalid response. Please type 'yes' or 'no'.");
                return;
            }
    
            if (cycleLength <= 0) {
                throw new IllegalArgumentException("Cycle length must be a positive number.");
            }
    
            tracker.setCycleLength(cycleLength);
    
            // Call mood, symptoms, and digestion handlers
            String mood = handleMood();
            String symptoms = handleSymptoms();
            String digestion = handleDigestion();
    
            tracker.logEntry(new PeriodEntry(periodDate, mood, symptoms, digestion));
            System.out.println("\nPeriod entry logged successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number for cycle length.");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-mm-dd format.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    
        System.out.println("------------------------------------------------------------------------------------------------------");
    }
    
    private static String handleMood() {
        System.out.println("\nNow, let's move on to what are your feeling today.");
        System.out.println("\n===============================MOODS=========================================");
    
        String mood;
        boolean validMood = false;
    
        do {
            System.out.print("\nWhat are your moods right now? (happy, mood swings, low energy): ");
            mood = scanner.nextLine().trim().toLowerCase();
    
            try {
                switch (mood) {
                    case "mood swings":
                        System.out.println("\n---------------------------------------------------------------------------------------");
                        System.out.println("| Remember, your feelings are completely valid. Mood swings often happen due to        |");
                        System.out.println("| sudden fluctuations in estrogen and progesterone levels. These hormonal shifts       |");
                        System.out.println("| can lead to a drop in serotonin, a hormone that contributes to feelings of happiness.|");
                        System.out.println("---------------------------------------------------------------------------------------");
                        validMood = true;
                        break;
                    case "happy":
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.println("| Great! It is nice to know that you are happy. Don't forget to rest:)     |");
                        System.out.println("---------------------------------------------------------------------------");
                        validMood = true;
                        break;
                    case "low energy":
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.println("| This is normal due to the decrease in oestrogen levels, which occurs around|");
                        System.out.println("| this point in your menstrual cycle. Your energy levels will usually return |");
                        System.out.println("| to normal within a few days as your hormone levels begin to increase again.|");
                        System.out.println("-----------------------------------------------------------------------------");
                        validMood = true;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid mood entered. Please choose from the suggested options.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (!validMood);
    
        return mood;
    }    

    private static String handleSymptoms() {
        System.out.println("\n===============================SYMPTOMS======================================");
        
        String symptoms;
        boolean validInput;
    
        do {
            System.out.print("\nWhat are your symptoms? (everything is fine, cramps, headache, fatigue, backache, acne): ");
            symptoms = scanner.nextLine().trim().toLowerCase();
            
            String[] symptomList = symptoms.split(",\\s*");
            validInput = true;  // Assume valid unless proven otherwise
    
            try {
                for (String symptom : symptomList) {
                    switch (symptom) {
                        case "everything is fine":
                            System.out.println("\n---------------------------------------------------------------------------------------");
                            System.out.println("| We are glad to hear that! Don't forget to rest, your body needs it.                  |");
                            System.out.println("---------------------------------------------------------------------------------------");
                            break;
                        case "cramps":
                            System.out.println("\n=================================LOGGED ENTRIES==================================");
                            System.out.println("\n-------------------------------------------------------------------------------------------------------------------");
                            System.out.println("|We see that you logged cramps. Here are things you can do to ease the pain:                                       |");
                            System.out.println("|1.Applying heat to your lower abdomen or back relaxes uterine muscles and increase blood flow, which eases pain.|");
                            System.out.println("|2.Over-the-counter options like ibuprofen or naproxen block prostaglandins, effectively reducing cramps.         |");
                            System.out.println("|3.Massaging the abdomen with essential oils (e.g., lavender) can improve circulation and relieve discomfort.     |");
                            System.out.println("-------------------------------------------------------------------------------------------------------------------");
                            break;
                        case "headache":
                            System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("|We see that you logged headache. Here are things you can do to ease the pain:                                                                                            |");
                            System.out.println("|1. Over-the-counter medications like ibuprofen, naproxen, or acetaminophen can reduce inflammation and pain.                                                             |");
                            System.out.println("|2. Applying a cold pack to your forehead can constrict blood vessels and relieve the headache.                                                                           |");
                            System.out.println("|3. A small amount of caffeine (e.g., tea or coffee) can enhance the effectiveness of pain relievers, but avoid overdoing it as caffeine withdrawal can worsen headaches. |");
                            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            break;
                        case "fatigue":
                            System.out.println("\n----------------------------------------------------------------------------------------------------------------------");
                            System.out.println("|We see that you logged fatigue. Here are things you can do to ease the symptoms:                                      |");
                            System.out.println("|1. Light exercises like yoga, walking, or stretching can improve blood circulation, reduce cramps, and boost energy.  |");
                            System.out.println("|2. Aim for 7-9 hours of quality sleep. Reduce screen time and caffeine before bed to improve restfulness.             |");
                            System.out.println("|3. Consult a doctor if heavy periods lead to anemia. Supplements may be recommended to restore iron levels.           |");
                            System.out.println("----------------------------------------------------------------------------------------------------------------------");
                            break;
                        case "backache":
                            System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("|We see that you logged backache. Here are things you can do to ease the pain:                                                        |");
                            System.out.println("|1. Use a hot water bottle, heating pad, or take a warm bath. Apply heat to your lower back for 15-20 minutes.                        |");
                            System.out.println("|2. A gentle back or abdominal massage with essential oils (e.g., lavender or peppermint) can improve circulation and relieve tension.|");
                            System.out.println("|3. Gentle exercise and stretches. Movement boosts circulation, releases endorphins (natural painkillers), and relaxes muscles.       |");
                            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
                            break;
                        case "acne":
                            System.out.println("\n---------------------------------------------------------------------------------------");
                            System.out.println("|We see that you logged acne. Here are things you can do to manage it:                 |");
                            System.out.println("|1. Stay hydrated: Drinking water helps flush out toxins and keeps your skin hydrated. |");
                            System.out.println("|2. Aim for 7-9 hours of quality sleep each night to support hormonal balance.         |");
                            System.out.println("|3. Do not touch your face: This prevents the transfer of bacteria.                    |");
                            System.out.println("---------------------------------------------------------------------------------------");
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid symptom entered: " + symptom);
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                validInput = false;
            }
        } while (!validInput);
    
        return symptoms;
    }
    
    private static String handleDigestion() {
        System.out.println("\n===============================DIGESTION=====================================");
    
        String digestion;
        boolean validDigestion = false;
    
        do {
            System.out.print("\nHow about your digestion? (everything is fine, nausea, bloating, diarrhea, constipation): ");
            digestion = scanner.nextLine().trim().toLowerCase();
    
            try {
                switch (digestion) {
                    case "everything is fine":
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.println("| Nice:) Do not forget to stay hydrated because your body needs fluid. |");
                        System.out.println("-----------------------------------------------------------------------");
                        validDigestion = true;
                        break;
                    case "nausea":
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("|Why? Hormones like prostaglandins, released during menstruation, cause the uterus to contract to shed its lining.       |");
                        System.out.println("|High levels of prostaglandins can sometimes enter the bloodstream, affecting the digestive system and leading to nausea.|");
                        System.out.println("|Do: Eat Small, Frequent Meals: Avoid large meals. Opt for easily digestible foods like bananas, toast, or rice.         |");
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
                        validDigestion = true;
                        break;
                    case "bloating":
                        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("|Why? Progesterone levels decrease before menstruation begins. This can slow digestion, causing gas and a feeling of fullness.|");
                        System.out.println("|Do: Eat Fiber-Rich Foods: Helps prevent constipation and keeps digestion smooth.                                             |");
                        System.out.println("|Do: Limit Carbonated Drinks: They can cause gas and make bloating worse.                                                     |");
                        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                        validDigestion = true;
                        break;
                    case "diarrhea":
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("|Why? This is normal due to the decrease in oestrogen levels. During menstruation, the body releases prostaglandins to help the uterus                 |");
                        System.out.println("|contract and shed its lining. High levels of prostaglandins can affect the intestines, causing them to contract more than usual, leading to diarrhea. |");
                        System.out.println("|DO: Avoid Trigger Foods: Reduce intake of caffeine, spicy foods, high-fat meals, and dairy, as these can irritate the gut.                            |");
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------");
                        validDigestion = true;
                        break;
                    case "constipation":
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("|Why? This is normal due to the decrease in oestrogen levels, which occurs around this point in your menstrual                       |");
                        System.out.println("|cycle. Your energy levels will usually return to normal within a few days as your hormone levels begin to increase again.           |");
                        System.out.println("|DO:Limit salt and refined sugars: Processed foods are high in salt and refined sugar, which can affect your digestion and hormones. |");
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
                        validDigestion = true;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid digestion status entered.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (!validDigestion);
    
        return digestion;
    }    

    private static void checkPregnancyChance(PeriodTracker tracker) {
        try {
            System.out.println("\n==============================CHANCE OF GETTING PREGNANT==============================");
            System.out.print("Choose a date to check pregnancy chance (yyyy-mm-dd): ");
            LocalDate chosenDate = LocalDate.parse(scanner.nextLine());
            tracker.pregnancyChance(chosenDate);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in the format yyyy-mm-dd.");
        }
    }  
}


