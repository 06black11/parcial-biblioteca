package co.edu.itc.programacion.biblioteca.modelo;

import java.time.LocalDateTime;

public abstract class Recurso {
    private Integer id;
    private String nombre;
    private LocalDateTime fechaRegistro;

   
    public Recurso() {
        this.fechaRegistro = LocalDateTime.now();
    }

    
    protected Recurso(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.fechaRegistro = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + 
               " [id=" + id + 
               ", nombre=" + nombre + 
               ", fechaRegistro=" + fechaRegistro + "]";
    }
}
