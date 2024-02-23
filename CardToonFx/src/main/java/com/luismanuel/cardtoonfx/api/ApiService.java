package com.luismanuel.cardtoonfx.api;

import com.luismanuel.cardtoonfx.modelos.Ficha;
import com.luismanuel.cardtoonfx.modelos.Jugador;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiService {

    //LLAMADAS A LA API
    @GET("/jugadores/obtener/todos")
    Call<List<Jugador>> obtenerTodos();
    @GET("/fichas/obtener/todas")
    Call<List<Ficha>> obtenerFichas();
}
