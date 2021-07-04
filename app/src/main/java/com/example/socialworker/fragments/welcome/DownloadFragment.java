package com.example.socialworker.fragments.welcome;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.socialworker.MainActivity;
import com.example.socialworker.R;
import com.example.socialworker.WelcomeActivity;
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
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

import static com.example.socialworker.Parser.parserForm;
import static com.example.socialworker.Parser.parserListService;
import static com.example.socialworker.Parser.parserPlannedSchedule;
import static com.example.socialworker.Parser.parserRecipient;
import static com.example.socialworker.Parser.parserRecipientDocument;
import static com.example.socialworker.Parser.parserSocialService;
import static com.example.socialworker.Parser.parserSocialWorker;
import static com.example.socialworker.Parser.parserTarif;
import static com.example.socialworker.Parser.parserTypeSocialService;
import static com.example.socialworker.Parser.parserUnit;
import static com.example.socialworker.WelcomeActivity.APP_PREFERENCES;
import static com.example.socialworker.WelcomeActivity.LOGIN_CASEWORKER;
import static com.example.socialworker.WelcomeActivity.PASSWORD_CASEWORKER;
import static com.example.socialworker.WelcomeActivity.SOCIAL_WORKER;


public class DownloadFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = (requireActivity()).getSharedPreferences(APP_PREFERENCES , Context.MODE_PRIVATE) ;
        String login = preferences.getString(LOGIN_CASEWORKER , null);
        String password = preferences.getString(PASSWORD_CASEWORKER , "");
        if( login == null) NavHostFragment.findNavController(this).navigate(R.id.authorizationFragment);
        else authorization(login , password);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_download, container, false);
    }

    void finishActivity(){
        Intent intent = new Intent(requireActivity() , MainActivity.class);
        startActivity(intent);
        requireActivity().finish();
    }
    void authorization(String log , String password){
        FirebaseDatabase firebaseApp = FirebaseDatabase.getInstance();
        firebaseApp.setPersistenceEnabled(true);
        firebaseApp.getReference().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot child: snapshot.child("SocialWorkers").getChildren()){
                    String logData = child.child("SocialWorkerLogin").getValue().toString();
                    String passwordData = child.child("SocialWorkerPassword").getValue().toString();
                    if(log.equals(logData) && password.equals(passwordData)){
                        SocialWorker socialWorker = parserSocialWorker(child);
                        WelcomeActivity.socialWorker = socialWorker;
                        socialWorker.setPlannedScheduleList(downloadPlannedSchedule(snapshot , socialWorker.getSocialWorkerID()));
                        finishActivity();
                        break;
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    List<PlannedSchedule> downloadPlannedSchedule(DataSnapshot dataMain , int id_ ){
        List<PlannedSchedule> plannedScheduleList  = new ArrayList<>();
        for(DataSnapshot child: dataMain.child("PlannedScheduls").getChildren()){
            int id_ScheduleSocialWorker = Integer.parseInt(child.child("ScheduleSocialWorker").getValue().toString()) ;
            if(id_ScheduleSocialWorker == id_){
                PlannedSchedule plannedSchedule = parserPlannedSchedule(child);
                plannedScheduleList.add(plannedSchedule);
                downloadAdditionalData(dataMain , plannedSchedule);
            }
        }

        return plannedScheduleList;
    }

    void downloadAdditionalData(DataSnapshot dataMain , PlannedSchedule plannedSchedule){
        // Получить Recipient
        for (DataSnapshot child : dataMain.child("Recipients").getChildren() ){
            if(Integer.parseInt(child.getKey()) == plannedSchedule.getScheduleRecipient()){
                Recipient recipient = parserRecipient(child) ;
                plannedSchedule.setRecipient(recipient);
                break;
            }
        }
        // Получить ListService
        for (DataSnapshot child: dataMain.child("ListServices").getChildren()){
            int id_ListService = Integer.parseInt(child.child("ServicePlannedSchedule").getValue().toString());
            if(id_ListService==plannedSchedule.getScheduleRecipient()){
                ListService listService = parserListService(child);
                plannedSchedule.setListService(listService);
                break;
            }
        }
        // Получить RecipientDocument
        for (DataSnapshot child : dataMain.child("RecipientDocuments").getChildren()){
            int id_RecipientDocument = Integer.parseInt(child.child("RecipientDocumentRecipient").getValue().toString());
            if(id_RecipientDocument == plannedSchedule.getRecipient().getRecipientID()){
                RecipientDocument recipientDocument = parserRecipientDocument(child);
                plannedSchedule.getRecipient().setRecipientDocument(recipientDocument);
                break;
            }
        }
        // Получить SocialService
        for (DataSnapshot child : dataMain.child("SocialServices").getChildren()){
            if(Integer.parseInt(child.getKey()) == plannedSchedule.getListService().getSocialServices_id()){
                SocialService socialService = parserSocialService(child);
                plannedSchedule.getListService().setSocialService(socialService);
            }
        }
        // Получить Form
        for (DataSnapshot child : dataMain.child("Forms").getChildren()){
            if(Integer.parseInt(child.getKey()) == plannedSchedule.getListService().getSocialService().getSocialServiceForm()){
                Form form = parserForm(child);
                plannedSchedule.getListService().getSocialService().setForm(form);
                break;
            }
        }
        // Получить TypeSocialService
        for (DataSnapshot data : dataMain.child("TypeSocialServices").getChildren()){
            if(Integer.parseInt(data.getKey())== plannedSchedule.getListService().getSocialService().getSocialServiceType()){
                TypeSocialService typeSocialService = parserTypeSocialService(data);
                plannedSchedule.getListService().getSocialService().setTypeSocialService(typeSocialService);
                break;
            }
        }
        // Получить Tarif
        for (DataSnapshot child : dataMain.child("Tarifs").getChildren()){
            if(Integer.parseInt(child.getKey())== plannedSchedule.getListService().getSocialService().getSocialServiceTypeTarif()){
                Tarif tarif  = parserTarif(child) ;
                plannedSchedule.getListService().getSocialService().setTarif(tarif);
                break;
            }
        }
        // Получить Unit
        for (DataSnapshot child : dataMain.child("Units").getChildren()){
            try {
                if(Integer.parseInt(child.getKey())== plannedSchedule.getListService().getSocialService().getTarif().getSocialServiceUnit()){
                    Unit unit = parserUnit(child);
                    plannedSchedule.getListService().getSocialService().getTarif().setUnit(unit);
                    break;
                }
            }catch (Exception ignored){ }

        }

    }


}
