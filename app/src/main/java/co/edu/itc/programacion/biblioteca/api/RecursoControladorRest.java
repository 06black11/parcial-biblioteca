package co.edu.itc.programacion.biblioteca.api;

import co.edu.itc.programacion.biblioteca.representacion.RecursoRepresentacion;
import co.edu.itc.programacion.biblioteca.modelo.Recurso;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RecursoControladorRest {

    private final ServicioBiblioteca biblioteca;

    public RecursoControladorRest(ServicioBiblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @GetMapping("/api/recursos")
    public List<RecursoRepresentacion> listarTodos() {
        return biblioteca.listarTodos().stream()
                .map(this::convertirARepresentacion)
                .collect(Collectors.toList());
    }

    private RecursoRepresentacion convertirARepresentacion(Recurso recurso) {
        String tipo;
        if (recurso instanceof co.edu.itc.programacion.biblioteca.modelo.Libro) {
            tipo = "libro";
        } else if (recurso instanceof co.edu.itc.programacion.biblioteca.modelo.Periodico) {
            tipo = "periodico";
        } else if (recurso instanceof co.edu.itc.programacion.biblioteca.modelo.Computador) {
            tipo = "computador";
        } else {
            tipo = "desconocido";
        }

        return new RecursoRepresentacion(
                recurso.getId(),
                recurso.getNombre(),
                recurso.getFechaRegistro(),
                tipo);
    }
}
