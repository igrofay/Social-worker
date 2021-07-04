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
    boolean scheduleStatus ; // Статус элемента

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
}
