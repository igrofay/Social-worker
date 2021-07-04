package com.example.socialworker.entity;

import android.os.Parcel;
import android.os.Parcelable;

// Единица измерения социальных уcлуг, справочник
public class Unit implements Parcelable {
    int unitID ;
    String unitNAME ;

    public Unit(){}
    protected Unit(Parcel in) {
        unitID = in.readInt();
        unitNAME = in.readString();
    }

    public static final Creator<Unit> CREATOR = new Creator<Unit>() {
        @Override
        public Unit createFromParcel(Parcel in) {
            return new Unit(in);
        }

        @Override
        public Unit[] newArray(int size) {
            return new Unit[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(unitID);
        dest.writeString(unitNAME);
    }
}
