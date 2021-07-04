package com.example.socialworker.entity;

// Тариф на социальные услуги
public class Tarif {
    int tarifID;
    int tarifSocialServiceID ; //Социальные услуги, ссылается на SocialService(ID)
    int socialServiceUnit ; // Единицы измерения социальных улуг, ссылается на Units(ID)
    String tarifStart ; // Дата начала действия
    String tarifEnd ;// Дата окончания действия
    int tarifPrice ; // Стоимость услуги

    Unit unit ; // Получение по ID
}
