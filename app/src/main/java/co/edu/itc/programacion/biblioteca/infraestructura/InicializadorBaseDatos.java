package co.edu.itc.programacion.biblioteca.Infraestructura;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class InicializadorBaseDatos implements InitializingBean, DisposableBean {

    private final DataSource dataSource;

    public InicializadorBaseDatos(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void afterPropertiesSet() {
        inicializar();
    }

    @Override
    public void destroy() {
        finalizar();
    }

    public void inicializar() {
        try (Connection conexion = dataSource.getConnection();
             Statement statement = conexion.createStatement()) {

            // 📘 LIBRO
            statement.execute("""
                CREATE TABLE IF NOT EXISTS LIBRO (
                    ID INTEGER AUTO_INCREMENT PRIMARY KEY,
                    NOMBRE VARCHAR(100),
                    AUTOR VARCHAR(100),
                    ANIO INT,
                    ISBN VARCHAR(50),
                    FECHA_REGISTRO DATE
                );
            """);

            // 📰 PERIODICO
            statement.execute("""
                CREATE TABLE IF NOT EXISTS PERIODICO (
                    ID INTEGER AUTO_INCREMENT PRIMARY KEY,
                    NOMBRE VARCHAR(100),
                    EDITORIAL VARCHAR(100),
                    ANIO INT,
                    FECHA_REGISTRO DATE
                );
            """);

            // 💻 COMPUTADOR
            statement.execute("""
                CREATE TABLE IF NOT EXISTS COMPUTADOR (
                    ID INTEGER AUTO_INCREMENT PRIMARY KEY,
                    NOMBRE VARCHAR(100),
                    MARCA VARCHAR(100),
                    MODELO VARCHAR(100),
                    TIPO VARCHAR(50),
                    FECHA_REGISTRO DATE
                );
            """);

            System.out.println("✅ Base de datos creada correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void finalizar() {
        try (Connection conexion = dataSource.getConnection()) {
            conexion.createStatement().execute("SHUTDOWN");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
