package com.example.socialworker.entity;

import android.os.Parcel;
import android.os.Parcelable;

// План оказания социальных
public class ListService implements Parcelable {
    int listServiceID;
    int servicePlannedSchedule ; // Календарный план социального работника,  ссылается на PlannedSchedule(ID)
    int socialServices_id ; // Социальные услуги, тип Lookup, ссылается на SocialService(ID)
    int listServiceVolume ;// Количество услуг
    long  listServiceScope ;// Объем услуги

    SocialService socialService; // Получение по ID
    public ListService(){}


    protected ListService(Parcel in) {
        listServiceID = in.readInt();
        servicePlannedSchedule = in.readInt();
        socialServices_id = in.readInt();
        listServiceVolume = in.readInt();
        listServiceScope = in.readLong();
        socialService = in.readParcelable(SocialService.class.getClassLoader());
    }

    public static final Creator<ListService> CREATOR = new Creator<ListService>() {
        @Override
        public ListService createFromParcel(Parcel in) {
            return new ListService(in);
        }

        @Override
        public ListService[] newArray(int size) {
            return new ListService[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(listServiceID);
        dest.writeInt(servicePlannedSchedule);
        dest.writeInt(socialServices_id);
        dest.writeInt(listServiceVolume);
        dest.writeLong(listServiceScope);
    }
}
