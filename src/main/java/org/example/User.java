package org.example;

public class User {
    private String name;
    private String password;
    private Role rol;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        if (name.equalsIgnoreCase("karolay") || name.equalsIgnoreCase("Physicaly")) {
            this.rol = Role.ADMIN;
        } else {
            this.rol = Role.CLIENT;
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
