package org.launchcode;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> content = new ArrayList<>();

        content.add("La La Land");
        // TODO: Declare and initialize a CD and a DVD object.
        DVD dvd = new DVD(content);
        // TODO: Call each CD and DVD method to verify that they work as expected.
        dvd.spinDisc();
        dvd.reWriteData("Jerry Springer");
        dvd.reportInfoFromDisc();
    }
}