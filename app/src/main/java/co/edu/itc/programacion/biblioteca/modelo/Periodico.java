package co.edu.itc.programacion.biblioteca.modelo;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("PERIODICO")
public class Periodico extends Recurso {

    @Column("EDITORIAL")
    private String editorial;

    @Column("ANIO")
    private Integer anio;

    public Periodico() {
        super();
    }

    public Periodico(Integer id, String nombre, String editorial, Integer anio) {
        super(id, nombre); 
        this.editorial = editorial;
        this.anio = anio;
    }

    public String getEditorial() {
        return editorial;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Periodico{id=" + getId() + 
               ", nombre='" + getNombre() + 
               "', editorial='" + editorial + 
               "', año=" + anio + 
               ", fechaRegistro=" + getFechaRegistro() + "}";
    }
}
