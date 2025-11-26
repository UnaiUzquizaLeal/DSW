package com.api1.Primer.ejemplo.Controllers;

import com.api1.Primer.ejemplo.Models.Juego;
import com.api1.Primer.ejemplo.Services.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/juegos")
public class MainController {

    @Autowired
    private JuegoService juegoService;

    // ------------------------
    //       GET /juegos
    // ------------------------
    @GetMapping
    public ResponseEntity<List<Juego>> getAll() {
        return ResponseEntity.ok(juegoService.getAll());
    }

    // ------------------------
    //     GET /juegos/{id}
    // ------------------------
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {

        Juego juego = juegoService.getById(id);

        if (juego == null) {
            return ResponseEntity.status(404).body("Juego no encontrado");
        }

        return ResponseEntity.ok(juego);
    }

    // ------------------------
    //        POST /juegos
    // ------------------------
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Juego juego) {
        try {
            Juego nuevo = juegoService.create(juego);
            return ResponseEntity.status(201).body(nuevo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ------------------------
    //     PUT /juegos/{id}
    // ------------------------
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Juego juego) {

        try {
            Juego actualizado = juegoService.update(id, juego);

            if (actualizado == null) {
                return ResponseEntity.status(404).body("Juego no encontrado");
            }

            return ResponseEntity.ok(actualizado);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ------------------------
    //     DELETE /juegos/{id}
    // ------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        boolean eliminado = juegoService.delete(id);

        if (!eliminado) {
            return ResponseEntity.status(404).body("Juego no encontrado");
        }

        return ResponseEntity.ok("Juego eliminado correctamente");
    }
}
