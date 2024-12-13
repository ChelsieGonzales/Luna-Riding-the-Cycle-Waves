package Luna_periodTracker;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class PeriodTracker extends Tracker {
    public PeriodTracker(User user) {
        super(user); //tawagin ang constructor of the superclass
    }


    public void setCycleLength(int cycleLength) {
        user.setCycleLength(cycleLength);
    }


    public int getCycleLength() {
        return user.getCycleLength();
    }


    public void logEntry(PeriodEntry entry) {
        entries.add(entry);
    }


    //here na me(November 20, 2024)
    public void predictNextPeriod(int months) {
        if(entries.isEmpty() || user.getCycleLength() == 0) {
            System.out.println("Doesn't have cycle length inputted.");
            return;
        }


        LocalDate lastPeriod = entries.get(entries.size() -1).getDate();
        //int cycleToPredict = (months * 31) / user.getCycleLength();

        System.out.println("\n================PERIOD PREDICTIONS FOR THE NEXT " + months + " MONTHS================");


        LocalDate nextPeriod = lastPeriod;


        for(int i = 1; i <= months; i++) {
            nextPeriod = lastPeriod.plusDays(i * user.getCycleLength());
            System.out.println("|                        Period " + i + ": " + nextPeriod + "                          |");
            System.out.println("------------------------------------------------------------------------");
        }
    }


    //November 21, 2024
    public void pregnancyChance(LocalDate chosenDate) {
        if (entries.isEmpty() || user.getCycleLength() == 0) {
            System.out.println("Oh, we think you did not log your cycle. Unable to predict.");
            return;
        }
    
        LocalDate lastPeriod = entries.get(entries.size() - 1).getDate();
        int cycleLength = user.getCycleLength();
    
        // Calculate predicted ovulation date (14 days before the next period)
        LocalDate predictedOvulationDate = lastPeriod.plusDays(cycleLength - 14);
    
        // Fertile window: 5 days before ovulation + ovulation day + 2 days after
        LocalDate fertileWindowStart = predictedOvulationDate.minusDays(5);
        LocalDate fertileWindowEnd = predictedOvulationDate.plusDays(2);
    
        long daysBetweenForChance = ChronoUnit.DAYS.between(lastPeriod, chosenDate);
    
        if (daysBetweenForChance < 0) {
            System.out.println("| Oh no! We think that the date you inputted is before the logged period date. |");
            System.out.println("---------------------------------------------------------------------------------");
        } else if (chosenDate.isEqual(predictedOvulationDate)) {
            System.out.println("|Chance of getting pregnant on " + chosenDate + ": High (ovulation day)                  |");
            System.out.println("---------------------------------------------------------------------------------");
        } else if (!chosenDate.isBefore(fertileWindowStart) && !chosenDate.isAfter(fertileWindowEnd)) {
            System.out.println("| Chance of getting pregnant on " + chosenDate + ": High (fertile window)                |");
            System.out.println("----------------------------------------------------------------------------------");
        } else if (daysBetweenForChance >= 0 && daysBetweenForChance <= 5) {
            System.out.println("| Chance of getting pregnant on " + chosenDate + ": Low (menstrual phase)                |");
            System.out.println("---------------------------------------------------------------------------------");
        } else {
            System.out.println("| Chance of getting pregnant on " + chosenDate + ": Low                                  |");
            System.out.println("---------------------------------------------------------------------------------");
        }
    }
    
    //November 22, 2024
    public void displayUsersInfo() {
        System.out.println(user);
        System.out.println("\n===================================LOGGED ENTRIES====================================");
        for (PeriodEntry entry : entries) {
            System.out.println(entry); // Calls PeriodEntry.toString()
            System.out.println("---------------------------------------------------------------------------------");
        }
    }

}
