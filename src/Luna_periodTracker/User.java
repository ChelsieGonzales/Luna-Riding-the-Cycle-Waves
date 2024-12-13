package Luna_periodTracker;

class User {
    private String userName;
    private int cycleLength = 0;
   
    public User(String userName) {
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }


    public void setCycleLength(int cycleLength) {
        this.cycleLength = cycleLength;
    }


    public int getCycleLength() {
        return cycleLength;
    }


    public String toString() {
        return "Username: " + userName +
                "\nCycle Length: " + cycleLength + " days";
    }
}
