package com.example.socialworker.entity;

import android.os.Parcel;
import android.os.Parcelable;

//Договор о предоставлении социальных услуг
public class RecipientDocument implements Parcelable {

    int recipientDocumentID ;
    int recipientDocumentRecipient ; // Получатель социальных услуг, ссылается на Recipients(ID)
    String recipientDocumentNum ; // Номер договора
    String recipientDocumentStartDate ; // Дата начала действия договора
    String recipientDocumentEndDate ; // Дата окончания действия договора
    boolean recipientDocumentStaus ;// Статус договора
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
}
