package com.iti.githubjobs.webservices;

import android.support.annotation.NonNull;
import android.util.Log;

import com.iti.githubjobs.model.Job;
import com.iti.githubjobs.screens.homescreen.HomeContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebServices {

    private static final String TAG = "WebServices";
    private HomeContract.HomePresenter homePresenter;

    public WebServices(HomeContract.HomePresenter homePresenter) {
        this.homePresenter = homePresenter;
    }

    public void getJobs(String description, String location) {
        WebserviceConnection.getInstance().getApi().getJobss(description, location)
                .enqueue(new Callback<List<Job>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Job>> call, @NonNull Response<List<Job>> response) {
                        List<Job> response1 = response.body();
                        if (response1 != null) {
                            homePresenter.setJobsList(response1);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Job>> call, @NonNull Throwable t) {
                        homePresenter.setError("Error please try again");
                        Log.e(TAG, "onFailure: "+t.getMessage() );
                    }
                });
    }
}
