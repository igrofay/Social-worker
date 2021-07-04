package com.example.socialworker.entity;

// План оказания социальных
public class ListService {
    int listServiceID;
    int servicePlannedSchedule ; // Календарный план социального работника,  ссылается на PlannedSchedule(ID)
    int socialServices_id ; // Социальные услуги, тип Lookup, ссылается на SocialService(ID)
    int listServiceVolume ;// Количество услуг
    long  listServiceScope ;// Объем услуги

    SocialService socialService; // Получение по ID
}
