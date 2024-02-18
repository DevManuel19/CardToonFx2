package com.luismanuel.cardtoonfx.modelos;

public class Jugador {
    private Long id;
    private String nombre;
    private String perfilIcon;
    private int dinero;
    private int partidasGanadas;
    private Usuario usuario;

    public Jugador() {
    }
    public Jugador(Long id,int dinero, String nombre, int partidasGanadas, String perfilIcon, Usuario usuario) {
        this.id = id;
        this.dinero = dinero;
        this.nombre = nombre;
        this.partidasGanadas = partidasGanadas;
        this.perfilIcon = perfilIcon;
        this.usuario = usuario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPerfilIcon(String perfilIcon) {
        this.perfilIcon = perfilIcon;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public Long getId() {
        return id;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getDinero() {
        return dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public String getPerfilIcon() {
        return perfilIcon;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", dinero=" + dinero +
                ", nombre='" + nombre + '\'' +
                ", partidasGanadas=" + partidasGanadas +
                ", perfilIcon='" + perfilIcon + '\'' +
                '}';
    }
}