package com.example.socialworker.entity;

import android.os.Parcel;
import android.os.Parcelable;

//Вид социальных улсуг, справочник
public class TypeSocialService implements Parcelable {
    int typeID;
    String typeNAME ;

    public TypeSocialService(){}
    protected TypeSocialService(Parcel in) {
        typeID = in.readInt();
        typeNAME = in.readString();
    }

    public static final Creator<TypeSocialService> CREATOR = new Creator<TypeSocialService>() {
        @Override
        public TypeSocialService createFromParcel(Parcel in) {
            return new TypeSocialService(in);
        }

        @Override
        public TypeSocialService[] newArray(int size) {
            return new TypeSocialService[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(typeID);
        dest.writeString(typeNAME);
    }
}
