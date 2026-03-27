package dev.lpa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysAndArrayLists {
    public static void main(String[] args) {

        String[] originalArray = new String[] {"First", "Second", "Third"};
        var originalList = Arrays.asList(originalArray);

        originalList.set(0, "one");
        System.out.println(originalList);
        System.out.println(Arrays.toString(originalArray));

        originalList.sort(Comparator.naturalOrder());
        System.out.println(Arrays.toString(originalArray));

        //ei saa
//        originalList.remove(0);
//        originalList.add("forth");

        List<String> newList = Arrays.asList("Sunday", "Monday", "Tuesday");
        System.out.println(newList);
    }
}
