package com.luismanuel.cardtoonfx;
import com.jfoenix.controls.JFXButton;
import com.luismanuel.cardtoonfx.api.ApiService;
import com.luismanuel.cardtoonfx.api.ClientRest;
import com.luismanuel.cardtoonfx.controllers.FichaController;
import com.luismanuel.cardtoonfx.controllers.ItemFichaController;
import com.luismanuel.cardtoonfx.controllers.ItemJugadorController;
import com.luismanuel.cardtoonfx.controllers.JugadorController;
import com.luismanuel.cardtoonfx.interfaces.OnItemSeleccionado;
import com.luismanuel.cardtoonfx.modelos.Ficha;
import com.luismanuel.cardtoonfx.modelos.Jugador;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable, OnItemSeleccionado {
    private ApiService apiService;
    @FXML
    private JFXButton botonFichas;

    @FXML
    private JFXButton botonJugadores;

    @FXML
    private JFXButton botonZonas;

    @FXML
    private Pane cardArea;

    @FXML
    private GridPane itemGrid;

    @FXML
    private ScrollPane scrollContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Set the home button listener. Home is the default view with all movies and books
        botonJugadores.setOnAction(mouseEvent -> {
            itemGrid.getChildren().clear();
            obtenerJugadores();
        });

        //Set the books button listener (OnAction instead of OnMouseClicked because it's a JFXButton)
        botonFichas.setOnAction(mouseEvent -> {
            itemGrid.getChildren().clear();
            obtenerFichas();
        });

    }

    public void establecerDatosJugadores(ArrayList<Jugador> jugadores){
        int row = 0;
        int col = 0;
        for (int i = 0; i < jugadores.size(); i++) {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader();
                URL url = getClass().getResource("item.fxml");
                fxmlLoader.setLocation(url);
                AnchorPane anchorPane = fxmlLoader.load();
                ItemJugadorController itemJugadorController = fxmlLoader.getController();


                //Set the data to the item
                itemJugadorController.cargarDatos(jugadores.get(i), MainController.this);

                //Divide the grid in 3 columns
                if (col == 3){
                    col = 0;
                    row++;
                }

                //Add the item to the grid and set the size
                itemGrid.add(anchorPane, col++, row);
                itemGrid.setMinWidth(Region.USE_COMPUTED_SIZE);
                itemGrid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                itemGrid.setMaxWidth(Region.USE_PREF_SIZE);
                itemGrid.setMinHeight(Region.USE_COMPUTED_SIZE);
                itemGrid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                itemGrid.setMaxHeight(Region.USE_PREF_SIZE);
                itemGrid.setVgap(10);

                //Add a margin to the item
                GridPane.setMargin(anchorPane, new Insets(10));
            }catch (IOException ex){
                ex.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

   public void establecerDatosFichas(ArrayList<Ficha> fichas){
        int row = 0;
        int col = 0;
        for (int i = 0; i < fichas.size(); i++) {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader();
                URL url = getClass().getResource("item2.fxml");
                fxmlLoader.setLocation(url);
                AnchorPane anchorPane = fxmlLoader.load();
                ItemFichaController itemController = fxmlLoader.getController();


                //Set the data to the item
                itemController.cargarDatos(fichas.get(i),MainController.this);

                //Divide the grid in 3 columns
                if (col == 3){
                    col = 0;
                    row++;
                }

                //Add the item to the grid and set the size
                itemGrid.add(anchorPane, col++, row);
                itemGrid.setMinWidth(Region.USE_COMPUTED_SIZE);
                itemGrid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                itemGrid.setMaxWidth(Region.USE_PREF_SIZE);
                itemGrid.setMinHeight(Region.USE_COMPUTED_SIZE);
                itemGrid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                itemGrid.setMaxHeight(Region.USE_PREF_SIZE);
                itemGrid.setVgap(10);

                //Add a margin to the item
                GridPane.setMargin(anchorPane, new Insets(10));
            }catch (IOException ex){
                ex.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public void onJugadorSeleccionado(Jugador jugador) {
        establecerDatosIndividualesJugador(jugador);
    }

    //OBTENER JUGADORES DE LA API
    private void obtenerJugadores(){
        apiService = ClientRest.getInstance("192.168.0.107","8090");

        apiService.obtenerTodos().enqueue(new Callback<List<Jugador>>() {
            @Override
            public void onResponse(Call<List<Jugador>> call, Response<List<Jugador>> response) {
                if(response.isSuccessful()){
                    List<Jugador> jugadores = response.body();
                    Platform.runLater(() -> {
                        establecerDatosJugadores((ArrayList<Jugador>) jugadores);
                    });
                }
            }

            @Override
            public void onFailure(Call<List<Jugador>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    //OBTENER FICHAS DE LA API
    private void obtenerFichas() {
        apiService = ClientRest.getInstance("192.168.0.107", "8090");
        apiService.obtenerFichas().enqueue(new Callback<List<Ficha>>() {
            @Override
            public void onResponse(Call<List<Ficha>> call, Response<List<Ficha>> response) {
                if (response.isSuccessful()) {
                    List<Ficha> fichas = response.body();
                    System.out.println(fichas.size());
                    Platform.runLater(() -> {
                        establecerDatosFichas((ArrayList<Ficha>) fichas);
                    });
                }
            }

            @Override
            public void onFailure(Call<List<Ficha>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }



    //DATOS INDIVIDUALES DEL DETALLE DE UNA FICHA
    public void establecerDatosIndividualesFicha(Ficha ficha){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ficha.fxml"));
            Pane pane = fxmlLoader.load();
            FichaController fichaController = fxmlLoader.getController();
            fichaController.establecerDatos(ficha);
            cardArea.getChildren().clear();
            cardArea.getChildren().add(pane);
            StackPane.setAlignment(pane, Pos.CENTER);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //DATOS INDIVIDUALES DEL DETALLE DE UN JUGADOR
    public void establecerDatosIndividualesJugador(Jugador jugador){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("jugador2.fxml"));
            Pane pane = fxmlLoader.load();
            JugadorController jugadorController = fxmlLoader.getController();
            jugadorController.establecerDatos(jugador);
            cardArea.getChildren().clear();
            cardArea.getChildren().add(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //LISTENER PARA EL DETALLE DE UNA FICHA
    @Override
    public void onFichaSeleccionada(Ficha ficha) {
        establecerDatosIndividualesFicha(ficha);
    }
}
