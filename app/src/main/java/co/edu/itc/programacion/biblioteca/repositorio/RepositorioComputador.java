package co.edu.itc.programacion.biblioteca.repositorio;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.itc.programacion.biblioteca.modelo.Computador;

@Repository
public interface RepositorioComputador extends CrudRepository<Computador, Integer> {

    @Query("SELECT * FROM COMPUTADOR WHERE LOWER(NOMBRE) LIKE LOWER(CONCAT('%', :criterio, '%')) " +
           "OR LOWER(MARCA) LIKE LOWER(CONCAT('%', :criterio, '%')) " +
           "OR LOWER(MODELO) LIKE LOWER(CONCAT('%', :criterio, '%')) " +
           "OR LOWER(TIPO) LIKE LOWER(CONCAT('%', :criterio, '%'))")
    List<Computador> buscarPorCriterio(@Param("criterio") String criterio);
}
