package com.luismanuel.cardtoonfx;

import com.luismanuel.cardtoonfx.modelos.Ficha;
import com.luismanuel.cardtoonfx.modelos.Jugador;
import com.luismanuel.cardtoonfx.modelos.Zona;

import java.util.ArrayList;

public class ReceptorApi {

    //ESTA CLASE SIMULA EL RECEPTOR DE DATOS DE RETROFIT 2 CON DATOS ESTATICOS, PERO NO ES USADA YA QUE LA API FUNCIONA

    public static ArrayList<Jugador> obtnerJugadores(){
        ArrayList<Jugador> jugadores = new ArrayList<>();
        //Rellenariamos el array llamando a retrofit 2

        for (int i = 1; i < 11; i++) {
            jugadores.add(new Jugador((long) i,150000,"Jugador"+i,0,"humano",null));
        }

        return jugadores;
    }
    public static ArrayList<Ficha> obtnerFichas(){
        ArrayList<Ficha> fichas = new ArrayList<>();
        //Rellenariamos el array llamando a retrofit 2

        for (int i = 1; i < 101; i++) {
           fichas.add(new Ficha((long)i,"img"+i,false,1,"Ficha"+i,100 + i,0,i,null,null));
        }

        return fichas;
    }
    public static ArrayList<Zona> obtnerZonas(){
        ArrayList<Zona> zonas = new ArrayList<>();
        //Rellenariamos el array llamando a retrofit 2

        for (int i = 0; i < 10; i++) {
            zonas.add(new Zona((long) i,"Zona"+i));
        }

        return zonas;
    }
}
