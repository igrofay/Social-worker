package com.example.socialworker.entity;


// Социальные услуги, справочник
public class SocialService {
    int socialServiceID ;
    String socialServiceCode;
    String socialServiceNAME ;
    int socialServiceForm ; // Форма социальной услуги, ссылается на Forms(ID)
    int socialServiceType ; // Форма социальной услуги, ссылается на TypeSocialService(ID)
    int socialServiceExecutionTime ;// Лимит времени оказания услуги (в минутах)

    Form form ; // Получение по ID
    TypeSocialService typeSocialService; // Получение по ID
    Tarif tarif ; // Получение по TarifSocialServiceID
}
