package com.example.leaderboard.learner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.leaderboard.R;


import java.util.List;

public class LearnerAdapter extends RecyclerView.Adapter<com.example.leaderboard.learner.LearnerAdapter.LearnerAdapterVH> {

    private List<LearnerResponse> learnerResponseList;
    private Context context;

    public LearnerAdapter() {
    }
    public void setData(List<LearnerResponse> learnerResponseList) {
        this.learnerResponseList = learnerResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public com.example.leaderboard.learner.LearnerAdapter.LearnerAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new com.example.leaderboard.learner.LearnerAdapter.LearnerAdapterVH(LayoutInflater.from(context).inflate(R.layout.learner_row,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull com.example.leaderboard.learner.LearnerAdapter.LearnerAdapterVH holder, int position) {

        LearnerResponse learnerResponse = learnerResponseList.get(position);

        String name = learnerResponse.getName();
        String  hours = String.valueOf(learnerResponse.getHours());
        String country = learnerResponse.getCountry();
        String baseUrl = learnerResponse.getBargeUrl();

        holder.name.setText(name);
        holder.hours.setText(hours);
        holder.country.setText(country);
        holder.baseUrl.setText(baseUrl);


    }

    @Override
    public int getItemCount() {
        return learnerResponseList.size();
    }

    public class LearnerAdapterVH extends RecyclerView.ViewHolder {
        TextView name;
        TextView hours;
        TextView country;
        TextView baseUrl;

        public LearnerAdapterVH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            hours = itemView.findViewById(R.id.hours);
            country = itemView.findViewById(R.id.country);
            baseUrl = itemView.findViewById(R.id.baseUrl);
        }
    }
}
