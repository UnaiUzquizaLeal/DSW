package com.api1.Primer.ejemplo.Models;

public class Juego {

    private Long id;
    private String titulo;
    private String genero;

    // Constructor vacío (requerido para POST/PUT)
    public Juego() {}

    // Constructor completo
    public Juego(Long id, String titulo, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
}
