package co.edu.itc.programacion.biblioteca.infraestructura;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class InicializadorBaseDatos {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InicializadorBaseDatos(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        crearTablas();
    }

    private void crearTablas() {
        jdbcTemplate.execute("""
            CREATE TABLE IF NOT EXISTS LIBRO (
                ID INT PRIMARY KEY,
                NOMBRE VARCHAR(100),
                FECHAREGISTRO TIMESTAMP,
                TITULO VARCHAR(100),
                AUTOR VARCHAR(100),
                ANIO INT,
                ISBN VARCHAR(50)
            )
        """);

        jdbcTemplate.execute("""
            CREATE TABLE IF NOT EXISTS PERIODICO (
                ID INT PRIMARY KEY,
                NOMBRE VARCHAR(100),
                FECHAREGISTRO TIMESTAMP,
                EDITORIAL VARCHAR(100),
                ANIO INT
            )
        """);

        jdbcTemplate.execute("""
            CREATE TABLE IF NOT EXISTS COMPUTADOR (
                ID INT PRIMARY KEY,
                NOMBRE VARCHAR(100),
                FECHAREGISTRO TIMESTAMP,
                MARCA VARCHAR(100),
                MODELO VARCHAR(100),
                TIPO VARCHAR(50)
            )
        """);
    }

    @PreDestroy
    public void cerrarBaseDatos() {
        System.out.println("Cerrando base de datos...");
        jdbcTemplate.execute("SHUTDOWN");
    }
}
