package co.edu.itc.programacion.biblioteca.representation;

public class ComputadorRepresentation extends RecursoRepresentation {

    private String marca;
    private String modelo;
    private String tipo;

    public ComputadorRepresentation() {}

    public ComputadorRepresentation(
            Integer id, String nombre, String marca, String modelo, String tipo
    ) {
        super(id, "COMPUTADOR", nombre, java.time.LocalDateTime.now());
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
