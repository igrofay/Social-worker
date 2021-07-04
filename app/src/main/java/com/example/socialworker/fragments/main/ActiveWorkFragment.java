package com.example.socialworker.fragments.main;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.socialworker.R;
import com.example.socialworker.WelcomeActivity;
import com.example.socialworker.entity.PlannedSchedule;

import java.text.ParseException;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ActiveWorkFragment extends Fragment {
    TextView name;
    TextView forma ;
    TextView recip ;
    TextView adress;
    TextView time ;
    TextView tarif ;
    TextView unit ;
    PlannedSchedule plannedSchedule ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_active_work, container, false);
        name = v.findViewById(R.id.t_name);
        forma = v.findViewById(R.id.t_forma);
        recip = v.findViewById(R.id.t_recip);
        adress = v.findViewById(R.id.t_adress);
        time = v.findViewById(R.id.t_time);
        tarif = v.findViewById(R.id.t_tarif);
        unit = v.findViewById(R.id.t_unit);
        return v ;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Date currentDate = new Date();
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat formatter = new SimpleDateFormat();

        for (PlannedSchedule planned_Schedule :WelcomeActivity.socialWorker.getPlannedScheduleList()){
            try {
                if(currentDate.after(formatter.parse(planned_Schedule.getScheduleStartPlanned())) &&
                        currentDate.before(formatter.parse(planned_Schedule.getScheduleEndPlanned()))){
                    plannedSchedule = planned_Schedule ;
                    break;
                }
            } catch (ParseException e) {}
        }
        if (plannedSchedule == null) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(requireContext());
            alertDialog.setTitle("Проблемка").setMessage("На данный момент у вас нет задания").show();
        }
    }
}