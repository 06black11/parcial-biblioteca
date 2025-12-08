package co.edu.itc.programacion.biblioteca.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import co.edu.itc.programacion.biblioteca.representation.PeriodicoRepresentation;

@RestController
@RequestMapping("/periodicos")
public class PeriodicoControladorRest {

    private final ServicioBiblioteca biblioteca;

    public PeriodicoControladorRest(ServicioBiblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodicoRepresentation> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(new PeriodicoRepresentation());
    }

    @PostMapping
    public ResponseEntity<PeriodicoRepresentation> crear(@RequestBody PeriodicoRepresentation periodico) {
        return ResponseEntity.ok(periodico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeriodicoRepresentation> modificar(@PathVariable Integer id,
                                                             @RequestBody PeriodicoRepresentation periodico) {
        return ResponseEntity.ok(periodico);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
    }
}
