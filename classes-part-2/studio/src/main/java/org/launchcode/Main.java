package org.launchcode;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        ArrayList<MenuItem> menuItems = new ArrayList<>(Arrays.asList());
        Date date = new Date(1996 - 1 - 4);
        Menu menu = new Menu(date, menuItems);
        boolean loopStatus = false;
        String isNewOrNot = "";
        String filePath = "C:/Users/becke/Documents/menu-item-list.txt ";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((reader.readLine()) != null) {
                MenuItem item;
                item = new MenuItem();
                item.setDescription(reader.readLine());
                item.setCategory(reader.readLine());
                item.setPrice(Double.parseDouble(reader.readLine()));
                item.setNew("true".equals(reader.readLine()));
                menuItems.add(item);
            }
            reader.close();
            System.out.println("Read went successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Hello! Welcome to the Restaurant Menu Management Tool, what action would you like to take today?");
        System.out.println("1: Print Menu, 2: Add Item from Menu, 3: Remove Item to Menu , or enter END to end the application");

        while (!loopStatus) {
            String userInput = input.nextLine().toUpperCase();
            if ("1".equals(userInput)) {
                for (MenuItem menuItem : menuItems) {
                    System.out.println(menuItem.printSingleItem(menuItem));
                    System.out.println();
                }
                System.out.println("Last Time the Menu was Updated :" + menu.getLastUpdated());
                System.out.println();
                System.out.println("1: Print Menu, 2: Add Item from Menu, 3: Remove Item to Menu , or enter END to end the application");

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

                while (!validCategory) {
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

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    for (MenuItem menuItem : menuItems) {
                        writer.write(newMenuItem.getDescription());
                        writer.newLine();
                        writer.write(newMenuItem.getCategory());
                        writer.newLine();
                        writer.write(Double.toString(newMenuItem.getPrice()));
                        writer.newLine();
                        if (newMenuItem.isNew()) {
                            isNewOrNot = "true";
                        } else {
                            isNewOrNot = "false";
                        }
                        writer.write(isNewOrNot);
                    }
                    System.out.println("ArrayList written to file successfully.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("1: Print Menu, 2: Add Item from Menu, 3: Remove Item to Menu , or enter END to end the application");
            } else if ("3".equals(userInput)) {
                String removedItem = "";
                Iterator<MenuItem> itr = menuItems.iterator();
                ArrayList<String> menuItemDescriptions = new ArrayList<>();
                boolean validItem = false;

                for (MenuItem menuItem : menuItems) {
                    menuItemDescriptions.add(menuItem.getDescription());
                }
                for (MenuItem menuItem : menuItems) {
                    System.out.println(menuItem.printSingleItem(menuItem));
                    System.out.println();
                }
                System.out.println("Select what Menu Item you would like to remove, please!");
                System.out.println("Enter NO if no selection is need at this time");

                while (!validItem) {
                    removedItem = input.nextLine().toLowerCase().trim();
                    if (menuItemDescriptions.contains(removedItem)) {
                        validItem = true;
                    } else if ("no".equals(removedItem)) {
                        continue;
                    } else {
                        System.out.println("please enter a valid menu item, or enter NO to stop removing items");
                    }
                }
                while (itr.hasNext()) {
                    MenuItem item = itr.next();
                    if (removedItem.equals(item.getDescription())) {
                        itr.remove();
                    }
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    for (MenuItem menuItem : menuItems) {
                        writer.write(menuItem.getDescription());
                        writer.newLine();
                        writer.write(menuItem.getCategory());
                        writer.newLine();
                        writer.write(Double.toString(menuItem.getPrice()));
                        writer.newLine();
                        if (menuItem.isNew()) {
                            isNewOrNot = "true";
                        } else {
                            isNewOrNot = "false";
                        }
                        writer.write(isNewOrNot);
                        writer.newLine();
                    }
                    System.out.println("ArrayList written to file successfully.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("1: Print Menu, 2: Add Item from Menu, 3: Remove Item to Menu , or enter END to end the application");
            }
            if ("END".equals(userInput)) {
                loopStatus = true;
            }
        }
    }
}


