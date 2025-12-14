package co.edu.itc.programacion.biblioteca.modelo;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("LIBRO")
public class Libro extends Recurso {

    @Column("AUTOR")
    private String autor;

    @Column("ANIO")
    private int anio;

    @Column("ISBN")
    private String isbn;

    public Libro(Integer id, String nombre, String autor, int anio, String isbn) {
        super(id, nombre);
        this.autor = autor;
        this.anio = anio;
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public String getIsbn() {
        return isbn;
    }
}
