package co.edu.itc.programacion.biblioteca.repositorio;

import co.edu.itc.programacion.biblioteca.modelo.Computador;
import java.util.ArrayList;
import java.util.List;

public class RepositorioComputador extends RepositorioRecursoBase<Computador> {

    public RepositorioComputador() {
        super();
    }

    @Override
    public List<Computador> buscarPorCriterio(String criterio) {
        List<Computador> resultados = new ArrayList<>();
        String lower = criterio.toLowerCase();

        for (Computador c : listaRecurso) {
            if ((c.getMarca() != null && c.getMarca().toLowerCase().contains(lower)) ||
                (c.getModelo() != null && c.getModelo().toLowerCase().contains(lower)) ||
                (c.getNombre() != null && c.getNombre().toLowerCase().contains(lower)) ||
                (c.getTipo() != null && c.getTipo().name().toLowerCase().contains(lower))) {
                resultados.add(c);
            }
        }
        return resultados;
    }
}
