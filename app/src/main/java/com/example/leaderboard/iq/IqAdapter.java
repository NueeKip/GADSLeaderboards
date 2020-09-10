package com.example.leaderboard.iq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.leaderboard.R;

import java.util.List;

import static java.lang.String.valueOf;

public class IqAdapter extends RecyclerView.Adapter<IqAdapter.IqAdapterVH> {

    private List<IqResponse> iqResponseList;
    private Context context;

    public IqAdapter() {
    }
    public void setData(List<IqResponse> iqResponseList) {
        this.iqResponseList = iqResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public IqAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new IqAdapter.IqAdapterVH(LayoutInflater.from(context).inflate(R.layout.iq_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull IqAdapterVH holder, int position) {

        IqResponse iqResponse = iqResponseList.get(position);

        String name = iqResponse.getName();
        String score = String.valueOf(iqResponse.getScore());
        String country = iqResponse.getCountry();

        holder.name.setText(name);
        holder.score.setText(score);
        holder.country.setText(country);


    }

    @Override
    public int getItemCount() {
        return iqResponseList.size();
    }

    public class IqAdapterVH extends RecyclerView.ViewHolder {
        TextView name;
        TextView score;
        TextView country;
        TextView baseUrl;

        public IqAdapterVH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            score =itemView.findViewById(R.id.score);
            country = itemView.findViewById(R.id.country);
        }
    }
}
