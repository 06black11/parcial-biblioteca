package co.edu.itc.programacion.biblioteca.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import java.time.LocalDate;

public abstract class Recurso {

    @Id
    @Column("ID")
    protected Integer id;

    @Column("NOMBRE")
    protected String nombre;

    @Column("FECHA_REGISTRO")
    protected LocalDate fechaRegistro;

    // 🔥 CONSTRUCTOR VACÍO OBLIGATORIO
    protected Recurso() {
        this.fechaRegistro = LocalDate.now();
    }

    // Constructor normal
    protected Recurso(Integer id, String nombre) {
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

    // 👈 NECESARIO PARA EDITAR
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
