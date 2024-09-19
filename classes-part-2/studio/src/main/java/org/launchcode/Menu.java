package org.launchcode;

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

}


