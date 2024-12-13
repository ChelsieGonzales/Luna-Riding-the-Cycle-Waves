package Luna_periodTracker;

import java.time.LocalDate;
import java.util.ArrayList;

abstract class Tracker {
    protected User user;
    protected ArrayList<PeriodEntry> entries;


    public Tracker(User user) {
        this.user = user;
        this.entries = new ArrayList<>();
    }


    public abstract void logEntry(PeriodEntry entry);


    public abstract void predictNextPeriod(int months);


    public abstract void pregnancyChance(LocalDate chosenDate);


    public void displayUsersInfo() {
        System.out.println(user);
        System.out.println("Logged Entries:");
        for (PeriodEntry entry : entries) {
            System.out.println(entry);
            System.out.println("---------------");
        }
    }

}
