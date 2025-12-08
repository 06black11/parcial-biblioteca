package co.edu.itc.programacion.biblioteca.representation;

import java.time.LocalDateTime;

public class RecursoRepresentation {

    private Integer id;
    private String tipoRecurso;
    private String nombre;
    private LocalDateTime fechaRegistro;

    public RecursoRepresentation() {}

    public RecursoRepresentation(Integer id, String tipoRecurso, String nombre, LocalDateTime fechaRegistro) {
        this.id = id;
        this.tipoRecurso = tipoRecurso;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getId() {
        return id;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
