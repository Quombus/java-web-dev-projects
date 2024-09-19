package org.launchcode;

import java.io.*;
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

        try{
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/becke/Documents/menu-item-list.txt/"));
            String line;
            while ((line = br.readLine()) != null) {
                MenuItem item = new MenuItem();
                String newItemString = "";

                item.setDescription(line);
                item.setCategory(br.readLine());
                item.setPrice(Double.parseDouble(br.readLine()));
                newItemString = br.readLine();
                if ("true".equals(newItemString)) {
                    item.setNew(true);
                } else {
                    item.setNew(false);
                }
                menuItems.add(item);
            }
            System.out.println("menu loaded successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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

                try{
                    BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/becke/Documents/menu-item-list.txt/"));
                   for (MenuItem menuItem : menuItems) {
                       bw.write(menuItem.getDescription());
                       bw.newLine();
                       bw.write(menuItem.getCategory());
                       bw.newLine();
                       bw.write(Double.toString(menuItem.getPrice()));
                       bw.newLine();
                       if (menuItem.isNew()) {
                           bw.write("true");
                       } else {
                           bw.write("false");
                       }
                       bw.newLine();
                   }
                    bw.close();
                    System.out.println("menu saved successfully");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                loopStatus = true;
            }
        }
    }
}


