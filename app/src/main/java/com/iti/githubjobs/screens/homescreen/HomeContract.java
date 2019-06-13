package com.iti.githubjobs.screens.homescreen;

import com.iti.githubjobs.model.Job;

import java.util.List;

public interface HomeContract {

    interface HomeView {

        void setJobsList(List<Job> jobList);

        void setError(String errorMsg);
    }

    interface HomePresenter {

        void getJobs(String description, String location);

        void setJobsList(List<Job> jobList);

        void setError(String errorMsg);
    }
}
