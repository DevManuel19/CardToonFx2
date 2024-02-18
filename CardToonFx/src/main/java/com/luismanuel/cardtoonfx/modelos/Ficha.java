package com.luismanuel.cardtoonfx.modelos;

public class Ficha {
    private Long id;
    private String imagen;
    private boolean alineado;
    private int nivel;
    private String nombre;
    private int precio;
    private int victorias;
    private int vida;
    private Jugador jugador;
    private Zona zona;

    public Ficha(Long id, String imagen, boolean alineado, int nivel, String nombre, int precio, int victorias, int vida, Jugador jugador, Zona zona) {
        this.id = id;
        this.imagen = imagen;
        this.alineado = alineado;
        this.nivel = nivel;
        this.nombre = nombre;
        this.precio = precio;
        this.victorias = victorias;
        this.vida = vida;
        this.jugador = jugador;
        this.zona = zona;
    }

    public Long getId() {
        return id;
    }

    public boolean isAlineado() {
        return alineado;
    }

    public int getNivel() {
        return nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getVictorias() {
        return victorias;
    }

    public int getVida() {
        return vida;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Zona getZona() {
        return zona;
    }

    public String getImagen() {
        return imagen;
    }

    @Override
    public String toString() {
        return "Ficha{" +
                "id=" + id +
                ", imagen='" + imagen + '\'' +
                ", alineado=" + alineado +
                ", nivel=" + nivel +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", victorias=" + victorias +
                ", vida=" + vida +
                ", jugador=" + jugador +
                ", zona=" + zona +
                '}';
    }
}