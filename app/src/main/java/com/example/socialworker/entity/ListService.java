package com.example.socialworker.entity;

import android.os.Parcel;
import android.os.Parcelable;

// План оказания социальных
public class ListService implements Parcelable {
    private int listServiceID;
    private int servicePlannedSchedule ; // Календарный план социального работника,  ссылается на PlannedSchedule(ID)
    private int socialServices_id ; // Социальные услуги, тип Lookup, ссылается на SocialService(ID)
    private int listServiceVolume ;// Количество услуг
    private long  listServiceScope ;// Объем услуги
    private SocialService socialService; // Получение по ID
    public int getListServiceID() {
        return listServiceID;
    }

    public void setListServiceID(int listServiceID) {
        this.listServiceID = listServiceID;
    }

    public int getServicePlannedSchedule() {
        return servicePlannedSchedule;
    }

    public void setServicePlannedSchedule(int servicePlannedSchedule) {
        this.servicePlannedSchedule = servicePlannedSchedule;
    }

    public int getSocialServices_id() {
        return socialServices_id;
    }

    public void setSocialServices_id(int socialServices_id) {
        this.socialServices_id = socialServices_id;
    }

    public int getListServiceVolume() {
        return listServiceVolume;
    }

    public void setListServiceVolume(int listServiceVolume) {
        this.listServiceVolume = listServiceVolume;
    }

    public long getListServiceScope() {
        return listServiceScope;
    }

    public void setListServiceScope(long listServiceScope) {
        this.listServiceScope = listServiceScope;
    }

    public SocialService getSocialService() {
        return socialService;
    }

    public void setSocialService(SocialService socialService) {
        this.socialService = socialService;
    }


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
