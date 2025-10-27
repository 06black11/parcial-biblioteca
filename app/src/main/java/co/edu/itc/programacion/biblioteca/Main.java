package co.edu.itc.programacion.biblioteca;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import co.edu.itc.programacion.biblioteca.infraestructura.ConfiguracionAplicacion;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import co.edu.itc.programacion.biblioteca.modelo.*;

public class Main {
    public static void main(String[] args) {

        
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(ConfiguracionAplicacion.class)) {

            
            ServicioBiblioteca servicio = context.getBean(ServicioBiblioteca.class);

        
            servicio.agregar(new Libro(1, "Satanás", "Mario Mendoza", 2002, "ISBN-001"));
            servicio.agregar(new Libro(2, "It", "Stephen King", 1986, "ISBN-002"));
            servicio.agregar(new Periodico(3, "El Tiempo", "El Tiempo Editorial", 2024));
            servicio.agregar(new Computador(4, "PC Biblioteca 1", "Dell", "Optiplex", "ESCRITORIO"));

            
            System.out.println("\n=== Recursos registrados ===");
            servicio.listarTodos().forEach(System.out::println);

            
            System.out.println("\n=== Buscar por criterio: 'Tiempo' ===");
            servicio.buscarPorCriterio("Tiempo").forEach(System.out::println);

            
            servicio.eliminarComputador(4);

            System.out.println("\n=== Recursos después de eliminar ===");
            servicio.listarTodos().forEach(System.out::println);
        }
    }
}
