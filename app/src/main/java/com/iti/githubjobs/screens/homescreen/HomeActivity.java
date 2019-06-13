package com.iti.githubjobs.screens.homescreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.iti.githubjobs.R;
import com.iti.githubjobs.model.Job;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeContract.HomeView {

    HomeContract.HomePresenter presenter;
    List<Job> jobList = new ArrayList<>();
    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recycler);
        recyclerAdapter = new RecyclerAdapter(jobList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);

        presenter = new HomePresenterImpl(this);
        presenter.getJobs("java", "uk");

    }

    @Override
    public void setJobsList(List<Job> jobList) {
        this.jobList.addAll(jobList);
        recyclerAdapter.notifyDataSetChanged();
        Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }
}
