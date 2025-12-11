package co.edu.itc.programacion.biblioteca.representacion;

import java.time.LocalDate;

public class RecursoRepresentacion {

    private final Integer id;
    private final String nombre;
    private final LocalDate fechaRegistro;
    private final String tipoRecurso;

    public RecursoRepresentacion(Integer id, String nombre, LocalDate fechaRegistro, String tipoRecurso) {
        this.id = id;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
        this.tipoRecurso = tipoRecurso;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }
}
