package com.luismanuel.cardtoonfx.controllers;

import com.luismanuel.cardtoonfx.modelos.Ficha;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class FichaController {
    @FXML
    private ImageView imagen;

    @FXML
    private Label nivel;

    @FXML
    private Label nombre;

    @FXML
    private Label precio;

    @FXML
    private Label victorias;

    @FXML
    private Label vida;

    @FXML
    private Label zona;

    public void establecerDatos(Ficha ficha){
        // Obtenemos la ruta relativa de la imagen
        String imagePath = "/com/luismanuel/cardtoonfx/imagenes/" + ficha.getImagen() + ".png";

        // Obtenemos el InputStream de la imagen
        java.io.InputStream inputStream = getClass().getResourceAsStream(imagePath);

        // Creamos la imagen a partir del InputStream
        javafx.scene.image.Image image = new javafx.scene.image.Image(inputStream);

        // Establecemos la imagen en el ImageView
        imagen.setImage(image);

        nombre.setText(ficha.getNombre());
        precio.setText(String.valueOf(ficha.getPrecio()));
        nivel.setText(String.valueOf(ficha.getNivel()));
        vida.setText(String.valueOf(ficha.getVida()));
        victorias.setText(String.valueOf(ficha.getVictorias()));

        int numeroZona = calcularNumeroZona(String.valueOf(ficha.getId()));
        if (numeroZona == 1) {
            zona.setText("I");
        } else if (numeroZona == 2) {
            zona.setText("II");
        } else if (numeroZona == 3) {
            zona.setText("III");
        } else {
            zona.setText("IV");
        }
    }

    public int calcularNumeroZona(String numeroFicha) {
        // Calcula el número de zona basado en el número de ficha
        return (Integer.parseInt(numeroFicha) - 1) % 4 + 1;
    }
}
