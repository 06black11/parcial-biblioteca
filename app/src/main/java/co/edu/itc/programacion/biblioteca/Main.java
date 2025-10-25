package co.edu.itc.programacion.biblioteca;

import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import co.edu.itc.programacion.biblioteca.modelo.Libro;
import co.edu.itc.programacion.biblioteca.modelo.Periodico;
import co.edu.itc.programacion.biblioteca.modelo.Computador;
import co.edu.itc.programacion.biblioteca.modelo.TipoComputador;
import co.edu.itc.programacion.biblioteca.modelo.Recurso;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ServicioBiblioteca<Recurso> servicio = new ServicioBiblioteca<>();

        
        servicio.agregar(new Libro(1, "Satanás", "Mario Mendoza", 2002, "ISBN-001"));
        servicio.agregar(new Libro(2, "En las montañas de la locura", "H.P. Lovecraft", 1936, "ISBN-002"));
        servicio.agregar(new Libro(3, "It", "Stephen King", 1986, "ISBN-003"));

        servicio.agregar(new Periodico(4, "El Tiempo", "El Tiempo Editorial", 2024));
        servicio.agregar(new Periodico(5, "El Espectador", "El Espectador Editorial", 2023));
        servicio.agregar(new Periodico(6, "Semana", "Semana Editorial", 2022));

        servicio.agregar(new Computador(7, "PC Biblioteca 1", "Dell", "Optiplex", TipoComputador.ESCRITORIO));
        servicio.agregar(new Computador(8, "Laptop Biblioteca 2", "HP", "Pavilion", TipoComputador.PORTATIL));
        servicio.agregar(new Computador(9, "Servidor Principal", "IBM", "x3550", TipoComputador.TABLET));

        
        System.out.println("=== LISTADO DE TODOS LOS RECURSOS ===");
        for (Recurso r : servicio.listarTodos()) {
            System.out.println(r);
        }

        
        System.out.println("\n=== BÚSQUEDA POR CRITERIO: 'HP' ===");
        List<Recurso> resultados = servicio.buscarPorCriterio("HP");
        resultados.forEach(System.out::println);

        
        System.out.println("\n=== MODIFICAR LIBRO CON ID 3 ===");
        Libro libroActualizado = new Libro(3, "It (Edición Especial)", "Stephen King", 1986, "ISBN-003");
        servicio.modificar(3, libroActualizado);

        
        System.out.println("\n=== ELIMINAR PERIÓDICO CON ID 6 ===");
        boolean eliminado = servicio.eliminarPeriodico(6);
        System.out.println("¿Eliminado? " + eliminado);

        
        System.out.println("\n=== LISTADO FINAL DE RECURSOS ===");
        for (Recurso r : servicio.listarTodos()) {
            System.out.println(r);
        }
    }
}
