package com.example.socialworker.entity;

// "Кусок" календарного плана
public class PlannedSchedule {
    int scheduleID;
    int scheduleRecipient; // Получатель социальных услуг, ссылается на Recipient (ID)
    int scheduleSocialWorker ; // Социальный работник, ссылается на SocialWorker(ID)
    String scheduleStartPlanned; // Плановые дата и время начала предоставления социальных услуг, тип DateTime
    String scheduleEndPlanned ; // Плановые дата и время окончания предоставления социальных услуг, тип DateTime
    boolean scheduleStatus ; // Статус элемента

    Recipient recipient; // Получение через ID
    ListService listService; // Получению по полю ServicePlannedSchedule
}
