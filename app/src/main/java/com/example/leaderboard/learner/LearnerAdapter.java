package com.example.leaderboard.learner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.leaderboard.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.$Gson$Preconditions;


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
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view =layoutInflater.inflate(R.layout.learner_row,parent,false);
        return new LearnerAdapterVH(view);
    }


    @Override
    public void onBindViewHolder(@NonNull com.example.leaderboard.learner.LearnerAdapter.LearnerAdapterVH holder, int position) {


               LearnerResponse learnerResponse = learnerResponseList.get(position);
        String name = learnerResponse.getName();
        String country = learnerResponse.getCountry();
        String hours = String.valueOf(learnerResponse.getHours());


        holder.name.setText(name);
        holder.hours.setText(hours);
        holder.country.setText(country);




    }

    @Override
    public int getItemCount() {
        return learnerResponseList.size();
    }

    public class LearnerAdapterVH extends RecyclerView.ViewHolder {
        TextView name;
        TextView hours;
        TextView country;


        public LearnerAdapterVH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            hours = itemView.findViewById(R.id.hours);
            country = itemView.findViewById(R.id.country);
        }
    }
}