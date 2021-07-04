package com.example.socialworker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialworker.entity.PlannedSchedule;

import java.util.List;

public class AdapterPlannedSchedule extends RecyclerView.Adapter<AdapterPlannedSchedule.ViewHolder> {
    List<PlannedSchedule> plannedScheduleList ;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.view_holder_for_calendar_rv , parent , false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setValue(
                plannedScheduleList.get(position)
        );
    }

    @Override
    public int getItemCount() {
        return plannedScheduleList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView data ;
        TextView recip ;
        FrameLayout stat ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.view_inf_name);
            data  = itemView.findViewById(R.id.view_inf_data);
            recip = itemView.findViewById(R.id.view_inf_recip);
            stat = itemView.findViewById(R.id.view_inf_stat);
        }
        void setValue(PlannedSchedule plannedSchedule){
            String dataStr = plannedSchedule.getScheduleStartPlanned()+ " - " + plannedSchedule.getScheduleEndPlanned();
            data.setText(dataStr);
            recip.setText(plannedSchedule.getRecipient().getRecipientFIO());
            stat.setBackground(
                    itemView.getResources().getDrawable(
                            plannedSchedule.isScheduleStatus() ? R.drawable.round_outline_blue : R.drawable.round_outline_red
                    )
            );
        }
    }

}
