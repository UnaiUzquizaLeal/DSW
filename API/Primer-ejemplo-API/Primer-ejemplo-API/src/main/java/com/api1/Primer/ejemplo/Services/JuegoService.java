package com.api1.Primer.ejemplo.Services;

import com.api1.Primer.ejemplo.Models.Juego;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JuegoService {

    private List<Juego> juegos = new ArrayList<>();
    private Long contadorId = 4L; // empezamos desde 4 porque ya tienes 3 juegos

    public JuegoService() {
        juegos.add(new Juego(1L, "Minecraft", "Sandbox"));
        juegos.add(new Juego(2L, "Fortnite", "Shooter"));
        juegos.add(new Juego(3L, "ZeldaBOTW", "Aventura"));
    }

    // --------------------------
    //       VALIDACIONES
    // --------------------------
    private void validarJuego(Juego juego) {

        if (juego.getTitulo() == null || juego.getTitulo().isBlank()) {
            throw new IllegalArgumentException("El título es obligatorio");
        }

        if (juego.getTitulo().length() < 5 || juego.getTitulo().length() > 15) {
            throw new IllegalArgumentException("El título debe tener entre 5 y 15 caracteres");
        }

        if (juego.getGenero() == null || juego.getGenero().isBlank()) {
            throw new IllegalArgumentException("El género es obligatorio");
        }

        if (juego.getGenero().length() < 2 || juego.getGenero().length() > 12) {
            throw new IllegalArgumentException("El género debe tener entre 2 y 12 caracteres");
        }
    }

    // --------------------------
    //           CRUD
    // --------------------------

    // LISTAR TODOS
    public List<Juego> getAll() {
        return juegos;
    }

    // BUSCAR UNO
    public Juego getById(Long id) {
        return juegos.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // CREAR
    public Juego create(Juego juego) {
        validarJuego(juego);

        juego.setId(contadorId++);
        juegos.add(juego);
        return juego;
    }

    // ACTUALIZAR
    public Juego update(Long id, Juego datos) {

        Juego existente = getById(id);

        if (existente == null) {
            return null;
        }

        validarJuego(datos);

        existente.setTitulo(datos.getTitulo());
        existente.setGenero(datos.getGenero());

        return existente;
    }

    // BORRAR
    public boolean delete(Long id) {
        return juegos.removeIf(i -> i.getId().equals(id));
    }
}
