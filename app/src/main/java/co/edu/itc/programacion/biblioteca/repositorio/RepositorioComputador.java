package co.edu.itc.programacion.biblioteca.repositorio;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import co.edu.itc.programacion.biblioteca.modelo.Computador;

public interface RepositorioComputador extends CrudRepository<Computador, Integer> {

    @Query("""
           SELECT * FROM COMPUTADOR
           WHERE LOWER(MARCA) LIKE CONCAT('%', LOWER(:criterio), '%')
           OR LOWER(MODELO) LIKE CONCAT('%', LOWER(:criterio), '%')
           OR LOWER(TIPO) LIKE CONCAT('%', LOWER(:criterio), '%')
           """)
    List<Computador> buscarPorCriterio(String criterio);
}
