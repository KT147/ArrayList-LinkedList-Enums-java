package dev.lpa;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedListChallenge {

    public static void main(String[] args) {

        var towns = new LinkedList<Town>();

        Town town1 = new Town("Adelaide", 1374);
        Town town2 = new Town("Alice Springs", 2771);
        Town town3 = new Town("Brisbane", 917);
        Town town4 = new Town("Darwin", 3972);
        Town town5 = new Town("Melbourne", 877);
        Town town6 = new Town("Perth", 3923);
        Town town7 = new Town("Sydney", 0);
        towns.add(town1);
        towns.add(town2);
        towns.add(town3);
        towns.add(town4);
        towns.add(town5);
        towns.add(town6);
        towns.add(town7);

        towns.sort(Comparator.comparingInt(Town::getDistance));

        var iterator = towns.listIterator();

        boolean flag = true;
        printMenu();

        while (flag) {
            Scanner scanner = new Scanner(System.in);

            String answer = scanner.nextLine().toUpperCase().substring(0,1);
            switch (answer) {
                case "F" -> moveForwardIterator(iterator);
                case "B" -> moveBacwardIterator(iterator);
                case "L" -> listTowns(towns);
                case "A" -> addTown(towns);
                case "M" -> printMenu();
                case "Q" -> flag = false;
                default -> flag = false;
            }
        }

    }


    public static void moveForwardIterator(ListIterator<Town> iterator) {

        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        } else {
            System.out.println("End of list");
        }
    }

    public static void moveBacwardIterator(ListIterator<Town> iterator) {

        if (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        } else {
            System.out.println("Start of list");
        }
    }

    public static void addTown(LinkedList<Town> list) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Add a new town and the distance, separated by comma");
        String answer = scanner.nextLine();

        String[] parts = answer.split(",");
        String name = parts[0].trim();
        int distance = Integer.parseInt(parts[1].trim());

//        if (list.contains(name)) {
//            System.out.println("Found duplicate of: " + name);
//            return;
//        }

        Town newTown = new Town(name, distance);
        list.add(newTown);
    }

    public static void printMenu() {
        System.out.println("""
                Available actions (select letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (A)dd Places
                (M)enu
                (Q)uit""");
    }

    public static void listTowns(LinkedList towns) {
        System.out.println(towns);
    }
}


class Town {
    private String name;
    private int distance;

    public Town(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }


    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return name + " (" + distance + " km)";
    }
}

///  see oleks olnud lihtsam kui sama class
//record Place(String name, int distance) {}


