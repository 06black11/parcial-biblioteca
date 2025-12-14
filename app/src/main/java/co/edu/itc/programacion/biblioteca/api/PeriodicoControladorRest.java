package co.edu.itc.programacion.biblioteca.api;

import co.edu.itc.programacion.biblioteca.representacion.PeriodicoRepresentacion;
import co.edu.itc.programacion.biblioteca.modelo.Periodico;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/periodicos")
public class PeriodicoControladorRest {

    private final ServicioBiblioteca biblioteca;

    public PeriodicoControladorRest(ServicioBiblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodicoRepresentacion> obtenerPorId(@PathVariable("id") Integer id) {
        Periodico periodico = biblioteca.obtenerPeriodico(id);
        if (periodico == null) {
            return ResponseEntity.notFound().build();
        }
        PeriodicoRepresentacion representacion = new PeriodicoRepresentacion(
                periodico.getId(),
                periodico.getNombre(),
                periodico.getEditorial(),
                String.valueOf(periodico.getAnio()),
                "");
        return ResponseEntity.ok(representacion);
    }

    @PostMapping
    public void crear(@RequestBody PeriodicoRepresentacion dto) {
        Periodico periodico = new Periodico(
                null,
                dto.getNombre(),
                dto.getEditorial(),
                Integer.parseInt(dto.getAnio()));
        biblioteca.agregarRecurso(periodico);
    }

    @PutMapping("/{id}")
    public void modificar(@PathVariable("id") Integer id, @RequestBody PeriodicoRepresentacion dto) {
        Periodico periodico = new Periodico(
                id,
                dto.getNombre(),
                dto.getEditorial(),
                Integer.parseInt(dto.getAnio()));
        biblioteca.modificar(id, periodico);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        biblioteca.eliminarPeriodico(id);
    }

    @GetMapping
    public List<PeriodicoRepresentacion> listarTodos() {
        return biblioteca.listarTodos().stream()
                .filter(r -> r instanceof Periodico)
                .map(r -> (Periodico) r)
                .map(periodico -> new PeriodicoRepresentacion(
                        periodico.getId(),
                        periodico.getNombre(),
                        periodico.getEditorial(),
                        String.valueOf(periodico.getAnio()),
                        ""))
                .collect(Collectors.toList());
    }
}
