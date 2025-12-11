package co.edu.itc.programacion.biblioteca.representacion;

public class LibroRepresentacion {

    private final Integer id;
    private final String nombre;
    private final String titulo;
    private final String autor;
    private final String anio;
    private final String isbn;
    private final String fechaRegistro;
    private final String tipoRecurso = "libro";

    public LibroRepresentacion(Integer id, String nombre, String titulo, String autor,
            String anio, String isbn, String fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.isbn = isbn;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getAnio() {
        return anio;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }
}
