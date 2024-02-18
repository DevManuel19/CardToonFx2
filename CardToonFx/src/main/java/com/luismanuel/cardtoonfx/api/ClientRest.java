package com.luismanuel.cardtoonfx.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientRest {

    private static ApiService instance;

    private ClientRest(){
    }
    public synchronized static ApiService getInstance(String ip, String puerto){
        String url = "http://" + ip.trim() + ":" + puerto + "/";
        System.out.println(url);

        if (instance == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            instance = retrofit.create(ApiService.class);
        }
        return instance;
    }

}
