package co.edu.itc.programacion.biblioteca.representacion;

public class ComputadorRepresentacion {

    private Integer id;
    private String nombre;
    private String marca;
    private String modelo;
    private String fechaRegistro;
    private String tipoRecurso;

    // 🔥 OBLIGATORIO para Jackson
    public ComputadorRepresentacion() {
        this.tipoRecurso = "computador";
    }

    public ComputadorRepresentacion(Integer id, String nombre, String marca, String modelo, String fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaRegistro = fechaRegistro;
        this.tipoRecurso = "computador";
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(String fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public String getTipoRecurso() { return tipoRecurso; }
}
