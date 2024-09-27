package org.launchcode;

import java.util.ArrayList;

public class DVD extends BaseDisc {

    public DVD(ArrayList<String> contentsOfDisc) {
        super(4.7, contentsOfDisc);

    }

    // TODO: Implement your custom interface.

    @Override
    public void spinDisc() {
        System.out.println("A DVD spins at a rate of 570 - 1600 rpm.");
    }

    @Override
    public void reportInfoFromDisc() {
        for (String fileName : getContentsOfDisc()) {
            System.out.println(fileName);
        }
    }

    @Override
    public void reWriteData(String fileName) {
        getContentsOfDisc().add(fileName);
    }

    // TODO: Determine which fields, methods, and constructors can be extended from the base class and which ones
    //  need to be declared separately.


}
