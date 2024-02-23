package com.luismanuel.cardtoonfx;
import com.jfoenix.controls.JFXButton;
import com.luismanuel.cardtoonfx.api.ApiService;
import com.luismanuel.cardtoonfx.api.ClientRest;
import com.luismanuel.cardtoonfx.controllers.*;
import com.luismanuel.cardtoonfx.interfaces.OnItemSeleccionado;
import com.luismanuel.cardtoonfx.modelos.Ficha;
import com.luismanuel.cardtoonfx.modelos.Jugador;
import com.luismanuel.cardtoonfx.modelos.Zona;
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
    //VARIABLES
    private ApiService apiService = ClientRest.getInstance("localhost","8090");
    private boolean fichasSeleccionadas = false;
    private boolean jugadoresSeleccionados = false;
    private boolean zonasSeleccionadas = false;

    //COMPONENTES
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

    /**
     * Inicializa el controlador de la vista
     * @param url URL
     * @param resourceBundle ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //BOTON PARA OBTENER JUGADORES
        botonJugadores.setOnAction(mouseEvent -> {
            if (!jugadoresSeleccionados) {
                itemGrid.getChildren().clear();
                obtenerJugadores();
                jugadoresSeleccionados = true;
                fichasSeleccionadas = false;
                zonasSeleccionadas = false;
            }
        });
        //BOTON PARA OBTENER FICHAS
        botonFichas.setOnAction(mouseEvent -> {
            if (!fichasSeleccionadas) {
                itemGrid.getChildren().clear();
                obtenerFichas();
                fichasSeleccionadas = true;
                jugadoresSeleccionados = false;
                zonasSeleccionadas = false;
            }
        });
        //BOTON PARA OBTENER ZONAS
        botonZonas.setOnAction(mouseEvent -> {
            if (!zonasSeleccionadas) {
                itemGrid.getChildren().clear();
                obtenerZonas();
                zonasSeleccionadas = true;
                fichasSeleccionadas = false;
                jugadoresSeleccionados = false;
            }
        });
    }

    /**
     * Establece los datos de los jugadores en la vista
     * @param jugadores Lista de jugadores
     */
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


                //Establecemos los datos en el item inidividual
                itemJugadorController.cargarDatos(jugadores.get(i), MainController.this);

                if (col == 3){
                    col = 0;
                    row++;
                }

                //Añadimos el item en el grid y establecemos el tamaño
                itemGrid.add(anchorPane, col++, row);
                itemGrid.setMinWidth(Region.USE_COMPUTED_SIZE);
                itemGrid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                itemGrid.setMaxWidth(Region.USE_PREF_SIZE);
                itemGrid.setMinHeight(Region.USE_COMPUTED_SIZE);
                itemGrid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                itemGrid.setMaxHeight(Region.USE_PREF_SIZE);
                itemGrid.setVgap(10);

                //Añadimos un margen al item
                GridPane.setMargin(anchorPane, new Insets(10));
            }catch (IOException ex){
                ex.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Establece los datos de las fichas en la vista
     * @param fichas Lista de fichas
     */
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

                //Establecemos los datos en el item inidividual
                itemController.cargarDatos(fichas.get(i),MainController.this);
                if (col == 3){
                    col = 0;
                    row++;
                }

                //Añadimos el item en el grid y establecemos el tamaño
                itemGrid.add(anchorPane, col++, row);
                itemGrid.setMinWidth(Region.USE_COMPUTED_SIZE);
                itemGrid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                itemGrid.setMaxWidth(Region.USE_PREF_SIZE);
                itemGrid.setMinHeight(Region.USE_COMPUTED_SIZE);
                itemGrid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                itemGrid.setMaxHeight(Region.USE_PREF_SIZE);
                itemGrid.setVgap(10);

                //Añadimos un margen al item
                GridPane.setMargin(anchorPane, new Insets(10));
            }catch (IOException ex){
                ex.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void establecerDatosZonas(ArrayList<Zona> zonas){
        int row = 0;
        int col = 0;
        for (int i = 0; i < zonas.size(); i++) {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader();
                URL url = getClass().getResource("zona.fxml");
                fxmlLoader.setLocation(url);
                AnchorPane anchorPane = fxmlLoader.load();
                ItemZonaController itemController = fxmlLoader.getController();

                //Establecemos los datos en el item inidividual
                itemController.cargarDatos(zonas.get(i),MainController.this);
                if (col == 3){
                    col = 0;
                    row++;
                }

                //Añadimos el item en el grid y establecemos el tamaño
                itemGrid.add(anchorPane, col++, row);
                itemGrid.setMinWidth(Region.USE_COMPUTED_SIZE);
                itemGrid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                itemGrid.setMaxWidth(Region.USE_PREF_SIZE);
                itemGrid.setMinHeight(Region.USE_COMPUTED_SIZE);
                itemGrid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                itemGrid.setMaxHeight(Region.USE_PREF_SIZE);
                itemGrid.setVgap(10);

                //Añadimos un margen al item
                GridPane.setMargin(anchorPane, new Insets(10));
            }catch (IOException ex){
                ex.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Listener para el detalle de un jugador
     * @param jugador Jugador seleccionado
     */
    @Override
    public void onJugadorSeleccionado(Jugador jugador) {
        establecerDatosIndividualesJugador(jugador);
    }

    //OBTENER JUGADORES DE LA API
    private void obtenerJugadores(){
        // Obtenemos la instancia de la API con la dirección del servidor y el puerto
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
        // Obtenemos la instancia de la API con la dirección del servidor y el puerto
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

    private void obtenerZonas() {
        // Obtenemos la instancia de la API con la dirección del servidor y el puerto
        apiService.obtenerZonas().enqueue(new Callback<List<Zona>>() {
            @Override
            public void onResponse(Call<List<Zona>> call, Response<List<Zona>> response) {
                if (response.isSuccessful()) {
                    List<Zona> zonas = response.body();
                    Platform.runLater(() -> {
                        establecerDatosZonas((ArrayList<Zona>) zonas);
                    });
                }
            }

            @Override
            public void onFailure(Call<List<Zona>> call, Throwable throwable) {

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


    public void establecerDatosIndividualesZona(Zona zona){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("zonadetalle.fxml"));
            Pane pane = fxmlLoader.load();
            ZonaController zonaController = fxmlLoader.getController();
            zonaController.establecerDatos(zona);
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

    @Override
    public void onZonaSeleccionada(Zona zona) {
        establecerDatosIndividualesZona(zona);
    }
}