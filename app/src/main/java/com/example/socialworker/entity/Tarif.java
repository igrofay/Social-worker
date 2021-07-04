package com.example.socialworker.entity;

import android.os.Parcel;
import android.os.Parcelable;

// Тариф на социальные услуги
public class Tarif implements Parcelable {
    int tarifID;
    int tarifSocialServiceID ; //Социальные услуги, ссылается на SocialService(ID)
    int socialServiceUnit ; // Единицы измерения социальных улуг, ссылается на Units(ID)
    String tarifStart ; // Дата начала действия
    String tarifEnd ;// Дата окончания действия
    int tarifPrice ; // Стоимость услуги

    Unit unit ; // Получение по ID
    public Tarif(){}
    protected Tarif(Parcel in) {
        tarifID = in.readInt();
        tarifSocialServiceID = in.readInt();
        socialServiceUnit = in.readInt();
        tarifStart = in.readString();
        tarifEnd = in.readString();
        tarifPrice = in.readInt();
        unit = in.readParcelable(Unit.class.getClassLoader());
    }

    public static final Creator<Tarif> CREATOR = new Creator<Tarif>() {
        @Override
        public Tarif createFromParcel(Parcel in) {
            return new Tarif(in);
        }

        @Override
        public Tarif[] newArray(int size) {
            return new Tarif[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(tarifID);
        dest.writeInt(tarifSocialServiceID);
        dest.writeInt(socialServiceUnit);
        dest.writeString(tarifStart);
        dest.writeString(tarifEnd);
        dest.writeInt(tarifPrice);
        dest.writeParcelable(unit, flags);
    }
}
