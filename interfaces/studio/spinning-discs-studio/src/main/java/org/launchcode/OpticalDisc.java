package org.launchcode;

public interface OpticalDisc {

    default void printHello() {
        System.out.println("Hello");
    }
     void spinDisc();
     void reportInfoFromDisc();
     void reWriteData(String filename);
}