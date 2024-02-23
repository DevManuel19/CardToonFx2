package com.luismanuel.cardtoonfx.controllers;

import com.luismanuel.cardtoonfx.interfaces.OnItemSeleccionado;
import com.luismanuel.cardtoonfx.modelos.Jugador;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.InputStream;

public class ItemJugadorController {
    @FXML
    private ImageView imagen;

    public void cargarDatos(Jugador jugador, OnItemSeleccionado miListener) throws Exception {

        //Get the image from the resources folder
        // Obtenemos la ruta relativa de la imagen
        String imagePath = "/com/luismanuel/cardtoonfx/imagenes/" + jugador.getPerfilIcon() + ".png";

        // Obtenemos el InputStream de la imagen
        InputStream inputStream = getClass().getResourceAsStream(imagePath);

        // Creamos la imagen a partir del InputStream
        Image image = new Image(inputStream);

        // Establecemos la imagen en el ImageView
        imagen.setImage(image);

        //Mouse click listener
        imagen.setOnMouseClicked(mouseEvent -> {
            miListener.onJugadorSeleccionado(jugador);
        });
    }
}
