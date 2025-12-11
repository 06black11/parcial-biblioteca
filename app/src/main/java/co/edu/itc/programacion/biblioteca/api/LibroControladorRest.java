package co.edu.itc.programacion.biblioteca.api;

import co.edu.itc.programacion.biblioteca.representacion.LibroRepresentacion;
import co.edu.itc.programacion.biblioteca.modelo.Libro;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/libros")
public class LibroControladorRest {

    private final ServicioBiblioteca biblioteca;

    public LibroControladorRest(ServicioBiblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroRepresentacion> obtenerPorId(@PathVariable("id") Integer id) {
        Libro libro = biblioteca.obtenerLibro(id);
        if (libro == null) {
            return ResponseEntity.notFound().build();
        }
        LibroRepresentacion representacion = new LibroRepresentacion(
                libro.getId(),
                libro.getNombre(),
                libro.getNombre(),
                libro.getAutor(),
                String.valueOf(libro.getAnio()),
                libro.getIsbn(),
                "");
        return ResponseEntity.ok(representacion);
    }

    @PostMapping
    public void crear(@RequestBody LibroRepresentacion libroDto) {
        Libro libro = new Libro(
                null,
                libroDto.getNombre(),
                libroDto.getAutor(),
                Integer.parseInt(libroDto.getAnio()),
                libroDto.getIsbn());
        biblioteca.agregarRecurso(libro);
    }

    @PutMapping("/{id}")
    public void modificar(@PathVariable("id") Integer id, @RequestBody LibroRepresentacion libroDto) {
        Libro libroExistente = new Libro(
                id,
                libroDto.getNombre(),
                libroDto.getAutor(),
                Integer.parseInt(libroDto.getAnio()),
                libroDto.getIsbn());
        biblioteca.modificar(id, libroExistente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        biblioteca.eliminarLibro(id);
    }

    @GetMapping
    public List<LibroRepresentacion> listarTodos() {
        return biblioteca.listarTodos().stream()
                .filter(r -> r instanceof Libro)
                .map(l -> (Libro) l)
                .map(libro -> new LibroRepresentacion(
                        libro.getId(),
                        libro.getNombre(),
                        libro.getNombre(),
                        libro.getAutor(),
                        String.valueOf(libro.getAnio()),
                        libro.getIsbn(),
                        ""))
                .collect(Collectors.toList());
    }
}
