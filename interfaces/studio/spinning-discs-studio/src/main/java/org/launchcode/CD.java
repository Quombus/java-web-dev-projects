package org.launchcode;

import java.util.ArrayList;

public class CD extends BaseDisc {

    // TODO: Implement your custom interface.


    @Override
    public void spinDisc() {
        System.out.println("A CD spins at a rate of 200 - 500 rpm.");
    }

    @Override
    public void reportInfoFromDisc() {
        for (String fileName : getContentsOfDisc()) {
            System.out.println(fileName);
        }
    }



    // TODO: Determine which fields, methods, and constructors can be extended from the base class and which ones
    //  need to be declared separately.

    public CD(ArrayList<String> contentsOfDisc) {
        super(.700, contentsOfDisc);

    }

    @Override
    public void reWriteData(String fileName) {
       getContentsOfDisc().add(fileName);
    }
}
