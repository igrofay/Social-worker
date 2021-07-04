package com.example.socialworker.entity;

import android.os.Parcel;
import android.os.Parcelable;

//Вид социальных улсуг, справочник
public class TypeSocialService {
    private int typeID;
    private String typeNAME ;

    public TypeSocialService(){}


    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeNAME() {
        return typeNAME;
    }

    public void setTypeNAME(String typeNAME) {
        this.typeNAME = typeNAME;
    }
}
