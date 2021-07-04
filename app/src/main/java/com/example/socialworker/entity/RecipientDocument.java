package com.example.socialworker.entity;

import android.os.Parcel;
import android.os.Parcelable;

//Договор о предоставлении социальных услуг
public class RecipientDocument implements Parcelable {

    private int recipientDocumentID ;
    private int recipientDocumentRecipient ; // Получатель социальных услуг, ссылается на Recipients(ID)
    private String recipientDocumentNum ; // Номер договора
    private String recipientDocumentStartDate ; // Дата начала действия договора
    private String recipientDocumentEndDate ; // Дата окончания действия договора
    private boolean recipientDocumentStaus ;// Статус договора
    public RecipientDocument(){}
    protected RecipientDocument(Parcel in) {
        recipientDocumentID = in.readInt();
        recipientDocumentRecipient = in.readInt();
        recipientDocumentNum = in.readString();
        recipientDocumentStartDate = in.readString();
        recipientDocumentEndDate = in.readString();
        recipientDocumentStaus = in.readByte() != 0;
    }

    public static final Creator<RecipientDocument> CREATOR = new Creator<RecipientDocument>() {
        @Override
        public RecipientDocument createFromParcel(Parcel in) {
            return new RecipientDocument(in);
        }

        @Override
        public RecipientDocument[] newArray(int size) {
            return new RecipientDocument[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(recipientDocumentID);
        dest.writeInt(recipientDocumentRecipient);
        dest.writeString(recipientDocumentNum);
        dest.writeString(recipientDocumentStartDate);
        dest.writeString(recipientDocumentEndDate);
        dest.writeByte((byte) (recipientDocumentStaus ? 1 : 0));
    }

    public int getRecipientDocumentID() {
        return recipientDocumentID;
    }

    public void setRecipientDocumentID(int recipientDocumentID) {
        this.recipientDocumentID = recipientDocumentID;
    }

    public int getRecipientDocumentRecipient() {
        return recipientDocumentRecipient;
    }

    public void setRecipientDocumentRecipient(int recipientDocumentRecipient) {
        this.recipientDocumentRecipient = recipientDocumentRecipient;
    }

    public String getRecipientDocumentNum() {
        return recipientDocumentNum;
    }

    public void setRecipientDocumentNum(String recipientDocumentNum) {
        this.recipientDocumentNum = recipientDocumentNum;
    }

    public String getRecipientDocumentStartDate() {
        return recipientDocumentStartDate;
    }

    public void setRecipientDocumentStartDate(String recipientDocumentStartDate) {
        this.recipientDocumentStartDate = recipientDocumentStartDate;
    }

    public String getRecipientDocumentEndDate() {
        return recipientDocumentEndDate;
    }

    public void setRecipientDocumentEndDate(String recipientDocumentEndDate) {
        this.recipientDocumentEndDate = recipientDocumentEndDate;
    }

    public boolean isRecipientDocumentStaus() {
        return recipientDocumentStaus;
    }

    public void setRecipientDocumentStaus(boolean recipientDocumentStaus) {
        this.recipientDocumentStaus = recipientDocumentStaus;
    }
}
