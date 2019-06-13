package com.iti.githubjobs.screens.homescreen;

import com.iti.githubjobs.model.Job;
import com.iti.githubjobs.webservices.WebServices;

import java.util.List;

public class HomePresenterImpl implements HomeContract.HomePresenter {

    private HomeContract.HomeView homeView;
    private WebServices webServices;

    HomePresenterImpl(HomeContract.HomeView homeView) {
        this.homeView = homeView;
        webServices = new WebServices(this);
    }

    @Override
    public void getJobs(String description, String location) {
        webServices.getJobs(description,location);
    }

    @Override
    public void setJobsList(List<Job> jobList) {
        homeView.setJobsList(jobList);
    }

    @Override
    public void setError(String errorMsg) {
        homeView.setError(errorMsg);
    }
}
