package co.edu.itc.programacion.biblioteca.repositorio;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import co.edu.itc.programacion.biblioteca.modelo.Periodico;

public interface RepositorioPeriodico extends CrudRepository<Periodico, Integer> {

    @Query("SELECT * FROM periodico WHERE LOWER(nombre) LIKE CONCAT('%', LOWER(:criterio), '%') " +
           "OR LOWER(editorial) LIKE CONCAT('%', LOWER(:criterio), '%')")
    List<Periodico> buscarPorCriterio(String criterio);
}
