package com.example.socialworker.fragments.entity;

public class PlannedScheduls {
    int ScheduleID;
    int ScheduleRecipient; // Получатель социальных услуг, тип Lookup, ссылается на Recipients (ID)
    int ScheduleSocialWorker ; // Социальный работник, тип Lookup, ссылается на SocialWorkers(ID)
    String ScheduleStartPlanned; // Плановые дата и время начала предоставления социальных услуг, тип DateTime
    String ScheduleEndPlanned ; // Плановые дата и время окончания предоставления социальных услуг, тип DateTime
    boolean ScheduleStatus ; // Статус элемента, тип Bool

    Recipients recipients ; // Получение через ID
}
