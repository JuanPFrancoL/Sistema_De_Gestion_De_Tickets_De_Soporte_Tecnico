package org.example;

public class User {
    private String name;
    private String password;
    private Rol rol;

    public User(String name, String password, Rol rol) {
        this.name = name;
        this.password = password;
        this.rol = rol;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Rol getRol() {
        return rol;
    }

    public String toString() {
        return name + "," + password;
    }
}
