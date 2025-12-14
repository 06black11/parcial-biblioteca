package co.edu.itc.programacion.biblioteca.representacion;

import java.time.LocalDate;

public class RecursoRepresentacion {

    private Integer id;
    private String nombre;
    private LocalDate fechaRegistro;
    private String tipo;

    public RecursoRepresentacion(Integer id, String nombre, LocalDate fechaRegistro, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }
}
