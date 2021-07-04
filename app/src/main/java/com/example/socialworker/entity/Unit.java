package com.example.socialworker.entity;

import android.os.Parcel;
import android.os.Parcelable;

// Единица измерения социальных уcлуг, справочник
public class Unit {
    private int unitID ;
    private String unitNAME ;

    public Unit(){}


    public int getUnitID() {
        return unitID;
    }

    public void setUnitID(int unitID) {
        this.unitID = unitID;
    }

    public String getUnitNAME() {
        return unitNAME;
    }

    public void setUnitNAME(String unitNAME) {
        this.unitNAME = unitNAME;
    }
}
