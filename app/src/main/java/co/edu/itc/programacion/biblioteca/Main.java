package co.edu.itc.programacion.biblioteca;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import co.edu.itc.programacion.biblioteca.servicio.ServicioBiblioteca;
import co.edu.itc.programacion.biblioteca.modelo.*;

import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final ServicioBiblioteca servicio;

    public Main(ServicioBiblioteca servicio) {
        this.servicio = servicio;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("1. AGREGANDO RECURSOS");

        // 📚 LIBROS NUEVOS
        servicio.agregarRecurso(new Libro(1, "El llamado de Cthulhu", "H. P. Lovecraft", 1928, "ISBN-HP001"));
        servicio.agregarRecurso(new Libro(2, "En las montañas de la locura", "H. P. Lovecraft", 1936, "ISBN-HP002"));
        servicio.agregarRecurso(new Libro(3, "La sombra sobre Innsmouth", "H. P. Lovecraft", 1931, "ISBN-HP003"));

        // 📰 PERIÓDICOS NUEVOS
        servicio.agregarRecurso(new Periodico(4, "El Colombiano", "Editorial Medellín", 2024));
        servicio.agregarRecurso(new Periodico(5, "Semana", "Publicaciones Semana", 2023));
        servicio.agregarRecurso(new Periodico(6, "El País", "Editorial Cali", 2022));

        // 💻 COMPUTADORES NUEVOS
        servicio.agregarRecurso(
                new Computador(7, "HP Victus 16", "HP", "Victus 16", TipoComputador.PORTATIL));
        servicio.agregarRecurso(
                new Computador(8, "Lenovo Legion T5", "Lenovo", "Legion T5", TipoComputador.ESCRITORIO));
        servicio.agregarRecurso(
                new Computador(9, "HP Pavilion 15", "HP", "Pavilion 15", TipoComputador.PORTATIL));

        System.out.println("Recursos agregados exitosamente.");

        System.out.println("\n2. BUSCANDO RECURSOS POR 'Tiempo'");
        String criterioBusqueda = "Tiempo";
        List<Recurso> resultadosBusqueda = servicio.buscarPorCriterio(criterioBusqueda);
        if (!resultadosBusqueda.isEmpty()) {
            resultadosBusqueda.forEach(System.out::println);
        } else {
            System.out.println("No se encontraron coincidencias para '" + criterioBusqueda + "'.");
        }

        System.out.println("\n3. ACTUALIZANDO UN RECURSO");
        if (!resultadosBusqueda.isEmpty()) {
            Recurso recursoParaActualizar = resultadosBusqueda.get(0);
            Recurso recursoActualizado;

            if (recursoParaActualizar instanceof Periodico p) {
                recursoActualizado = new Periodico(
                        p.getId(),
                        "Diario El Tiempo - Modificado nueva edición",
                        p.getEditorial(),
                        p.getAnio());
            } else if (recursoParaActualizar instanceof Libro l) {
                recursoActualizado = new Libro(
                        l.getId(),
                        "Diario El Tiempo - Modificado nueva edición",
                        l.getAutor(),
                        l.getAnio(),
                        l.getIsbn());
            } else if (recursoParaActualizar instanceof Computador c) {
                recursoActualizado = new Computador(
                        c.getId(),
                        "Diario El Tiempo - Modificado nueva edición",
                        c.getMarca(),
                        c.getModelo(),
                        c.getTipo());
            } else {
                recursoActualizado = recursoParaActualizar;
            }

            servicio.modificar(recursoParaActualizar.getId(), recursoActualizado);
            System.out.println("Recurso con ID " + recursoParaActualizar.getId() + " actualizado.");
        }

        System.out.println("\n4. ELIMINANDO UN RECURSO");
        String criterioEliminar = "La Odisea";
        List<Recurso> recursoAEliminar = servicio.buscarPorCriterio(criterioEliminar);
        if (!recursoAEliminar.isEmpty()) {
            Recurso recurso = recursoAEliminar.get(0);
            boolean eliminado = false;
            if (recurso instanceof Libro) {
                eliminado = servicio.eliminarLibro(recurso.getId());
            } else if (recurso instanceof Periodico) {
                eliminado = servicio.eliminarPeriodico(recurso.getId());
            } else if (recurso instanceof Computador) {
                eliminado = servicio.eliminarComputador(recurso.getId());
            }
            if (eliminado) {
                System.out.println("Recurso '" + criterioEliminar + "' con ID " + recurso.getId() + " eliminado.");
            } else {
                System.out.println("No se pudo eliminar el recurso.");
            }
        } else {
            System.out.println("No se encontró el recurso para eliminar con el criterio '" + criterioEliminar + "'.");
        }

        System.out.println("\n5. LISTANDO TODOS LOS RECURSOS");
        List<Recurso> todosLosRecursos = servicio.listarTodos();
        if (!todosLosRecursos.isEmpty()) {
            todosLosRecursos.forEach(System.out::println);
        } else {
            System.out.println("No hay recursos en la biblioteca.");
        }
    }
}
