package com.example.socialworker.entity;

import android.os.Parcel;
import android.os.Parcelable;

// Форма социального обслуживания, справочник
public class Form implements Parcelable {
    private int formID;
    private String formNAME;

    protected Form(Parcel in) {
        formID = in.readInt();
        formNAME = in.readString();
    }
    public Form(){}
    public static final Creator<Form> CREATOR = new Creator<Form>() {
        @Override
        public Form createFromParcel(Parcel in) {
            return new Form(in);
        }

        @Override
        public Form[] newArray(int size) {
            return new Form[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(formID);
        dest.writeString(formNAME);
    }

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
