package org.launchcode;


import java.util.Scanner;
import studios.areaofacircle.Circle;
import java.util.concurrent.ExecutionException;
import static java.lang.Double.isNaN;

public class Area {
    public static void main(String[] args) {
        String radius = "";
       double radiusDouble = 0;
        Scanner input;

        input = new Scanner(System.in);
        System.out.println("Enter a radius:");
        radius = input.nextLine();
        try {
            radiusDouble = Double.parseDouble(radius);
            System.out.println(radiusDouble);
        } catch (NumberFormatException e) {

            System.out.println("it works");
            System.out.println("Enter a radius:");
            radius = input.nextLine();

        }

//        if (isNaN(radiusDouble)) {
//            System.out.println("it works");
//            System.out.println("Please enter number");
//            System.out.println("Enter a radius:");
//            radius = input.nextLine();
        }

//        double circleArea = Circle.getArea(radius);
//        System.out.println("The area of a circle of radius "  + radius + " is " + circleArea);
    }

