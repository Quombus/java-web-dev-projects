package org.launchcode;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Menu {
    private Date lastUpdated;
    private ArrayList<MenuItem> items;

    public Menu(Date d, ArrayList<MenuItem> i) {
        this.lastUpdated = d;
        this.items = i;
    }
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public ArrayList<MenuItem> removeMenuItem (){
        Scanner input = new Scanner(System.in);
        String removedItem = "";
        Iterator<MenuItem> itr = items.iterator();
        ArrayList<String> menuItemDescriptions = new ArrayList<>();
        boolean validItem = false;

        for (MenuItem menuItem : items) {
            menuItemDescriptions.add(menuItem.getDescription());
        }
        for (MenuItem menuItem : items) {
            System.out.println(menuItem.printSingleItem(menuItem));
            System.out.println();
        }
        System.out.println("Select what Menu Item you would like to remove, please!");
        System.out.println("Enter NO if no selection is need at this time");

        while (!validItem) {
            removedItem = input.nextLine().toLowerCase().trim();
            if (menuItemDescriptions.contains(removedItem)) {
                validItem = true;
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
        return items;
    }

    public void readMenuFromFile(ArrayList<MenuItem> menuItems) {
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
    }

    public void saveMenuItemsToFile(ArrayList<MenuItem> menuItems){
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
    }


}


