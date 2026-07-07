package org.example;

public class User {
    private String name;
    private String password;
    private Role rol;

    public User(String name, String password, Role rol) {
        this.name = name;
        this.password = password;
        if (name.equals("adminKarolay")) {
            this.rol = Role.ADMIN;
        }
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Role getRol() {
        return rol;
    }

    public String toString() {
        return name + "," + password;
    }
}
