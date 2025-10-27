package co.edu.itc.programacion.biblioteca.repositorio;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.itc.programacion.biblioteca.modelo.Libro;

@Repository
public interface RepositorioLibro extends CrudRepository<Libro, Integer> {

    @Query("SELECT * FROM LIBRO WHERE LOWER(NOMBRE) LIKE LOWER(CONCAT('%', :criterio, '%')) " +
           "OR LOWER(AUTOR) LIKE LOWER(CONCAT('%', :criterio, '%')) " +
           "OR LOWER(ISBN) LIKE LOWER(CONCAT('%', :criterio, '%'))")
    List<Libro> buscarPorCriterio(@Param("criterio") String criterio);
}
