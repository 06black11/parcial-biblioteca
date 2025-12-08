package co.edu.itc.programacion.biblioteca.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import co.edu.itc.programacion.biblioteca.representation.ComputadorRepresentation;

@RestController
@RequestMapping("/computadores")
public class ComputadorControladorRest {

    private final ServicioBiblioteca biblioteca;

    public ComputadorControladorRest(ServicioBiblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComputadorRepresentation> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(new ComputadorRepresentation());
    }

    @PostMapping
    public ResponseEntity<ComputadorRepresentation> crear(@RequestBody ComputadorRepresentation computador) {
        return ResponseEntity.ok(computador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComputadorRepresentation> modificar(@PathVariable Integer id,
                                                              @RequestBody ComputadorRepresentation computador) {
        return ResponseEntity.ok(computador);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
    }
}
