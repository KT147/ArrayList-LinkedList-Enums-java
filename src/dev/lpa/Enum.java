package dev.lpa;

import java.util.Random;

public class Enum {

    public static void main(String[] args) {

        DayOfTheWeek weekday = DayOfTheWeek.TUE;
        System.out.println(weekday);

        System.out.println(weekday.name());
        System.out.println(weekday.ordinal());

        var randomDay = getRandomDay();

        System.out.println(randomDay);

        if (randomDay != DayOfTheWeek.FRI) {
            System.out.println("It's not Friday");
        }

        switchDayOfWeek(weekday);

        for (Topping topping : Topping.values()) {
            System.out.println(topping.name() + " : " + topping.getPrice());
        }
    }

    public static DayOfTheWeek getRandomDay() {
        int randomInteger = new Random().nextInt(7);
        var allDays = DayOfTheWeek.values();

        return allDays[randomInteger];
    }

    public static void switchDayOfWeek(DayOfTheWeek weekDay) {
        int weekDayInteger = weekDay.ordinal() + 1;
        switch (weekDay) {
            case WED -> System.out.println("WednesDay is " + weekDayInteger);
            case SAT -> System.out.println("Saturday is " + weekDayInteger);
            default ->
                    System.out.println(weekDay.name().charAt(0) + weekDay.name().substring(1).toLowerCase() + "day is Day " + weekDayInteger);
        }
    }
}
