package co.edu.itc.programacion.biblioteca.representation;

public class LibroRepresentation extends RecursoRepresentation {

    private String autor;
    private Integer anio;
    private String isbn;

    public LibroRepresentation() {}

    public LibroRepresentation(
            Integer id, String nombre, String autor, Integer anio, String isbn
    ) {
        super(id, "LIBRO", nombre, java.time.LocalDateTime.now());
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
}
