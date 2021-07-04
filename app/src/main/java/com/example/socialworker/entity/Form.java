package com.example.socialworker.entity;

import android.os.Parcel;
import android.os.Parcelable;

// Форма социального обслуживания, справочник
public class Form {
    private int formID;
    private String formNAME;

    protected Form(Parcel in) {
        formID = in.readInt();
        formNAME = in.readString();
    }
    public Form(){}


    public int getFormID() {
        return formID;
    }

    public void setFormID(int formID) {
        this.formID = formID;
    }

    public String getFormNAME() {
        return formNAME;
    }

    public void setFormNAME(String formNAME) {
        this.formNAME = formNAME;
    }
}
