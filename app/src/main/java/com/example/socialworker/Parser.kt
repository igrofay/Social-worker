package com.example.socialworker

import com.example.socialworker.entity.*
import com.example.socialworker.entity.Unit
import com.google.firebase.database.DataSnapshot
import java.lang.Exception

object Parser {
    @JvmStatic
    fun parserSocialWorker(data: DataSnapshot): SocialWorker {
        val socialWorker = SocialWorker()
        socialWorker.socialWorkerID = data.key!!.toInt()
        socialWorker.socialWorkerDepartment = data.child("SocialWorkerDepartment").value.toString()
        socialWorker.socialWorkerFIO = data.child("SocialWorkerFIO").value.toString()
        socialWorker.socialWorkerLogin = data.child("SocialWorkerLogin").value.toString()
        socialWorker.socialWorkerOrganization = data.child("SocialWorkerOrganization").value.toString()
        socialWorker.socialWorkerPassword = data.child("SocialWorkerPassword").value.toString()
        socialWorker.socialWorkerPosition = data.child("SocialWorkerPosition").value.toString()
        return socialWorker
    }

    @JvmStatic
    fun parserPlannedSchedule(data: DataSnapshot): PlannedSchedule {
        val plannedSchedule = PlannedSchedule()
        plannedSchedule.scheduleID = data.key!!.toInt()
        plannedSchedule.scheduleEndPlanned = data.child("ScheduleEndPlanned").value.toString()
        plannedSchedule.scheduleSocialWorker = data.child("ScheduleSocialWorker").value.toString().toInt()
        plannedSchedule.scheduleStartPlanned = data.child("ScheduleStartPlanned").value.toString()
        plannedSchedule.isScheduleStatus = data.child("ScheduleStatus").value.toString().toInt() == 1
        plannedSchedule.scheduleRecipient = data.child("ScheduleRecipient").value.toString().toInt()
        return plannedSchedule
    }

    @JvmStatic
    fun parserRecipient(data: DataSnapshot): Recipient {
        val recipient = Recipient()
        recipient.recipientID = data.key!!.toInt()
        recipient.recipientFIO = data.child("RecipientFIO").value.toString()
        recipient.recipientAdress = data.child("RecipientDR").value.toString()
        recipient.recipientAdress = data.child("RecipientAdress").value.toString()
        recipient.recipientAdressLatitude = data.child("RecipientAdressLatitude").value.toString()
        recipient.recipientAdressLongitude = data.child("RecipientAdressLongitude").value.toString()
        recipient.recipientContact = data.child("RecipientContact").value.toString()
        recipient.recipientQRCode = data.child("RecipientQRCode").value.toString()
        return recipient
    }

    @JvmStatic
    fun parserListService(data: DataSnapshot): ListService {
        val listService = ListService()
        listService.listServiceID = data.key!!.toInt()
        listService.servicePlannedSchedule = data.child("ServicePlannedSchedule").value.toString().toInt()
        listService.socialServices_id = data.child("SocialServices").value.toString().toInt()
        listService.listServiceVolume = data.child("ListServiceVolume").value.toString().toInt()
        listService.listServiceScope = data.child("ListServiceScope").value.toString().toLong()
        return listService
    }

    @JvmStatic
    fun parserRecipientDocument(data: DataSnapshot): RecipientDocument {
        val recipientDocument = RecipientDocument()
        recipientDocument.recipientDocumentID = data.key!!.toInt()
        recipientDocument.recipientDocumentRecipient = data.child("RecipientDocumentRecipient").value.toString().toInt()
        recipientDocument.recipientDocumentNum = data.child("RecipientDocumentNum").value.toString()
        recipientDocument.recipientDocumentStartDate = data.child("RecipientDocumentStartDate").value.toString()
        recipientDocument.recipientDocumentEndDate = data.child("RecipientDocumentEndDate").value.toString()
        recipientDocument.isRecipientDocumentStaus = data.child("RecipientDocumentStaus").value.toString().toInt() == 1
        return recipientDocument
    }

    @JvmStatic
    fun parserSocialService(data: DataSnapshot): SocialService {
        val socialService = SocialService()
        socialService.socialServiceID = data.key!!.toInt()
        socialService.socialServiceCode = data.child("SocialServiceCode").value.toString()
        socialService.socialServiceNAME = data.child("SocialServiceNAME").value.toString()
        socialService.socialServiceForm = data.child("SocialServiceForm").value.toString().toInt()
        socialService.socialServiceType = data.child("SocialServiceType").value.toString().toInt()
        socialService.socialServiceExecutionTime = data.child("SocialServiceExecutionTime").value.toString()
        socialService.socialServiceTypeTarif = try { data.child("SocialServiceTypeTarif").value.toString().toInt() }catch (e:Exception){0}
        return socialService
    }

    @JvmStatic
    fun parserForm(data: DataSnapshot): Form {
        val form = Form()
        form.formID = data.key!!.toInt()
        form.formNAME = data.child("FormNAME").value.toString()
        return form
    }

    @JvmStatic
    fun parserTypeSocialService(data: DataSnapshot): TypeSocialService {
        val typeSocialService = TypeSocialService()
        typeSocialService.typeID = data.key!!.toInt()
        typeSocialService.typeNAME = data.child("TypeNAME").value.toString()
        return typeSocialService
    }

    @JvmStatic
    fun parserTarif(data: DataSnapshot): Tarif {
        val tarif = Tarif()
        tarif.tarifID = data.key!!.toInt()
        tarif.tarifSocialServiceID = data.child("TarifSocialServiceID").value.toString().toInt()
        tarif.socialServiceUnit = data.child("SocialServiceUnit").value.toString().toInt()
        tarif.tarifStart = data.child("TarifStart").value.toString()
        tarif.tarifEnd = data.child("TarifEnd").value.toString()
        tarif.tarifPrice = data.child("TarifPric").value.toString()
        return tarif
    }

    @JvmStatic
    fun parserUnit(data: DataSnapshot): Unit {
        val unit = Unit()
        unit.unitID = data.key!!.toInt()
        unit.unitNAME = data.child("UnitNAME").value.toString()
        return unit
    }
}