package com.api1.Primer.ejemplo.Interfaces;

import com.api1.Primer.ejemplo.Models.Juego;

import java.util.List;

public interface IJuegoService {

    List<Juego> getAll();

    Juego getById(Long id);

    Juego create(Juego juego);

    Juego update(Long id, Juego juego);

    boolean delete(Long id);
}
