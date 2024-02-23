package com.luismanuel.cardtoonfx.controllers;

import com.luismanuel.cardtoonfx.modelos.Ficha;
import com.luismanuel.cardtoonfx.modelos.Zona;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

public class ZonaController {

    @FXML
    private TextArea descripcion;

    @FXML
    private ImageView imagenZona;

    @FXML
    private Label nombreZona;


    public void establecerDatos(Zona zona){

        if (zona.getId() == 1 || zona.getId() == 2) {
            String imagePath = "/com/luismanuel/cardtoonfx/imagenes/zona" + zona.getId() + ".jpg";
            InputStream inputStream = getClass().getResourceAsStream(imagePath);
            Image image = new Image(inputStream);
            imagenZona.setImage(image);

        }else{
            String imagePath = "/com/luismanuel/cardtoonfx/imagenes/zona" + zona.getId() + ".png";
            InputStream inputStream = getClass().getResourceAsStream(imagePath);
            Image image = new Image(inputStream);
            imagenZona.setImage(image);
        }

        nombreZona.setText(zona.getNombre());

        switch (zona.getId().toString()){
            case "1":
                descripcion.setText("En una tierra lejana y misteriosa, se encuentra la Zona Helada, " +
                        "un lugar envuelto en un eterno invierno propiedad del REY HIELO. Los habitantes de esta región, conocidos como \"Frozes\" " +
                        "han vivido en armonía con la naturaleza helada " +
                        "durante generaciones. Sin embargo, una antigua profecía ha comenzado a inquietar a los habitantes," +
                        " ya que dicen que se acerca una BATALLA bajo los frios vientos del invierno."
                );
                break;
            case "2":
                descripcion.setText("En una tierra muy solitaria, se encuentra la Zona Desértica, un vasto territorio " +
                        "cubierto por dunas de arena y con un sol muy fuerte. Esta región, propiedad de la temible ELISE" +
                        ", reina de los desiertos inospitos, ha sido el hogar de los habitantes nómadas conocidos como los \"Dunas\" durante generaciones. " +
                        "Sin embargo, una antigua profecía ha comenzado a inquietar a los Dunas, ya que se dice que se acerca " +
                        "una Gran Tormenta, una batalla épica que decidirá el destino de la Zona Desértica.");
                break;
            case "3":
                descripcion.setText("En una tierra muy lejana y exuberante, se encuentra la Zona de la Selva, un vasto territorio cubierto " +
                        "por densos bosques y bañado por una lluvia constante. Esta región, propiedad de LIMONCIO, el rei de los " +
                        "bosques impenetrables, ha sido el hogar de los habitantes nómadas conocidos como los \"Verdes\" durante generaciones." +
                        " Sin embargo, una antigua profecía ha comenzado a inquietar a los Verdes, ya que se dice que se acerca una Gran batalla " +
                        "por dominar los arboles y refugios de la selva..");
                break;
            case "4":
                descripcion.setText("En una tierra muy lejana y misteriosa, se encuentra la Zona de la Cueva, un vasto territorio subterráneo cubierto " +
                        "por oscuridad y misterio. Esta región, propiedad de ESQUELETO, el rey de las profundidades, ha sido el hogar de los habitantes " +
                        "conocidos como los \"Cavernícolas\" durante generaciones. Sin embargo, una antigua profecía ha comenzado a inquietar a los Cavernícolas, " +
                        "ya que se dice que se acerca una Gran Batalla por el dominio de las cavernas y tesoros de la cueva.");
                break;
        }


    }

}
