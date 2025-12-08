package co.edu.itc.programacion.biblioteca.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("COMPUTADOR")
public class Computador extends Recurso {

    @Column("MARCA")
    private String marca;

    @Column("MODELO")
    private String modelo;

    @Column("TIPO")
    private String tipo;

    public Computador() {
        super();
    }

    public Computador(Integer id, String nombre, String marca, String modelo, String tipo) {
        super(id, nombre);
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getTipo() { return tipo; }

    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public String toString() {
        return "Computador{id=" + getId() +
                ", nombre='" + getNombre() +
                "', marca='" + marca +
                "', modelo='" + modelo +
                "', tipo='" + tipo +
                "', fechaRegistro=" + getFechaRegistro() + "}";
    }
}
