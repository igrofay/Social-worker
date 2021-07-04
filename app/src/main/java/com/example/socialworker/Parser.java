package com.example.socialworker;

import com.example.socialworker.entity.PlannedSchedule;
import com.example.socialworker.entity.SocialWorker;
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

        plannedSchedule.setScheduleEndPlanned(data.child("ScheduleEndPlanned").getValue().toString());
        plannedSchedule.setScheduleSocialWorker(Integer.parseInt(data.child("ScheduleSocialWorker").getValue().toString()));
        plannedSchedule.setScheduleStartPlanned(data.child("ScheduleStartPlanned").getValue().toString());
        plannedSchedule.setScheduleStatus(Integer.parseInt(data.child("ScheduleStatus").getValue().toString())==1);

    }
}
