package com.example.socialworker.entity;


import android.os.Parcel;
import android.os.Parcelable;

// Социальные услуги, справочник
public class SocialService implements Parcelable {
    private int socialServiceID ;
    private String socialServiceCode;
    private String socialServiceNAME ;
    private int socialServiceForm ; // Форма социальной услуги, ссылается на Forms(ID)
    private int socialServiceType ; // Форма социальной услуги, ссылается на TypeSocialService(ID)
    private String socialServiceExecutionTime ;// Лимит времени оказания услуги (в минутах)
    private int socialServiceTypeTarif ;

    private Form form ; // Получение по ID
    private TypeSocialService typeSocialService; // Получение по ID
    private Tarif tarif ; // Получение по TarifSocialServiceID

    public SocialService(){}

    protected SocialService(Parcel in) {
        socialServiceID = in.readInt();
        socialServiceCode = in.readString();
        socialServiceNAME = in.readString();
        socialServiceForm = in.readInt();
        socialServiceType = in.readInt();
        socialServiceExecutionTime = in.readString();
        socialServiceTypeTarif = in.readInt();
        form = in.readParcelable(Form.class.getClassLoader());
        typeSocialService = in.readParcelable(TypeSocialService.class.getClassLoader());
        tarif = in.readParcelable(Tarif.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(socialServiceID);
        dest.writeString(socialServiceCode);
        dest.writeString(socialServiceNAME);
        dest.writeInt(socialServiceForm);
        dest.writeInt(socialServiceType);
        dest.writeString(socialServiceExecutionTime);
        dest.writeInt(socialServiceTypeTarif);
        dest.writeParcelable(form, flags);
        dest.writeParcelable(typeSocialService, flags);
        dest.writeParcelable(tarif, flags);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public int getSocialServiceTypeTarif() {
        return socialServiceTypeTarif;
    }

    public void setSocialServiceTypeTarif(int socialServiceTypeTarif) {
        this.socialServiceTypeTarif = socialServiceTypeTarif;
    }


    public int getSocialServiceID() {
        return socialServiceID;
    }

    public void setSocialServiceID(int socialServiceID) {
        this.socialServiceID = socialServiceID;
    }

    public String getSocialServiceCode() {
        return socialServiceCode;
    }

    public void setSocialServiceCode(String socialServiceCode) {
        this.socialServiceCode = socialServiceCode;
    }

    public String getSocialServiceNAME() {
        return socialServiceNAME;
    }

    public void setSocialServiceNAME(String socialServiceNAME) {
        this.socialServiceNAME = socialServiceNAME;
    }

    public int getSocialServiceForm() {
        return socialServiceForm;
    }

    public void setSocialServiceForm(int socialServiceForm) {
        this.socialServiceForm = socialServiceForm;
    }

    public int getSocialServiceType() {
        return socialServiceType;
    }

    public void setSocialServiceType(int socialServiceType) {
        this.socialServiceType = socialServiceType;
    }

    public String getSocialServiceExecutionTime() {
        return socialServiceExecutionTime;
    }

    public void setSocialServiceExecutionTime(String socialServiceExecutionTime) {
        this.socialServiceExecutionTime = socialServiceExecutionTime;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public TypeSocialService getTypeSocialService() {
        return typeSocialService;
    }

    public void setTypeSocialService(TypeSocialService typeSocialService) {
        this.typeSocialService = typeSocialService;
    }

    public Tarif getTarif() {
        return tarif;
    }

    public void setTarif(Tarif tarif) {
        this.tarif = tarif;
    }
}
