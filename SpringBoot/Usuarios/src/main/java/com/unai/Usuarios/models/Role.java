package com.unai.Usuarios.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles") // el nombre de la tabla

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String rolname;


    public String getUsername()  {
        return this.rolname;
    }


}
