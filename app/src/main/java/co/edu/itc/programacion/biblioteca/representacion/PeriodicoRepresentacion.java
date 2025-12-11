package co.edu.itc.programacion.biblioteca.representacion;

public class PeriodicoRepresentacion {

    private final Integer id;
    private final String nombre;
    private final String editorial;
    private final String anio;
    private final String fechaRegistro;
    private final String tipoRecurso = "periodico";

    public PeriodicoRepresentacion(Integer id, String nombre, String editorial, String anio, String fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.editorial = editorial;
        this.anio = anio;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getAnio() {
        return anio;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }
}
