package co.edu.itc.programacion.biblioteca.repositorio;

import java.util.ArrayList;
import java.util.List;

public abstract class RepositorioRecursoBase<T> implements RepositorioRecurso<T> {
    protected List<T> listaRecurso;

    public RepositorioRecursoBase() {
        this.listaRecurso = new ArrayList<>();
    }

   
    
   
    public T actualizar(Integer id, T recurso) {
        if (id >= 0 && id < listaRecurso.size()) {
            listaRecurso.set(id, recurso);
            return recurso;
        }
        return null;
    }
    public T guardar(T recurso) {
        listaRecurso.add(recurso);
        return recurso;
    }

  
    public boolean eliminar(Integer id) {
        if (id >= 0 && id < listaRecurso.size()) {
            listaRecurso.remove((int) id);
            return true;
        }
        return false;
    }
public List<T> listarTodos() {
        return listaRecurso;
    }

public T obtener (Integer id) {
        if (id >= 0 && id < listaRecurso.size()) {
            return listaRecurso.get(id);
        }
        return null;
    }

   
    
}
