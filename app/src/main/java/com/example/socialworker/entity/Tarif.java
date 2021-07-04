package com.example.socialworker.entity;

import android.os.Parcel;
import android.os.Parcelable;

// Тариф на социальные услуги
public class Tarif  {
    private int tarifID;
    private int tarifSocialServiceID ; //Социальные услуги, ссылается на SocialService(ID)
    private int socialServiceUnit ; // Единицы измерения социальных улуг, ссылается на Units(ID)
    private String tarifStart ; // Дата начала действия
    private String tarifEnd ;// Дата окончания действия
    private String tarifPrice ; // Стоимость услуги

    private Unit unit ; // Получение по ID
    public Tarif(){}


    public int getTarifID() {
        return tarifID;
    }

    public void setTarifID(int tarifID) {
        this.tarifID = tarifID;
    }

    public int getTarifSocialServiceID() {
        return tarifSocialServiceID;
    }

    public void setTarifSocialServiceID(int tarifSocialServiceID) {
        this.tarifSocialServiceID = tarifSocialServiceID;
    }

    public int getSocialServiceUnit() {
        return socialServiceUnit;
    }

    public void setSocialServiceUnit(int socialServiceUnit) {
        this.socialServiceUnit = socialServiceUnit;
    }

    public String getTarifStart() {
        return tarifStart;
    }

    public void setTarifStart(String tarifStart) {
        this.tarifStart = tarifStart;
    }

    public String getTarifEnd() {
        return tarifEnd;
    }

    public void setTarifEnd(String tarifEnd) {
        this.tarifEnd = tarifEnd;
    }

    public String getTarifPrice() {
        return tarifPrice;
    }

    public void setTarifPrice(String tarifPrice) {
        this.tarifPrice = tarifPrice;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
