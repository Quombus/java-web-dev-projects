package org.launchcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class ArrayPractice {
    public static void main(String[] args) {
//        int[] integerArray1 = {1, 1, 2, 3, 5, 8};

//        String foxSentence = "I would not, could not, in a box. I would not, could not with a fox. I will not eat them in a house. I will not eat them with a mouse.";

//        for (int i = 0; i < integerArray.length; i++) {
//            if (integerArray[i] % 2 == 1) {
//                System.out.println(integerArray1[i]);
//            }
//        }

//        String[] stringArray = foxSentence.split("[\\,\\.\\s]");
//        System.out.println(Arrays.toString(stringArray));
//        for (String s: stringArray) {
//            System.out.println(s);
//        }
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("fivee");
        stringArrayList.add("fivee");
        stringArrayList.add("fivee");
        stringArrayList.add("six");
        stringArrayList.add("right");
        stringArrayList.add("two");
        stringArrayList.add("o");
        stringArrayList.add("ew");
        stringArrayList.add("ew");

        System.out.println(WordPrint.wordPrint(stringArrayList));
        System.out.println(ScannerWordPrint.wordPrint(stringArrayList));

//        ArrayList<Integer> integerArrayList = new ArrayList<>();
//        integerArrayList.add(33);
//        integerArrayList.add(15);
//        integerArrayList.add(20);
//        integerArrayList.add(34);
//        integerArrayList.add(8);
//        integerArrayList.add(12);
//        integerArrayList.add(33);
//        integerArrayList.add(15);
//        integerArrayList.add(20);
//        integerArrayList.add(34);
//        integerArrayList.add(8);
//        integerArrayList.add(12);
//
//        SumEven.sumEven(integerArrayList);
//        System.out.println( SumEven.sumEven(integerArrayList));

    }
}
