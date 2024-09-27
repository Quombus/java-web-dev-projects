package org.launchcode;

import java.util.ArrayList;

public abstract class BaseDisc implements OpticalDisc {

    public BaseDisc(ArrayList<String> contentsOfDisc) {
    }

    public void setStorageCapacity(double storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    private double storageCapacity;
    private ArrayList<String> contentsOfDisc;


    public BaseDisc(double storageCapacity, ArrayList<String> contentsOfDisc) {
        this.storageCapacity = storageCapacity;
        this.contentsOfDisc = contentsOfDisc;
    }

    public ArrayList<String> getContentsOfDisc() {
        return contentsOfDisc;
    }

    public void setContentsOfDisc(ArrayList<String> contentsOfDisc) {
        this.contentsOfDisc = contentsOfDisc;
    }

    public void writeDataTo(String newFile) {
        contentsOfDisc.add(newFile);
    }

    public abstract void reWriteData(String fileName);
}
