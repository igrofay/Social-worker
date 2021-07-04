package com.example.socialworker.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

//Социальный работник
public class SocialWorker{
    private int socialWorkerID;
    private String socialWorkerFIO ;
    private String socialWorkerLogin;
    private String socialWorkerPassword;
    private String socialWorkerPosition ; // Наименование должности
    private String socialWorkerDepartment; // Наименование отделения
    private String socialWorkerOrganization ; // Наименование учреждения

    private List<PlannedSchedule> plannedScheduleList; // Получение по полю ScheduleSocialWorker


    public  SocialWorker(){}


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


}
