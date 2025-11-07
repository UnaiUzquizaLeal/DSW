package com.unai.Usuarios.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // el nombre de la tabla


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username; // será el campo único para login

    @Column(nullable = false)
    private String password; // contraseña (encriptada)

    @Column(nullable = false)
    private String role; // ejemplo: ROLE_USER o ROLE_ADMIN

    private boolean enabled = true; // si el usuario está activo

    public String getUsername()  {
        return this.username;
    }
    public String getPassword()  {
        return this.password;
    }
    public String getRole()  {
        return this.role;

    }public boolean isEnabled()  {
        return this.enabled;
    }

    public void setPassword(String encode) {
        
    }

    public void setRole(String user) {
    }
}
