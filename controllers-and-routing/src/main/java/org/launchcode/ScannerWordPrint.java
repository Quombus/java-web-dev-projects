package org.launchcode;

import java.util.ArrayList;
import java.util.Scanner;

public class ScannerWordPrint { public static String wordPrint(ArrayList<String> str) {
    ArrayList<String> stringList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    System.out.println("type in a number, fucker");
    int userStringLength = input.nextInt();

    for (String string : str) {
        if (string.length() == userStringLength) {
            stringList.add(string);
        }
    }
    String joinedList = stringList.toString();
    return joinedList;

}
}
