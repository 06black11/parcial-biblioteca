package co.edu.itc.programacion.biblioteca.modelo;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("LIBRO")
public class Libro extends Recurso {

    @Column("AUTOR")
    private String autor;

    @Column("ANIO")
    private Integer anio;

    @Column("ISBN")
    private String isbn;

    public Libro() {
        super();
    }

    public Libro(Integer id, String nombre, String autor, Integer anio, String isbn) {
        super(id, nombre);
        this.autor = autor;
        this.anio = anio;
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getAnio() {
        return anio;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro{id=" + getId() + 
               ", nombre='" + getNombre() + 
               "', autor='" + autor + 
               "', año=" + anio + 
               ", isbn='" + isbn + 
               "', fechaRegistro=" + getFechaRegistro() + "}";
    }
}
