package co.edu.itc.programacion.biblioteca.repositorio;

import co.edu.itc.programacion.biblioteca.modelo.Periodico;
import java.util.ArrayList;
import java.util.List;

public class RepositorioPeriodico extends RepositorioRecursoBase<Periodico> {

    public RepositorioPeriodico() {
        super();
    }

    @Override
    public List<Periodico> buscarPorCriterio(String criterio) {
        List<Periodico> resultados = new ArrayList<>();
        String lower = criterio.toLowerCase();

        for (Periodico p : listaRecurso) {
            if ((p.getEditorial() != null && p.getEditorial().toLowerCase().contains(lower)) ||
                (p.getNombre() != null && p.getNombre().toLowerCase().contains(lower))) {
                resultados.add(p);
            }
        }
        return resultados;
    }
}
