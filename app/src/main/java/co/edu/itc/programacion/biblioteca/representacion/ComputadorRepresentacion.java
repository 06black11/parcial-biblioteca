package co.edu.itc.programacion.biblioteca.representacion;

public class ComputadorRepresentacion {

    private final Integer id;
    private final String nombre;
    private final String marca;
    private final String modelo;
    private final String fechaRegistro;
    private final String tipoRecurso = "computador";

    public ComputadorRepresentacion(Integer id, String nombre, String marca, String modelo, String fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }
}
