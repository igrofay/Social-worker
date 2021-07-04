package com.example.socialworker.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

//Социальный работник
public class SocialWorker implements Parcelable {
    private int socialWorkerID;
    private String socialWorkerFIO ;
    private String socialWorkerLogin;
    private String socialWorkerPassword;
    private String socialWorkerPosition ; // Наименование должности
    private String socialWorkerDepartment; // Наименование отделения
    private String socialWorkerOrganization ; // Наименование учреждения

    private List<PlannedSchedule> plannedScheduleList; // Получение по полю ScheduleSocialWorker


    public  SocialWorker(){}
    protected SocialWorker(Parcel in) {
        socialWorkerID = in.readInt();
        socialWorkerFIO = in.readString();
        socialWorkerLogin = in.readString();
        socialWorkerPassword = in.readString();
        socialWorkerPosition = in.readString();
        socialWorkerDepartment = in.readString();
        socialWorkerOrganization = in.readString();
        plannedScheduleList = in.createTypedArrayList(PlannedSchedule.CREATOR);
    }

    public static final Creator<SocialWorker> CREATOR = new Creator<SocialWorker>() {
        @Override
        public SocialWorker createFromParcel(Parcel in) {
            return new SocialWorker(in);
        }

        @Override
        public SocialWorker[] newArray(int size) {
            return new SocialWorker[size];
        }
    };

    public int getSocialWorkerID() {
        return socialWorkerID;
    }

    public void setSocialWorkerID(int socialWorkerID) {
        this.socialWorkerID = socialWorkerID;
    }

    public String getSocialWorkerFIO() {
        return socialWorkerFIO;
    }

    public void setSocialWorkerFIO(String socialWorkerFIO) {
        this.socialWorkerFIO = socialWorkerFIO;
    }

    public String getSocialWorkerLogin() {
        return socialWorkerLogin;
    }

    public void setSocialWorkerLogin(String socialWorkerLogin) {
        this.socialWorkerLogin = socialWorkerLogin;
    }

    public String getSocialWorkerPassword() {
        return socialWorkerPassword;
    }

    public void setSocialWorkerPassword(String socialWorkerPassword) {
        this.socialWorkerPassword = socialWorkerPassword;
    }

    public String getSocialWorkerPosition() {
        return socialWorkerPosition;
    }

    public void setSocialWorkerPosition(String socialWorkerPosition) {
        this.socialWorkerPosition = socialWorkerPosition;
    }

    public String getSocialWorkerDepartment() {
        return socialWorkerDepartment;
    }

    public void setSocialWorkerDepartment(String socialWorkerDepartment) {
        this.socialWorkerDepartment = socialWorkerDepartment;
    }

    public String getSocialWorkerOrganization() {
        return socialWorkerOrganization;
    }

    public void setSocialWorkerOrganization(String socialWorkerOrganization) {
        this.socialWorkerOrganization = socialWorkerOrganization;
    }

    public List<PlannedSchedule> getPlannedScheduleList() {
        return plannedScheduleList;
    }

    public void setPlannedScheduleList(List<PlannedSchedule> plannedScheduleList) {
        this.plannedScheduleList = plannedScheduleList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(socialWorkerID);
        dest.writeString(socialWorkerFIO);
        dest.writeString(socialWorkerLogin);
        dest.writeString(socialWorkerPassword);
        dest.writeString(socialWorkerPosition);
        dest.writeString(socialWorkerDepartment);
        dest.writeString(socialWorkerOrganization);
        dest.writeTypedList(plannedScheduleList);
    }
}
