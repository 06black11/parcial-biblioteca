package co.edu.itc.programacion.biblioteca.api;

import co.edu.itc.programacion.biblioteca.modelo.Computador;
import co.edu.itc.programacion.biblioteca.representacion.ComputadorRepresentacion;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/computadores")
public class ComputadorControladorRest {

    private final ServicioBiblioteca biblioteca;

    public ComputadorControladorRest(ServicioBiblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComputadorRepresentacion> obtenerPorId(@PathVariable("id") Integer id) {
        Computador c = biblioteca.obtenerComputador(id);
        if (c == null) {
            return ResponseEntity.notFound().build();
        }
        ComputadorRepresentacion representacion = new ComputadorRepresentacion(
                c.getId(),
                c.getNombre(),
                c.getMarca(),
                c.getModelo(),
                "");
        return ResponseEntity.ok(representacion);
    }

    @PostMapping
    public void crear(@RequestBody ComputadorRepresentacion computadorDto) {
        Computador c = new Computador(
                null,
                computadorDto.getNombre(),
                computadorDto.getMarca(),
                computadorDto.getModelo(),
                null);
        biblioteca.agregarRecurso(c);
    }

    @PutMapping("/{id}")
    public void modificar(@PathVariable("id") Integer id, @RequestBody ComputadorRepresentacion computadorDto) {
        Computador c = new Computador(
                id,
                computadorDto.getNombre(),
                computadorDto.getMarca(),
                computadorDto.getModelo(),
                null);
        biblioteca.modificar(id, c);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        biblioteca.eliminarComputador(id);
    }

    @GetMapping
    public List<ComputadorRepresentacion> listarTodos() {
        return biblioteca.listarTodos().stream()
                .filter(r -> r instanceof Computador)
                .map(r -> (Computador) r)
                .map(c -> new ComputadorRepresentacion(
                        c.getId(),
                        c.getNombre(),
                        c.getMarca(),
                        c.getModelo(),
                        ""))
                .collect(Collectors.toList());
    }
}
