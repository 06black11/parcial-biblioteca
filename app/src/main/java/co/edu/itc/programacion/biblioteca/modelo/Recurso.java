package co.edu.itc.programacion.biblioteca.modelo;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;

public abstract class Recurso {
    private Integer id;
    private String nombre;
    private LocalDate fechaRegistro;

    public Recurso(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.fechaRegistro = LocalDate.now();
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
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + " [id=" + id + ", nombre=" + nombre + ", fechaRegistro=" + fechaRegistro;
    }
}