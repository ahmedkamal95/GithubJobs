package com.iti.githubjobs.webservices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Singleton Class to get data from website
 */
class WebserviceConnection {
    private static WebserviceConnection instance;
    private static API api;

    private WebserviceConnection(){
        Gson gson = new GsonBuilder().setLenient().create();
        OkHttpClient client = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(Urls.GITHUB_URL)
                .build();

        api = retrofit.create(API.class);
    }

    /**
     * Setup Singleton Class
     * @return instance
     */
    static WebserviceConnection getInstance(){
        if (instance==null){
            instance = new WebserviceConnection();
        }
        return instance;
    }

    API getApi(){
        return api;
    }


}
