package com.example.leaderboard.learner;


import com.example.leaderboard.learner.LearnerResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearnerService {
    @GET("api/skilliq")
    Call<List<LearnerResponse> >getAllLearners();
}
