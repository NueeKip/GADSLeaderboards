package com.example.leaderboard.iq;

import com.example.leaderboard.iq.IqResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IqService {
    @GET("api/hours")
    Call<List<IqResponse> >getAllIqs();
}
