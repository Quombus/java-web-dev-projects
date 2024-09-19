package org.launchcode;

import java.util.*;

public class MenuItem {
    private double price;
    private String description;
    private String category;
    private boolean isNew;

    public MenuItem(double p, String d, String c, boolean iN) {
        this.price = p;
        this.description = d;
        this.category = c;
        this.isNew = iN;
    }

    public MenuItem(){
    }

    public double getPrice() {
        return price;
    }

    public boolean isNew() {
        return isNew;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public String printSingleItem(MenuItem menuItem) {
        String result = description + " " + category + " for " + price;
        if (isNew) {
            result += " Hot New Feature";
        }
        return result;
    }
    public MenuItem createMenuItem()  {
        MenuItem newMenuItem = new MenuItem();
        String description = "";
        String category = "";
        double price = 0.0;
        boolean isNew = true;
        boolean validCategory = false;
        List<String> categories = Arrays.asList("appetizer", "main course", "dessert");
        Scanner input = new Scanner(System.in);

        System.out.println("what is the description of the new item?");
        description = input.nextLine().toLowerCase().trim();
        this.setDescription(description);

        while (!validCategory) {
            System.out.println("Is this food item an Appetizer, Main Course, or a Dessert?");
            category = input.nextLine().toLowerCase().trim();
            if (categories.contains(category)) {
                this.setCategory(category);
                validCategory = true;
            } else {
                System.out.println("oops! please enter a valid response! Thank you!");
            }
        }
        System.out.println("What is the price of the new Menu Item?");
        price = input.nextDouble();
        this.setPrice(price);
        this.setNew(isNew);
        return newMenuItem;
    }

}

