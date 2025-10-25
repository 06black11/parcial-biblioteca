package co.edu.itc.programacion.biblioteca.repositorio;

import co.edu.itc.programacion.biblioteca.modelo.Libro;
import java.util.ArrayList;
import java.util.List;

public class RepositorioLibro extends RepositorioRecursoBase<Libro> {

    public RepositorioLibro() {
        super();
    }

    @Override
    public List<Libro> buscarPorCriterio(String criterio) {
        List<Libro> resultados = new ArrayList<>();
        String lower = criterio.toLowerCase();

        for (Libro l : listaRecurso) {
            if ((l.getTitulo() != null && l.getTitulo().toLowerCase().contains(lower)) ||
                (l.getAutor() != null && l.getAutor().toLowerCase().contains(lower)) ||
                (l.getIsbn() != null && l.getIsbn().toLowerCase().contains(lower))) {
                resultados.add(l);
            }
        }
        return resultados;
    }
}
