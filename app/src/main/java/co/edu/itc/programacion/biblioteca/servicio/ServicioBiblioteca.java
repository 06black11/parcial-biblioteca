package co.edu.itc.programacion.biblioteca.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.itc.programacion.biblioteca.modelo.*;
import co.edu.itc.programacion.biblioteca.repositorio.*;

@Service
public class ServicioBiblioteca {

    @Autowired
    private RepositorioLibro repositorioLibro;

    @Autowired
    private RepositorioPeriodico repositorioPeriodico;

    @Autowired
    private RepositorioComputador repositorioComputador;

    
    public Recurso agregar(Recurso recurso) {
        if (recurso instanceof Libro) {
            return repositorioLibro.save((Libro) recurso);
        } else if (recurso instanceof Periodico) {
            return repositorioPeriodico.save((Periodico) recurso);
        } else if (recurso instanceof Computador) {
            return repositorioComputador.save((Computador) recurso);
        }
        return null;
    }

   
    public Recurso modificar(Recurso recurso) {
        if (recurso instanceof Libro) {
            return repositorioLibro.save((Libro) recurso);
        } else if (recurso instanceof Periodico) {
            return repositorioPeriodico.save((Periodico) recurso);
        } else if (recurso instanceof Computador) {
            return repositorioComputador.save((Computador) recurso);
        }
        return null;
    }

   
    public void eliminarLibro(Integer id) {
        repositorioLibro.deleteById(id);
    }

    public void eliminarPeriodico(Integer id) {
        repositorioPeriodico.deleteById(id);
    }

    public void eliminarComputador(Integer id) {
        repositorioComputador.deleteById(id);
    }

    
    public List<Recurso> listarTodos() {
        List<Recurso> recursos = new ArrayList<>();
        repositorioLibro.findAll().forEach(recursos::add);
        repositorioPeriodico.findAll().forEach(recursos::add);
        repositorioComputador.findAll().forEach(recursos::add);
        return recursos;
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
