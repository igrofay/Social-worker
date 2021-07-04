package com.example.socialworker.entity;

import android.os.Parcel;
import android.os.Parcelable;

// Клиент
public class Recipient implements Parcelable {
    private int recipientID ;
    private String recipientFIO;
    private String recipientDR ; // День рождения
    private String recipientAdress ; // Адрес проживания
    private String recipientAdressLatitude ; // Широта адреса проживания
    private String recipientAdressLongitude; // Долгота адреса проживания
    private String recipientContact ; // Контактный номер телефона
    private String recipientQRCode ; //QR-code договора/УКО получателя

    public String getRecipientQRCode() {
        return recipientQRCode;
    }

    public void setRecipientQRCode(String recipientQRCode) {
        this.recipientQRCode = recipientQRCode;
    }

    RecipientDocument recipientDocument ; // Получение по RecipientDocumentRecipient
    public Recipient(){}

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

    public int getRecipientID() {
        return recipientID;
    }

    public void setRecipientID(int recipientID) {
        this.recipientID = recipientID;
    }

    public String getRecipientFIO() {
        return recipientFIO;
    }

    public void setRecipientFIO(String recipientFIO) {
        this.recipientFIO = recipientFIO;
    }

    public String getRecipientDR() {
        return recipientDR;
    }

    public void setRecipientDR(String recipientDR) {
        this.recipientDR = recipientDR;
    }

    public String getRecipientAdress() {
        return recipientAdress;
    }

    public void setRecipientAdress(String recipientAdress) {
        this.recipientAdress = recipientAdress;
    }

    public String getRecipientAdressLatitude() {
        return recipientAdressLatitude;
    }

    public void setRecipientAdressLatitude(String recipientAdressLatitude) {
        this.recipientAdressLatitude = recipientAdressLatitude;
    }

    public String getRecipientAdressLongitude() {
        return recipientAdressLongitude;
    }

    public void setRecipientAdressLongitude(String recipientAdressLongitude) {
        this.recipientAdressLongitude = recipientAdressLongitude;
    }

    public String getRecipientContact() {
        return recipientContact;
    }

    public void setRecipientContact(String recipientContact) {
        this.recipientContact = recipientContact;
    }

    public RecipientDocument getRecipientDocument() {
        return recipientDocument;
    }

    public void setRecipientDocument(RecipientDocument recipientDocument) {
        this.recipientDocument = recipientDocument;
    }

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
        dest.writeString(recipientQRCode);
        dest.writeParcelable(recipientDocument, flags);
    }
}
