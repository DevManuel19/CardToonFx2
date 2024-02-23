package com.luismanuel.cardtoonfx.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientRest {
    //Clase para obtener la instancia de la API
    private static ApiService instance;

    private ClientRest(){
    }

    /**
     * Metodo para obtener la instancia de la API
     * @param ip Ip del servidor
     * @param puerto Puerto del servidor
     * @return Instancia de la API
     */
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
