package com.example.socialworker.entity;

import java.util.List;

//Социальный работник
public class SocialWorker {
    int socialWorkerID;
    String socialWorkerFIO ;
    String socialWorkerLogin;
    String socialWorkerPassword;
    String socialWorkerPosition ; // Наименование должности
    String socialWorkerDepartment; // Наименование отделения
    String socialWorkerOrganization ; // Наименование учреждения

    List<PlannedSchedule> plannedScheduleList; // Получение по полю ScheduleSocialWorker
}
