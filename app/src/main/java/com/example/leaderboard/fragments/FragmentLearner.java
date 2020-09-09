package com.example.leaderboard.fragments;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboard.ApiClient;
import com.example.leaderboard.learner.LearnerAdapter;
import com.example.leaderboard.learner.LearnerResponse;
import com.example.leaderboard.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentLearner extends Fragment {
    View v;
    RecyclerView myRecylerview;
    private LearnerAdapter learnerAdapter;
    private List<LearnerResponse> learnerResponses;
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.learner_fragment,container,false);
        myRecylerview = (RecyclerView) v.findViewById(R.id.learner_recyclerview);
        myRecylerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        //myRecylerview.setAdapter(learnerAdapter);
        return myRecylerview;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        learnerAdapter = new LearnerAdapter();
        getAllLearners();

    }

    public void getAllLearners(){


        Call<List<LearnerResponse>> learnerlist = ApiClient.getLearnerService().getAllLearners();

        learnerlist.enqueue(new Callback<List<LearnerResponse>>() {
            @Override
            public void onResponse(Call<List<LearnerResponse>> call, Response<List<LearnerResponse>> response) {
                if(response.isSuccessful()){
                    List<LearnerResponse> learnerResponses = response.body();

                    learnerAdapter.setData(learnerResponses);
                    myRecylerview.setAdapter(learnerAdapter);

                    //Log.e("Sucess",response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<LearnerResponse>> call, Throwable t) {
                Log.e("Failed",t.getLocalizedMessage());

            }
        });
    }
}
