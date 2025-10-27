package co.edu.itc.programacion.biblioteca.modelo;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;


public abstract class Recurso {

    @Id
    private Integer id;

    private String nombre;

    @Column("FECHAREGISTRO")
    private LocalDateTime fechaRegistro;

    
    public Recurso() {
        this.fechaRegistro = LocalDateTime.now();
    }

    public Recurso(Integer id, String nombre) {
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
