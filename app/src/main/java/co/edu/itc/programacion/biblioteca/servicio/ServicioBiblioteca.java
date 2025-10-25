package co.edu.itc.programacion.biblioteca.servicio;

import java.util.List;

import co.edu.itc.programacion.biblioteca.modelo.Recurso;
import co.edu.itc.programacion.biblioteca.modelo.Libro;
import co.edu.itc.programacion.biblioteca.modelo.Periodico;
import co.edu.itc.programacion.biblioteca.modelo.Computador;
import co.edu.itc.programacion.biblioteca.repositorio.RepositorioRecurso;
import co.edu.itc.programacion.biblioteca.repositorio.RepositorioLibro;
import co.edu.itc.programacion.biblioteca.repositorio.RepositorioPeriodico;
import co.edu.itc.programacion.biblioteca.repositorio.RepositorioComputador;

public class ServicioBiblioteca<T> {
    private RepositorioRecurso<Libro> repositorioLibro = new RepositorioLibro();
    private RepositorioRecurso<Periodico> repositorioPeriodico = new RepositorioPeriodico();
    private RepositorioRecurso<Computador> repositorioComputador = new RepositorioComputador();

    public ServicioBiblioteca() {}

   
    public Recurso agregar(Recurso recurso) {
        if (recurso instanceof Libro) {
            return repositorioLibro.guardar((Libro) recurso);
        } else if (recurso instanceof Periodico) {
            return repositorioPeriodico.guardar((Periodico) recurso);
        } else if (recurso instanceof Computador) {
            return repositorioComputador.guardar((Computador) recurso);
        }
        return null;
    }

    public Recurso modificar(Integer id, Recurso recurso) {
        if (recurso instanceof Libro) {
            return repositorioLibro.actualizar(id, (Libro) recurso);
        } else if (recurso instanceof Periodico) {
            return repositorioPeriodico.actualizar(id, (Periodico) recurso);
        } else if (recurso instanceof Computador) {
            return repositorioComputador.actualizar(id, (Computador) recurso);
        }
        return null;
    }

    public boolean eliminarLibro(Integer id) {
        return repositorioLibro.eliminar(id);
    }

    public boolean eliminarPeriodico(Integer id) {
        return repositorioPeriodico.eliminar(id);
    }

    public boolean eliminarComputador(Integer id) {
        return repositorioComputador.eliminar(id);
    }

    public List<Recurso> listarTodos() {
        
        List<Recurso> recursos = new java.util.ArrayList<>();
        recursos.addAll(repositorioLibro.listarTodos());
        recursos.addAll(repositorioPeriodico.listarTodos());
        recursos.addAll(repositorioComputador.listarTodos());
        return recursos;
    }

    public List<Recurso> buscarPorCriterio(String criterio) {
        List<Recurso> resultados = new java.util.ArrayList<>();
        resultados.addAll(repositorioLibro.buscarPorCriterio(criterio));
        resultados.addAll(repositorioPeriodico.buscarPorCriterio(criterio));
        resultados.addAll(repositorioComputador.buscarPorCriterio(criterio));
        return resultados;
    }

    public Libro obtenerLibro(Integer id) {
        return repositorioLibro.obtener(id);
    }

    public Periodico obtenerPeriodico(Integer id) {
        return repositorioPeriodico.obtener(id);
    }

    public Computador obtenerComputador(Integer id) {
        return repositorioComputador.obtener(id);
    }
}
