package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;

record GroceryItem(String name, String type, int count) {

    public GroceryItem(String name) {
        this(name, "DAIRY", 1);
    }

    @Override
    public String toString() {
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }
}

public class Main {

    public static void main(String[] args) {
        GroceryItem[] groceryItem = new GroceryItem[3];
        groceryItem[0] = new GroceryItem("milk");
        groceryItem[1] = new GroceryItem("apples", "PRODUCE", 6);
        groceryItem[2] = new GroceryItem("oranges", "PRODUCE", 5);

        System.out.println(Arrays.toString(groceryItem));

        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yoghurt");

        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Butter"));
        groceryList.add(0, new GroceryItem("Apple", "STUFF", 2));
        groceryList.set(0, new GroceryItem("Apple", "STUFF", 2));
        groceryList.remove(0);
        System.out.println(groceryList);
    }
}
