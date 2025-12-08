package co.edu.itc.programacion.biblioteca;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import co.edu.itc.programacion.biblioteca.infraestructura.ConfiguracionAplicacion;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import co.edu.itc.programacion.biblioteca.modelo.*;

public class Main_BACKUP {
    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(ConfiguracionAplicacion.class)) {

            ServicioBiblioteca servicio = context.getBean(ServicioBiblioteca.class);

            // 1. Agregar recursos
            servicio.agregar(new Libro(1, "Satanás", "Mario Mendoza", 2002, "ISBN-001"));
            servicio.agregar(new Libro(2, "It", "Stephen King", 1986, "ISBN-002"));
            servicio.agregar(new Libro(3, "La torre oscura", "Stephen King", 1986, "ISBN-003"));

            servicio.agregar(new Periodico(4, "El Tiempo", "El Tiempo Editorial", 2024));
            servicio.agregar(new Periodico(5, "Q'hubo", "Q'hubo Editorial", 2025));
            servicio.agregar(new Periodico(6, "El Espectador", "El Espectador Editorial", 2025));

            servicio.agregar(new Computador(7, "Computador HP", "HP", "Pavilion 15", "Portátil"));
            servicio.agregar(new Computador(8, "Computador Dell", "Dell", "Inspiron 14", "Escritorio"));
            servicio.agregar(new Computador(9, "Computador Lenovo", "Lenovo", "IdeaPad 3", "Portátil"));


            // 2. Listar todos los recursos
            System.out.println("\n=== 1. Recursos registrados ===");
            servicio.listarTodos().forEach(System.out::println);


            // 3. Buscar por criterio 'torre'
            System.out.println("\n=== 2. Buscar por criterio: 'torre' ===");
            servicio.buscarPorCriterio("torre").forEach(System.out::println);


            // 4. Modificar la primera coincidencia
            System.out.println("\n=== 3. Modificar la primera coincidencia encontrada ===");
            for (Recurso r : servicio.buscarPorCriterio("torre")) {
                r.setNombre("La torre oscura (Edición especial)");
                servicio.modificar(r.getId(), r);
                break;
            }


            // 5. Eliminar recurso por criterio Q'hubo
            System.out.println("\n=== 4. Eliminar recurso con criterio: Q'hubo ===");

            var resultados = servicio.buscarPorCriterio("Q'hubo");
            if (!resultados.isEmpty()) {
                Recurso recurso = resultados.get(0);
                System.out.println("Recurso eliminado: " + recurso);
                servicio.eliminarPeriodico(recurso.getId());
            }


            // 6. Listar recursos finales
            System.out.println("\n=== 5. Recursos finales ===");
            servicio.listarTodos().forEach(System.out::println);
        }
    }
}
