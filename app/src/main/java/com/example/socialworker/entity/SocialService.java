package com.example.socialworker.entity;


import android.os.Parcel;
import android.os.Parcelable;

// Социальные услуги, справочник
public class SocialService  {
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
