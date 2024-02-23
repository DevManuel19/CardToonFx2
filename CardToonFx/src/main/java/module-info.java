module com.luismanuel.cardtoonfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires retrofit2;
    requires retrofit2.converter.gson;
    requires java.sql;
    requires com.google.gson;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires okhttp3;
    requires com.jfoenix;

    exports com.luismanuel.cardtoonfx;
    exports com.luismanuel.cardtoonfx.modelos;
    opens com.luismanuel.cardtoonfx.modelos to com.google.gson;
    exports com.luismanuel.cardtoonfx.api;
    opens com.luismanuel.cardtoonfx to com.google.gson, javafx.fxml;
    exports com.luismanuel.cardtoonfx.controllers;
    opens com.luismanuel.cardtoonfx.controllers to com.google.gson, javafx.fxml;

}