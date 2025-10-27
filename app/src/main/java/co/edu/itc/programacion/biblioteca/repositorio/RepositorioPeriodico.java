package co.edu.itc.programacion.biblioteca.repositorio;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.itc.programacion.biblioteca.modelo.Periodico;

@Repository
public interface RepositorioPeriodico extends CrudRepository<Periodico, Integer> {

    @Query("SELECT * FROM PERIODICO WHERE LOWER(NOMBRE) LIKE LOWER(CONCAT('%', :criterio, '%')) " +
           "OR LOWER(EDITORIAL) LIKE LOWER(CONCAT('%', :criterio, '%'))")
    List<Periodico> buscarPorCriterio(@Param("criterio") String criterio);
}
