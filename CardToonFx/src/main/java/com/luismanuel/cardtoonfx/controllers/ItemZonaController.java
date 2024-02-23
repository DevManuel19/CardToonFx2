package com.luismanuel.cardtoonfx.controllers;

import com.luismanuel.cardtoonfx.interfaces.OnItemSeleccionado;
import com.luismanuel.cardtoonfx.modelos.Jugador;
import com.luismanuel.cardtoonfx.modelos.Zona;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

public class ItemZonaController {

    @FXML
    private ImageView imagenZona;

    public void cargarDatos(Zona zona, OnItemSeleccionado miListener) throws Exception {

        if (zona.getId() == 1 || zona.getId() == 2) {
            String imagePath = "/com/luismanuel/cardtoonfx/imagenes/zona" + zona.getId() + ".jpg";
            InputStream inputStream = getClass().getResourceAsStream(imagePath);
            Image image = new Image(inputStream);
            imagenZona.setImage(image);
            imagenZona.setOnMouseClicked(mouseEvent -> {
                miListener.onZonaSeleccionada(zona);
            });
        }else{
            String imagePath = "/com/luismanuel/cardtoonfx/imagenes/zona" + zona.getId() + ".png";
            InputStream inputStream = getClass().getResourceAsStream(imagePath);
            Image image = new Image(inputStream);
            imagenZona.setImage(image);
            imagenZona.setOnMouseClicked(mouseEvent -> {
                miListener.onZonaSeleccionada(zona);
            });
        }



    }
}
