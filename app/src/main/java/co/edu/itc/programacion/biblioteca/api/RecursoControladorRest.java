package co.edu.itc.programacion.biblioteca.api;

import co.edu.itc.programacion.biblioteca.modelo.*;
import co.edu.itc.programacion.biblioteca.representacion.RecursoRepresentacion;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recursos")
public class RecursoControladorRest {

    private final ServicioBiblioteca servicio;

    public RecursoControladorRest(ServicioBiblioteca servicio) {
        this.servicio = servicio;
    }

    // ✅ LISTAR
    @GetMapping
    public List<RecursoRepresentacion> listarTodos() {
        return servicio.listarTodos().stream()
                .map(this::convertir)
                .collect(Collectors.toList());
    }

    // ✅ EDITAR
    @PutMapping("/{tipo}/{id}")
    public ResponseEntity<Void> editar(
            @PathVariable String tipo,
            @PathVariable Integer id,
            @RequestBody RecursoRepresentacion dto) {

        switch (tipo.toLowerCase()) {

            case "libro" -> {
                Libro l = servicio.obtenerLibro(id);
                if (l == null) return ResponseEntity.notFound().build();
                l.setNombre(dto.getNombre());
                servicio.modificar(id, l);
            }

            case "periodico" -> {
                Periodico p = servicio.obtenerPeriodico(id);
                if (p == null) return ResponseEntity.notFound().build();
                p.setNombre(dto.getNombre());
                servicio.modificar(id, p);
            }

            case "computador" -> {
                Computador c = servicio.obtenerComputador(id);
                if (c == null) return ResponseEntity.notFound().build();
                c.setNombre(dto.getNombre());
                servicio.modificar(id, c);
            }

            default -> {
                return ResponseEntity.badRequest().build();
            }
        }

        return ResponseEntity.ok().build();
    }

    // ✅ ELIMINAR  🔥 (ESTO ES LO QUE FALTABA)
    @DeleteMapping("/{tipo}/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable String tipo,
            @PathVariable Integer id) {

        switch (tipo.toLowerCase()) {

            case "libro" -> servicio.eliminarLibro(id);
            case "periodico" -> servicio.eliminarPeriodico(id);
            case "computador" -> servicio.eliminarComputador(id);
            default -> {
                return ResponseEntity.badRequest().build();
            }
        }

        return ResponseEntity.noContent().build(); // 204
    }

    // 🔁 CONVERTIR
    private RecursoRepresentacion convertir(Recurso r) {
        String tipo =
                r instanceof Libro ? "libro" :
                r instanceof Periodico ? "periodico" :
                r instanceof Computador ? "computador" : "desconocido";

        return new RecursoRepresentacion(
                r.getId(),
                r.getNombre(),
                r.getFechaRegistro(),
                tipo
        );
    }
}
