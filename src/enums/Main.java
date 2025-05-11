package enums;

public class Main {
    public static void main(String[] args) {
        // We can use constant strings but using enum is much easier
        System.out.println(DayClass.MONDAY);

        // lets use enums
        // Internally enums are converted into a class with the same name and each contant specified in enum class becomes a final instance of the internally created class
        System.out.println(Day.FRIDAY);

        Day monday = Day.MONDAY;

        // gives the name
        System.out.println(monday.name());

        // index
        System.out.println(monday.ordinal());

        // get value of enum given name of the constant
        Day monday1 = Day.valueOf("MONDAY");
        System.out.println(monday1.name());


        // get list of all enums
        Day[] days = Day.values();

        for(Day day : days){
            System.out.println(day.name());
        }


        monday.display();

        System.out.println(monday.getLower());

        // enums with new switch

        Day day = Day.WEDNESDAY;

        String res = switch (day){
            case MONDAY -> "MN";
            case TUESDAY -> "T";
            default -> "Weekend";
        };

        System.out.println(res);

    }
}
