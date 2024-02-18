package com.luismanuel.cardtoonfx.interfaces;

import com.luismanuel.cardtoonfx.modelos.Ficha;
import com.luismanuel.cardtoonfx.modelos.Jugador;

public interface OnItemSeleccionado {
    /**
     * Este método es utilizado para devolver erl item que ha sido pulsado
     * se usa en el MainController para obtener dicho objeto
     * @param jugador Jugador seleccionado
     */
    void onJugadorSeleccionado(Jugador jugador);

    void onFichaSeleccionada(Ficha ficha);
}
