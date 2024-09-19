package org.launchcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        ArrayList<MenuItem> menuItems = new ArrayList<>(Arrays.asList());
        Date date = new Date(1996 - 1 - 4);
        Menu menu = new Menu(date, menuItems);
        boolean loopStatus = false;


        menu.readMenuFromFile(menuItems);
        System.out.println("Hello! Welcome to the Restaurant Menu Management Tool, what action would you like to take today?");

        while (!loopStatus) {
            System.out.println("1: Print Menu, 2: Add Item from Menu, 3: Remove Item to Menu , or enter END to end the application");

            String userInput = input.nextLine().toUpperCase();
            if ("1".equals(userInput)) {
                    for (MenuItem items : menuItems) {
                        System.out.println(items.printSingleItem(items));
                }
            } else if ("2".equals(userInput)) {
                MenuItem newMenuItem = new MenuItem();
                newMenuItem.createMenuItem();
                menuItems.add(newMenuItem);
            } else if ("3".equals(userInput)) {
                menu.removeMenuItem();
            }
            if ("END".equals(userInput)) {
                menu.saveMenuItemsToFile(menuItems);
                loopStatus = true;
            }
        }
    }
}


