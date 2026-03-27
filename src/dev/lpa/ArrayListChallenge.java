package dev.lpa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ArrayListChallenge {
    public static void main(String[] args) {

        ArrayList<String> groceries = new ArrayList<>();

        boolean flag = true;

        while (flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter 0 to shut down, 1 to add items with comma, 2 to remove items with comma");

            int answer = scanner.nextInt();
            scanner.nextLine();
            if (answer == 0) {
                printList(groceries);
                flag = false;
            } else if (answer == 1) {
                addItems(groceries, scanner);
                checkItems(groceries);
                printList(groceries);
            } else if (answer == 2) {
                removeItems(groceries, scanner);
                checkItems(groceries);
                printList(groceries);
            }
        }

    }


    private static void addItems(ArrayList<String> groceries, Scanner scanner) {
        System.out.println("Enter items via comma separated");
        String input = scanner.nextLine();
        String[] items = input.split(",");
        for (String item : items) {
            groceries.add(item.trim());
        }
     }

    private static void removeItems(ArrayList<String> groceries, Scanner scanner) {
        System.out.println("Remove items via comma separated");
        String input = scanner.nextLine();
        String[] items = input.split(",");
        for (String item : items) {
            groceries.remove(item.trim());
        }
    }

    private static void checkItems(ArrayList<String>groceries) {
        ArrayList<String> uniqueList = new ArrayList<>();

        for (String item : groceries) {
            if (!uniqueList.contains(item)) {
                uniqueList.add(item);
            }
        }

        groceries.clear();
        groceries.addAll(uniqueList);
    }

    private static void printList(ArrayList<String>groceries) {
        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);
    }
}
