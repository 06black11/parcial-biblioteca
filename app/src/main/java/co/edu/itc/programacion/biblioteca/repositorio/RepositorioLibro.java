package co.edu.itc.programacion.biblioteca.repositorio;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import co.edu.itc.programacion.biblioteca.modelo.Libro;

public interface RepositorioLibro extends CrudRepository<Libro, Integer> {

    @Query("SELECT * FROM libro WHERE LOWER(nombre) LIKE CONCAT('%', LOWER(:criterio), '%') " +
           "OR LOWER(autor) LIKE CONCAT('%', LOWER(:criterio), '%') " +
           "OR LOWER(isbn) LIKE CONCAT('%', LOWER(:criterio), '%')")
    List<Libro> buscarPorCriterio(String criterio);
}
