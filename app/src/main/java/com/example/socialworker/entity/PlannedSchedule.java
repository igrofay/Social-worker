package com.example.socialworker.entity;

import android.os.Parcel;
import android.os.Parcelable;

// "Кусок" календарного плана
public class PlannedSchedule implements Parcelable {
    int scheduleID;
    int scheduleRecipient; // Получатель социальных услуг, ссылается на Recipient (ID)
    int scheduleSocialWorker ; // Социальный работник, ссылается на SocialWorker(ID)
    String scheduleStartPlanned; // Плановые дата и время начала предоставления социальных услуг, тип DateTime
    String scheduleEndPlanned ; // Плановые дата и время окончания предоставления социальных услуг, тип DateTime
    boolean scheduleStatus ; // Статус элемента true = действует ; false = не действует

    Recipient recipient; // Получение через ID
    ListService listService; // Получению по полю ServicePlannedSchedule
    public  PlannedSchedule(){}


    protected PlannedSchedule(Parcel in) {
        scheduleID = in.readInt();
        scheduleRecipient = in.readInt();
        scheduleSocialWorker = in.readInt();
        scheduleStartPlanned = in.readString();
        scheduleEndPlanned = in.readString();
        scheduleStatus = in.readByte() != 0;
        recipient = in.readParcelable(Recipient.class.getClassLoader());
        listService = in.readParcelable(ListService.class.getClassLoader());
    }

    public static final Creator<PlannedSchedule> CREATOR = new Creator<PlannedSchedule>() {
        @Override
        public PlannedSchedule createFromParcel(Parcel in) {
            return new PlannedSchedule(in);
        }

        @Override
        public PlannedSchedule[] newArray(int size) {
            return new PlannedSchedule[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(scheduleID);
        dest.writeInt(scheduleRecipient);
        dest.writeInt(scheduleSocialWorker);
        dest.writeString(scheduleStartPlanned);
        dest.writeString(scheduleEndPlanned);
        dest.writeByte((byte) (scheduleStatus ? 1 : 0));
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public int getScheduleRecipient() {
        return scheduleRecipient;
    }

    public void setScheduleRecipient(int scheduleRecipient) {
        this.scheduleRecipient = scheduleRecipient;
    }

    public int getScheduleSocialWorker() {
        return scheduleSocialWorker;
    }

    public void setScheduleSocialWorker(int scheduleSocialWorker) {
        this.scheduleSocialWorker = scheduleSocialWorker;
    }

    public String getScheduleStartPlanned() {
        return scheduleStartPlanned;
    }

    public void setScheduleStartPlanned(String scheduleStartPlanned) {
        this.scheduleStartPlanned = scheduleStartPlanned;
    }

    public String getScheduleEndPlanned() {
        return scheduleEndPlanned;
    }

    public void setScheduleEndPlanned(String scheduleEndPlanned) {
        this.scheduleEndPlanned = scheduleEndPlanned;
    }

    public boolean isScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(boolean scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public ListService getListService() {
        return listService;
    }

    public void setListService(ListService listService) {
        this.listService = listService;
    }

    public static Creator<PlannedSchedule> getCREATOR() {
        return CREATOR;
    }
}
