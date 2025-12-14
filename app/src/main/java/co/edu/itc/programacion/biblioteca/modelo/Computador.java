package co.edu.itc.programacion.biblioteca.modelo;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("COMPUTADOR")
public class Computador extends Recurso {

    @Column("MARCA")
    private String marca;

    @Column("MODELO")
    private String modelo;

    @Column("TIPO")
    private TipoComputador tipo;

    // 🔥 Constructor vacío OBLIGATORIO para Spring
    public Computador() {
        super(null, null);
    }

    // Constructor completo
    public Computador(Integer id, String nombre, String marca, String modelo, TipoComputador tipo) {
        super(id, nombre);
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    // Getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public TipoComputador getTipo() {
        return tipo;
    }

    // Setters (recomendados para Spring Data)
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTipo(TipoComputador tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", marca=" + marca +
                ", modelo=" + modelo +
                ", tipo=" + tipo + "]";
    }
}
