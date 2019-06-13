package com.iti.githubjobs.webservices;


import com.iti.githubjobs.model.Job;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    @GET("positions.json")
    Call<List<Job>> getJobss(@Query("description") String description,
                             @Query("location") String location);

}
