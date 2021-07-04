package com.example.socialworker.entity;

import android.os.Parcel;
import android.os.Parcelable;

// Клиент
public class Recipient implements Parcelable {
    int recipientID ;
    String recipientFIO;
    String recipientDR ; // День рождения
    String recipientAdress ; // Адрес проживания
    String recipientAdressLatitude ; // Широта адреса проживания
    String recipientAdressLongitude; // Долгота адреса проживания
    String recipientContact ; // Контактный номер телефона

    RecipientDocument recipientDocument ; // Получение по RecipientDocumentRecipient
    public Recipient(){}


    protected Recipient(Parcel in) {
        recipientID = in.readInt();
        recipientFIO = in.readString();
        recipientDR = in.readString();
        recipientAdress = in.readString();
        recipientAdressLatitude = in.readString();
        recipientAdressLongitude = in.readString();
        recipientContact = in.readString();
        recipientDocument = in.readParcelable(RecipientDocument.class.getClassLoader());
    }

    public static final Creator<Recipient> CREATOR = new Creator<Recipient>() {
        @Override
        public Recipient createFromParcel(Parcel in) {
            return new Recipient(in);
        }

        @Override
        public Recipient[] newArray(int size) {
            return new Recipient[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(recipientID);
        dest.writeString(recipientFIO);
        dest.writeString(recipientDR);
        dest.writeString(recipientAdress);
        dest.writeString(recipientAdressLatitude);
        dest.writeString(recipientAdressLongitude);
        dest.writeString(recipientContact);
    }
}
