package com.example.socialworker.entity;

//Договор о предоставлении социальных услуг
public class RecipientDocument {
    int recipientDocumentID ;
    int recipientDocumentRecipient ; // Получатель социальных услуг, ссылается на Recipients(ID)
    String recipientDocumentNum ; // Номер договора
    String recipientDocumentStartDate ; // Дата начала действия договора
    String recipientDocumentEndDate ; // Дата окончания действия договора
    boolean recipientDocumentStaus ;// Статус договора
}
