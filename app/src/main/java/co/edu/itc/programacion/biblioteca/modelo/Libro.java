package co.edu.itc.programacion.biblioteca.modelo;

public class Libro extends Recurso {
    private String titulo;
    private String autor;
    private int anio;
    private String isbn;

    public Libro(Integer id, String nombre, String autor, int anio, String isbn) {
        super(id, nombre); 
        this.autor = autor;
        this.anio = anio;
        this.isbn = isbn;
    }

    public Libro() {
        super();
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnio() { return anio; }
    public String getIsbn() { return isbn; }
}
