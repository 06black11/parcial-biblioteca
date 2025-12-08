package co.edu.itc.programacion.biblioteca.representation;

public class PeriodicoRepresentation extends RecursoRepresentation {

    private String editorial;
    private Integer anio;

    public PeriodicoRepresentation() {}

    public PeriodicoRepresentation(
            Integer id, String nombre, String editorial, Integer anio
    ) {
        super(id, "PERIODICO", nombre, java.time.LocalDateTime.now());
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
}
