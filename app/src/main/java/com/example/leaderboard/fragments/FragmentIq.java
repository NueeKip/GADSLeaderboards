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
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboard.ApiClient;
import com.example.leaderboard.R;
import com.example.leaderboard.iq.IqAdapter;
import com.example.leaderboard.iq.IqResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentIq extends Fragment{
    View v;
    RecyclerView myRecylerview;
    private IqAdapter iqAdapter;
    private List<IqResponse> iqResponses;
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.iq_fragment,container,false);
        myRecylerview = (RecyclerView) v.findViewById(R.id.iq_recyclerview);
        myRecylerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        //myRecylerview.setAdapter(iqAdapter);
        return myRecylerview;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        iqAdapter = new IqAdapter();
        getAllIq();

    }

    public void getAllIq(){


        Call<List<IqResponse>> iqlist = ApiClient.getIqService().getAllIqs();

        iqlist.enqueue(new Callback<List<IqResponse>>() {
            @Override
            public void onResponse(Call<List<IqResponse>> call, Response<List<IqResponse>> response) {
                if(response.isSuccessful()){
                    List<IqResponse> iqResponses = response.body();

                    iqAdapter.setData(iqResponses);
                    myRecylerview.setAdapter(iqAdapter);

                    //Log.e("Sucess",response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<IqResponse>> call, Throwable t) {
                Log.e("Failed",t.getLocalizedMessage());

            }
        });
    }
}