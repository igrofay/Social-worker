package com.example.socialworker.fragments.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.socialworker.AdapterPlannedSchedule;
import com.example.socialworker.MainActivity;
import com.example.socialworker.R;
import com.example.socialworker.WelcomeActivity;


public class PlannedSchedulsFragment extends Fragment {
    AdapterPlannedSchedule adapterPlannedSchedule ;
    RecyclerView recyclerView ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_planned_scheduls, container, false);
        recyclerView = v.findViewById(R.id.rec_view);
        adapterPlannedSchedule = new AdapterPlannedSchedule(WelcomeActivity.socialWorker.getPlannedScheduleList());

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(adapterPlannedSchedule);
    }
}