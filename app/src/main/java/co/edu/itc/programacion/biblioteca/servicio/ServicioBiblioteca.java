package co.edu.itc.programacion.biblioteca.servicio;
 
import co.edu.itc.programacion.biblioteca.modelo.*;
import co.edu.itc.programacion.biblioteca.repositorio.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
 
public class ServicioBiblioteca {
    private final RepositorioLibro repositorioLibro;
    private final RepositorioPeriodico repositorioPeriodico;
    private final RepositorioComputador repositorioComputador;
 
    public ServicioBiblioteca(RepositorioLibro repositorioLibro, RepositorioPeriodico repositorioPeriodico, RepositorioComputador repositorioComputador) {
        this.repositorioLibro = repositorioLibro;
        this.repositorioPeriodico = repositorioPeriodico;
        this.repositorioComputador = repositorioComputador;
    }
 
    public Recurso agregarRecurso(Recurso recurso) {
        if (recurso instanceof Libro) {
            return repositorioLibro.save((Libro) recurso);
        } else if (recurso instanceof Periodico) {
            return repositorioPeriodico.save((Periodico) recurso);
        } else if (recurso instanceof Computador) {
            return repositorioComputador.save((Computador) recurso);
        }
        return null;
    }
 
    public Recurso modificar(Integer id, Recurso recurso) {
        if (recurso instanceof Libro) {
            return repositorioLibro.save((Libro) recurso);
        } else if (recurso instanceof Periodico) {
            return repositorioPeriodico.save((Periodico) recurso);
        } else if (recurso instanceof Computador) {
            return repositorioComputador.save((Computador) recurso);
        }
        return null;
    }
 
    public boolean eliminarLibro(Integer id) {
        if (repositorioLibro.existsById(id)){
            repositorioLibro.deleteById(id);
            return true;
        }
        return false;
    }
 
    public boolean eliminarPeriodico(Integer id) {
        if (repositorioPeriodico.existsById(id)){
            repositorioPeriodico.deleteById(id);
            return true;
        }
        return false;
    }
 
 
    public boolean eliminarComputador(Integer id) {
        if (repositorioComputador.existsById(id)){
            repositorioComputador.deleteById(id);
            return true;
        }
        return false;
    }
 
    public List<Recurso> listarTodos() {
    List<Recurso> todos = new ArrayList<>();

    for (Libro libro : repositorioLibro.findAll()) {
        todos.add(libro);
    }
    for (Periodico periodico : repositorioPeriodico.findAll()) {
        todos.add(periodico);
    }
    for (Computador computador : repositorioComputador.findAll()) {
        todos.add(computador);
    }

    return todos;
}
 
    public List<Recurso> buscarPorCriterio(String criterio) {
        List<Recurso> resultados = new ArrayList<>();
        resultados.addAll(repositorioLibro.buscarPorCriterio(criterio));
        resultados.addAll(repositorioPeriodico.buscarPorCriterio(criterio));
        resultados.addAll(repositorioComputador.buscarPorCriterio(criterio));
        return resultados;
    }
 
    public Libro obtenerLibro(Integer id) {
        return repositorioLibro.findById(id).orElse(null);
    }
 
    public Periodico obtenerPeriodico(Integer id) {
        return repositorioPeriodico.findById(id).orElse(null);
    }
 
    public Computador obtenerComputador(Integer id) {
        return repositorioComputador.findById(id).orElse(null);
    }
}