package co.edu.itc.programacion.biblioteca.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("COMPUTADOR")
public class Computador extends Recurso {

    @Id
    private Integer id;

    @Column("MARCA")
    private String marca;

    @Column("MODELO")
    private String modelo;

    @Column("TIPO")
    private TipoComputador tipo;

    public Computador(Integer id, String nombre, String marca, String modelo, TipoComputador tipo) {
        super(id, nombre);
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

    public TipoComputador getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", marca=" + marca +
                ", modelo=" + modelo +
                ", tipo=" + tipo + "]";
    }
}
