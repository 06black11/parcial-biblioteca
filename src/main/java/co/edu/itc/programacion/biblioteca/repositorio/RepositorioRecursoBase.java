package co.edu.itc.programacion.biblioteca.repositorio;

import co.edu.itc.programacion.biblioteca.modelo.Recurso;
import java.util.ArrayList;
import java.util.List;

public abstract class RepositorioRecursoBase<T extends Recurso> implements RepositorioRecurso<T> {

    protected List<T> listaRecurso;

    public RepositorioRecursoBase() {
        this.listaRecurso = new ArrayList<>();
    }

    @Override
    public T guardar(T recurso) {
        listaRecurso.add(recurso);
        return recurso;
    }

    @Override
    public T actualizar(Integer id, T recurso) {
        for (int i = 0; i < listaRecurso.size(); i++) {
            if (listaRecurso.get(i).getId().equals(id)) {
                listaRecurso.set(i, recurso);
                return recurso;
            }
        }
        return null;
    }

    @Override
    public boolean eliminar(Integer id) {
        return listaRecurso.removeIf(r -> r.getId().equals(id));
    }

    @Override
    public T obtener(Integer id) {
        for (T recurso : listaRecurso) {
            if (recurso.getId().equals(id)) {
                return recurso;
            }
        }
        return null;
    }

    @Override
    public List<T> listarTodos() {
        return new ArrayList<>(listaRecurso);
    }
}
