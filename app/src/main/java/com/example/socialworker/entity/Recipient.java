package com.example.socialworker.entity;

// Клиент
public class Recipient {
    int recipientID ;
    String recipientFIO;
    String recipientDR ; // День рождения
    String recipientAdress ; // Адрес проживания
    String recipientAdressLatitude ; // Широта адреса проживания
    String recipientAdressLongitude; // Долгота адреса проживания
    String recipientContact ; // Контактный номер телефона

    RecipientDocument recipientDocument ; // Получение по RecipientDocumentRecipient
}
