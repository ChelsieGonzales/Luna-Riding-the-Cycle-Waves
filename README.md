# 🌙Luna: Your Personal Period Tracker🌙

## I. Project Overview: *Embrace Your Cycle, Empower Your Health*
**Luna** is a period tracking application designed to help users track their menstrual cycles, predict upcoming periods, and estimate their chances of pregnancy based on their cycle data. The app allows users to log period details, including mood, symptoms, and digestion, as well as calculate and predict their next menstrual cycle. It is built using **Java** and follows **Object-Oriented Programming (OOP)** principles to structure the application.

### Key Features:
* **Cycle Tracking**: Record your period dates, mood, symptoms, and digestion.
* **Predict Your Period**: Get accurate predictions for the next 5 months based on your cycle length.
* **Pregnancy Chances**: Estimate your chances of pregnancy based on your fertility window.
* **Health Insights**: Track changes in mood, energy, and digestion with thoughtful feedback.

## II. How Luna Embraces OOP Principles 🌟
### 1. **ENCAPSULATION**:
* **User**: The **User class** is the heart of Luna, storing your username and cycle length, and making sure your data stays safe with getters and setters. Think of it as a digital diary that keeps track of your data, just for you!
* **PeriodEntry Class**: Period data (date, mood, symptoms, digestion) are encapsulated in the PeriodEntry class. This keeps the period details organized and easily accessible.

### 2. **ABSTRACTION**:
* **Abstract class Tracker**: defines the common interface and structure for the period tracking system. Specific actions such as logging entries and predicting periods are abstracted into methods like **logEntry()** and **predictNextPeriod()**, which are implemented in the PeriodTracker class.

### 3. INHERITANCE:
* **Period Tracker Class**: The PeriodTracker class **inherits from the abstract Tracker class**. This allows it to reuse the functionality of the parent class while implementing specific details like the prediction of future periods and pregnancy chances.

### 4. POLYMORPHISM
* The use of polymorphism is visible in the method **pregnancyChance()**, which adapts to different inputs (like a chosen date) and provides different outcomes based on the user’s data. Similarly, the **logEntry()** method can handle varying types of entries depending on the input.

## III. Integration of  the Sustainable Development Goal (SDG): Good Health & Well-Being 🌏
**Luna** is built with **Sustainable Development Goal 3** in mind—promoting **Good Health and Well-Being** for all. Here’s how Luna supports your health:
* **Physical Health**: Track your menstrual cycle and get predictions to help you manage your health better.
* **Mental Health**: By tracking your mood, symptoms, and digestion, Luna helps you understand the connection between your cycle and your mental well-being.
* **Reproductive Health**: Luna estimates your chances of pregnancy, helping you understand your fertility window and empowering you to make informed choices.

By helping users manage and understand their cycles, Luna plays a small but meaningful role in supporting women’s health globally.

## IV. Instructions for running the program 💻
Ready to start tracking your cycle with Luna? Here’s how you can get the app up and running on your computer:

### 🛠️ Installation
1. Clone the Repository
2. Navigate the project Directory
3. Compile the Java Files
4. Run the Program

### 📖 User Manual
**1. Getting Started**: When you run Luna for the first time, it will prompt you to provide your name. This name will personalize your experience.
**2. Main Menu Options**: After starting the program, you'll see the following menu:
**Option 1**: **Log a New Period Entry*
- You’ll be prompted to enter your cycle length or calculate it based on dates.
- Record additional details such as your mood, symptoms, and digestion.
**Option 2**: **Predict Next Period*
- Luna predicts your next periods for up to 5 months based on your logged data.
- If no data is available, Luna will ask you to log your cycle length first.
**Option 3**: **Check Pregnancy Chances*
- Enter a specific date to check your likelihood of pregnancy based on your cycle and fertile window.
**Option 4**: **View Cycle Insights*
- Displays your logged period entries, including cycle length, moods, symptoms, and digestion data
**Option 5**: **Exit Luna*
- Ends the session

**Luna** is your health assistant, right at your fingertips!


