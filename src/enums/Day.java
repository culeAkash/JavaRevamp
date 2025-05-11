package enums;

public enum Day {
    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday");

    private String lower;

    public String getLower() {
        return lower;
    }

    private Day(String lower){
        this.lower = lower;
    }

    public void display(){
        System.out.println("Today is " + this.name());
    }
}
