package com.luismanuel.cardtoonfx.modelos;

public class Zona {
    private Long id;
    private String nombre;

    public Zona(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Zona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
