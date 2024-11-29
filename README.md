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



