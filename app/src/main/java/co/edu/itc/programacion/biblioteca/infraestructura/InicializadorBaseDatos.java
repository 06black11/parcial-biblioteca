package co.edu.itc.programacion.biblioteca.Infraestructura;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public void afterPropertiesSet() throws Exception {
        inicializar();
    }

    @Override
    public void destroy() throws Exception {
        finalizar();
    }

    
    public void inicializar() {
        try(Connection conexion = dataSource.getConnection()) {
            Statement statement = conexion.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS LIBRO (NOMBRE VARCHAR(100), AUTOR VARCHAR(100), ANIO INT, ISBN VARCHAR(50));");
            statement.execute("CREATE TABLE IF NOT EXISTS PERIODICO (NOMBRE VARCHAR(100), EDITORIAL VARCHAR(100), ANIO INT);");
            statement.execute("CREATE TABLE IF NOT EXISTS COMPUTADOR (MARCA VARCHAR(100), MODELO VARCHAR(100), TIPO VARCHAR(50));");
            statement.close();

            PreparedStatement preparedStatement = conexion.prepareStatement(
                "INSERT INTO LIBRO (NOMBRE, AUTOR, ANIO, ISBN) VALUES (?, ?, ?, ?)"
            );
          preparedStatement.setString(1, "El llamado de Cthulhu");
          preparedStatement.setString(2, "H. P. Lovecraft");
          preparedStatement.setInt(3, 1928);
          preparedStatement.setString(4, "ISBN-9999");
          preparedStatement.executeUpdate();
          preparedStatement.close();


            PreparedStatement preparedStatement2 = conexion.prepareStatement(
                "INSERT INTO PERIODICO (NOMBRE, EDITORIAL, ANIO) VALUES (?, ?, ?)"
            );
            preparedStatement2.setString(1, "El Tiempo");
            preparedStatement2.setString(2, "Editorial Bogotá");
            preparedStatement2.setInt(3, 2023);
            preparedStatement2.executeUpdate();
            preparedStatement2.close();

            PreparedStatement preparedStatement3 = conexion.prepareStatement(
                "INSERT INTO COMPUTADOR (MARCA, MODELO, TIPO) VALUES (?, ?, ?)"
            );
            preparedStatement3.setString(1, "hp");
            preparedStatement3.setString(2, "pavilion 15");
            preparedStatement3.setString(3, "Portátil");
            preparedStatement3.executeUpdate();
            preparedStatement3.close();

            System.out.println("✅ Base de datos inicializada correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void finalizar() {
        try(Connection conexion = dataSource.getConnection()) {
            conexion.createStatement().execute("SHUTDOWN");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
