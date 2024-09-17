package org.launchcode;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        MenuItem spaghetti = new MenuItem(12.2, "spaghetti", "main course", false);
        MenuItem spaghettiSmall = new MenuItem(6.1, "spaghetti but small", "appetizer", false);
        MenuItem spaghettiVanilla = new MenuItem(12.2, "spaghetti with vanilla ice-cream", "main course", false);

        ArrayList<MenuItem> menuItems = new ArrayList(Arrays.asList(spaghetti, spaghettiVanilla, spaghettiSmall));
        Date date = new Date(1996 - 1 - 4);
        Menu menu = new Menu(date, menuItems);
        boolean loopStatus = false;

        outerloop:
        while (!loopStatus) {
            System.out.println("Hello! Welcome to the Restaurant Menu Management Tool, what action would you like to take today?");
            System.out.println("1: Print Menu, 2: Add Item from Menu, 3: Remove Item to Menu , or enter nothing to end the application");
            String userInput = input.nextLine();

            if ("1".equals(userInput)) {
                for (MenuItem menuItem : menuItems) {
                    System.out.println("Description :" + menuItem.getDescription());
                    System.out.println("Category :" + menuItem.getCategory());
                    System.out.println("Price :" + menuItem.getPrice());
                    System.out.println("");
                }
            } else if ("2".equals(userInput)) {

                MenuItem newMenuItem = new MenuItem();
                String description = "";
                String category = "";
                double price = 0.0;
                boolean isNew = true;
                boolean validCategory = false;
                List<String> categories = Arrays.asList("appetizer", "main course", "dessert");
                Calendar calendar = Calendar.getInstance();
                Date currentDate = calendar.getTime();

                System.out.println("what is the description of the new item?");
                description = input.nextLine().toLowerCase().trim();
                newMenuItem.setDescription(description);

                while (validCategory == false) {
                    System.out.println("Is this food item an Appetizer, Main Course, or a Dessert?");
                    category = input.nextLine().toLowerCase().trim();
                    if (categories.contains(category)) {
                        newMenuItem.setCategory(category);
                        validCategory = true;
                    } else {
                        System.out.println("oops! please enter a valid response! Thank you!");
                    }
                }
                System.out.println("What is the price of the new Menu Item?");
                price = input.nextDouble();
                newMenuItem.setPrice(price);
                newMenuItem.setNew(isNew);
                menuItems.add(newMenuItem);
                menu.setLastUpdated(currentDate);
            }

            else if ("3".equals(userInput)) {
                String removedItem = "";
                boolean validItem = false;

                while (validItem == false) {
                    for (MenuItem menuItem : menuItems) {
                        System.out.println("Description :" + menuItem.getDescription());
                        System.out.println("Category :" + menuItem.getCategory());
                        System.out.println("Price :" + menuItem.getPrice());
                        System.out.println("");
                    }
                    System.out.println("Select what Menu Item you would like to remove, please!");
                    removedItem = input.nextLine().toLowerCase().trim();
                    for (MenuItem menuItem : menuItems) {
                        if (menuItem.getDescription().equals(removedItem)) {
                            menuItems.remove(menuItem);
                        }
                    }
                    continue outerloop;
                }
        }


    }
}
}
