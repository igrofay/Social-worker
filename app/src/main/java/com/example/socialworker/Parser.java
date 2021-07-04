package com.example.socialworker;

import com.example.socialworker.entity.Form;
import com.example.socialworker.entity.ListService;
import com.example.socialworker.entity.PlannedSchedule;
import com.example.socialworker.entity.Recipient;
import com.example.socialworker.entity.RecipientDocument;
import com.example.socialworker.entity.SocialService;
import com.example.socialworker.entity.SocialWorker;
import com.example.socialworker.entity.Tarif;
import com.example.socialworker.entity.TypeSocialService;
import com.example.socialworker.entity.Unit;
import com.google.firebase.database.DataSnapshot;

public class Parser {
    public static SocialWorker parserSocialWorker(DataSnapshot data){
        SocialWorker socialWorker = new SocialWorker();
        socialWorker.setSocialWorkerID(Integer.parseInt(data.getKey()));
        socialWorker.setSocialWorkerDepartment(data.child("SocialWorkerDepartment").getValue().toString());
        socialWorker.setSocialWorkerFIO(data.child("SocialWorkerFIO").getValue().toString());
        socialWorker.setSocialWorkerLogin(data.child("SocialWorkerLogin").getValue().toString());
        socialWorker.setSocialWorkerOrganization(data.child("SocialWorkerOrganization").getValue().toString());
        socialWorker.setSocialWorkerPassword(data.child("SocialWorkerPassword").getValue().toString());
        socialWorker.setSocialWorkerPosition(data.child("SocialWorkerPosition").getValue().toString());
        return socialWorker;
    }
    public static PlannedSchedule parserPlannedSchedule(DataSnapshot data){
        PlannedSchedule plannedSchedule = new PlannedSchedule();
        plannedSchedule.setScheduleID(Integer.parseInt(data.getKey()));
        plannedSchedule.setScheduleEndPlanned(data.child("ScheduleEndPlanned").getValue().toString());
        plannedSchedule.setScheduleSocialWorker(Integer.parseInt(data.child("ScheduleSocialWorker").getValue().toString()));
        plannedSchedule.setScheduleStartPlanned(data.child("ScheduleStartPlanned").getValue().toString());
        plannedSchedule.setScheduleStatus(Integer.parseInt(data.child("ScheduleStatus").getValue().toString())==1);
        plannedSchedule.setScheduleRecipient(Integer.parseInt(data.child("ScheduleRecipient").getValue().toString() ));
        return plannedSchedule ;
    }
    public static Recipient parserRecipient(DataSnapshot data){
        Recipient recipient = new Recipient();
        recipient.setRecipientID(Integer.parseInt(data.getKey()));
        recipient.setRecipientFIO(data.child("RecipientFIO").getValue().toString());
        recipient.setRecipientAdress(data.child("RecipientDR").getValue().toString());
        recipient.setRecipientAdress(data.child("RecipientAdress").getValue().toString());
        recipient.setRecipientAdressLatitude(data.child("RecipientAdressLatitude").getValue().toString());
        recipient.setRecipientAdressLongitude(data.child("RecipientAdressLongitude").getValue().toString());
        recipient.setRecipientContact(data.child("RecipientContact").getValue().toString());
        recipient.setRecipientQRCode(data.child("RecipientQRCode").getValue().toString());
        return recipient ;
    }
    public static ListService parserListService(DataSnapshot data ){
        ListService listService = new ListService();
        listService.setListServiceID(Integer.parseInt(data.getKey()));
        listService.setServicePlannedSchedule(Integer.parseInt(data.child("ServicePlannedSchedule").getValue().toString()));
        listService.setSocialServices_id(Integer.parseInt(data.child("SocialServices").getValue().toString()));
        listService.setListServiceVolume(Integer.parseInt(data.child("ListServiceVolume").getValue().toString()));
        listService.setListServiceScope(Long.parseLong(data.child("ListServiceScope").getValue().toString()));
        return listService;
    }
    public static RecipientDocument parserRecipientDocument(DataSnapshot data){
        RecipientDocument recipientDocument = new RecipientDocument();
        recipientDocument.setRecipientDocumentID(Integer.parseInt(data.getKey()));
        recipientDocument.setRecipientDocumentRecipient(Integer.parseInt(data.child("RecipientDocumentRecipient").getValue().toString()));
        recipientDocument.setRecipientDocumentNum(data.child("RecipientDocumentNum").getValue().toString());
        recipientDocument.setRecipientDocumentStartDate(data.child("RecipientDocumentStartDate").getValue().toString());
        recipientDocument.setRecipientDocumentEndDate(data.child("RecipientDocumentEndDate").getValue().toString());
        recipientDocument.setRecipientDocumentStaus(Integer.parseInt(data.child("RecipientDocumentStaus").getValue().toString())==1);
        return recipientDocument ;
    }

    public static SocialService parserSocialService(DataSnapshot data){
        SocialService socialService = new SocialService();
        socialService.setSocialServiceID(Integer.parseInt(data.getKey()));
        socialService.setSocialServiceCode(data.child("SocialServiceCode").getValue().toString());
        socialService.setSocialServiceNAME(data.child("SocialServiceNAME").getValue().toString());
        socialService.setSocialServiceForm(Integer.parseInt(data.child("SocialServiceForm").getValue().toString()));
        socialService.setSocialServiceType(Integer.parseInt(data.child("SocialServiceType").getValue().toString()));
        socialService.setSocialServiceExecutionTime(data.child("SocialServiceExecutionTime").getValue().toString());
        socialService.setSocialServiceTypeTarif(Integer.parseInt(data.child("SocialServiceTypeTarif").getValue().toString()));
        return socialService ;
    }
    public static Form parserForm(DataSnapshot data){
        Form form = new Form();
        form.setFormID(Integer.parseInt(data.getKey()));
        form.setFormNAME(data.child("FormNAME").getValue().toString());
        return form;
    }
    public static TypeSocialService parserTypeSocialService(DataSnapshot data){
        TypeSocialService typeSocialService = new TypeSocialService();
        typeSocialService.setTypeID(Integer.parseInt(data.getKey()));
        typeSocialService.setTypeNAME(data.child("TypeNAME").getValue().toString());
        return typeSocialService ;
    }

    public static Tarif parserTarif(DataSnapshot data){
        Tarif tarif = new Tarif() ;
        tarif.setTarifID(Integer.parseInt(data.getKey()));
        tarif.setTarifSocialServiceID(Integer.parseInt(data.child("TarifSocialServiceID").getValue().toString()));
        tarif.setSocialServiceUnit(Integer.parseInt(data.child("SocialServiceUnit").getValue().toString()));
        tarif.setTarifStart(data.child("TarifStart").getValue().toString());
        tarif.setTarifEnd(data.child("TarifEnd").getValue().toString());
        tarif.setTarifPrice(data.child("TarifPric").getValue().toString());
        return tarif ;
    }
    public static Unit parserUnit(DataSnapshot data){
        Unit unit = new Unit();
        unit.setUnitID(Integer.parseInt(data.getKey()));
        unit.setUnitNAME(data.child("UnitNAME").getValue().toString());
        return unit;
    }
}
