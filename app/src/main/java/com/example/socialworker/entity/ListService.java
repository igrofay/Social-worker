package com.example.socialworker.entity;

import android.os.Parcel;
import android.os.Parcelable;

// План оказания социальных
public class ListService  {
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



}
