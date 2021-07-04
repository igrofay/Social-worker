package com.example.socialworker.fragments.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.socialworker.MainActivity;
import com.example.socialworker.R;
import com.example.socialworker.entity.SocialWorker;


public class ProfileFragment extends Fragment {

    TextView fioTextView;
    TextView organisationTextView;
    TextView departmentTextView;
    TextView post_text_view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        MainActivity mainActivity = (MainActivity) getActivity();
        SocialWorker socialWorker = mainActivity.getSocialWorker();

        fioTextView = root.findViewById(R.id.fio_text_view);
        organisationTextView = root.findViewById(R.id.organisation_text_view);
        departmentTextView = root.findViewById(R.id.department_text_view);
        post_text_view = root.findViewById(R.id.post_text_view);

        fioTextView.setText(socialWorker.getSocialWorkerFIO());
        organisationTextView.setText(socialWorker.getSocialWorkerOrganization());
        departmentTextView.setText(socialWorker.getSocialWorkerDepartment());
        post_text_view.setText(socialWorker.getSocialWorkerPosition());

        return root;
    }
}