package com.example.socialworker.entity;


import android.os.Parcel;
import android.os.Parcelable;

// Социальные услуги, справочник
public class SocialService implements Parcelable {
    int socialServiceID ;
    String socialServiceCode;
    String socialServiceNAME ;
    int socialServiceForm ; // Форма социальной услуги, ссылается на Forms(ID)
    int socialServiceType ; // Форма социальной услуги, ссылается на TypeSocialService(ID)
    int socialServiceExecutionTime ;// Лимит времени оказания услуги (в минутах)

    Form form ; // Получение по ID
    TypeSocialService typeSocialService; // Получение по ID
    Tarif tarif ; // Получение по TarifSocialServiceID

    public SocialService(){}

    protected SocialService(Parcel in) {
        socialServiceID = in.readInt();
        socialServiceCode = in.readString();
        socialServiceNAME = in.readString();
        socialServiceForm = in.readInt();
        socialServiceType = in.readInt();
        socialServiceExecutionTime = in.readInt();
        form = in.readParcelable(Form.class.getClassLoader());
        typeSocialService = in.readParcelable(TypeSocialService.class.getClassLoader());
        tarif = in.readParcelable(Tarif.class.getClassLoader());
    }

    public static final Creator<SocialService> CREATOR = new Creator<SocialService>() {
        @Override
        public SocialService createFromParcel(Parcel in) {
            return new SocialService(in);
        }

        @Override
        public SocialService[] newArray(int size) {
            return new SocialService[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(socialServiceID);
        dest.writeString(socialServiceCode);
        dest.writeString(socialServiceNAME);
        dest.writeInt(socialServiceForm);
        dest.writeInt(socialServiceType);
        dest.writeInt(socialServiceExecutionTime);
        dest.writeParcelable(form, flags);
        dest.writeParcelable(typeSocialService, flags);
        dest.writeParcelable(tarif, flags);
    }
}
