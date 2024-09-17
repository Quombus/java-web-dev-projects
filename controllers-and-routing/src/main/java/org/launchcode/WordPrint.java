package org.launchcode;

import java.util.ArrayList;

public class WordPrint {

    public static String wordPrint(ArrayList<String> str) {
        ArrayList<String> stringList = new ArrayList<>();
        for (String string : str) {
            if (string.length() == 5) {
                stringList.add(string);
            }
        }
        String joinedList = stringList.toString();
        return joinedList;

    }}

