package co.edu.itc.programacion.biblioteca.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import co.edu.itc.programacion.biblioteca.representation.LibroRepresentation;

@RestController
@RequestMapping("/libros")
public class LibroControladorRest {

    private final ServicioBiblioteca biblioteca;

    public LibroControladorRest(ServicioBiblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroRepresentation> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(new LibroRepresentation()); 
    }

    @PostMapping
    public ResponseEntity<LibroRepresentation> crear(@RequestBody LibroRepresentation libro) {
        return ResponseEntity.ok(libro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroRepresentation> modificar(@PathVariable Integer id,
                                                         @RequestBody LibroRepresentation libro) {
        return ResponseEntity.ok(libro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
    }
}
