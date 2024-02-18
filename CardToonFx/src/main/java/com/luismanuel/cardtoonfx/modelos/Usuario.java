package com.luismanuel.cardtoonfx.modelos;

public class Usuario {
    private Long id;
    private String nombre;
    private String email;
    private String password;
    private boolean admin;

    public Usuario(String nombre, String email, String password, boolean admin) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                '}';
    }
}
