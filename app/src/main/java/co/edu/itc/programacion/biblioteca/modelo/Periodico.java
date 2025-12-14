package co.edu.itc.programacion.biblioteca.modelo;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("PERIODICO")
public class Periodico extends Recurso {

    @Column("EDITORIAL")
    private String editorial;

    @Column("ANIO")
    private int anio;

    public Periodico(Integer id, String nombre, String editorial, int anio) {
        super(id, nombre);   // 👈 aquí ya se asigna el id
        this.editorial = editorial;
        this.anio = anio;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", editorial=" + editorial +
                ", anio=" + anio + "]";
    }
}
