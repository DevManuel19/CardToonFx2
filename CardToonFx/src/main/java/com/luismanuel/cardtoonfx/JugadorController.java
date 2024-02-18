package com.luismanuel.cardtoonfx;

import com.luismanuel.cardtoonfx.modelos.Jugador;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.Objects;

public class JugadorController {
    @FXML
    private Label dinero;

    @FXML
    private Label idJugador;

    @FXML
    private Label nombre;

    @FXML
    private Label partidasGanadas;

    @FXML
    private ImageView perfilIcon;

    public void establecerDatos(Jugador jugador){
        System.out.println(jugador.getPerfilIcon());
        // Obtenemos la ruta relativa de la imagen
        String imagePath = "/com/luismanuel/cardtoonfx/imagenes/" + jugador.getPerfilIcon() + ".png";

        // Obtenemos el InputStream de la imagen
        InputStream inputStream = getClass().getResourceAsStream(imagePath);

        // Creamos la imagen a partir del InputStream
        Image image = new Image(inputStream);

        // Establecemos la imagen en el ImageView
        perfilIcon.setImage(image);


        nombre.setText(jugador.getNombre());
        dinero.setText(String.valueOf(jugador.getDinero()));
        idJugador.setText(String.valueOf(jugador.getId()));
        partidasGanadas.setText(String.valueOf(jugador.getPartidasGanadas()));
    }
}
