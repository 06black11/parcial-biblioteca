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

        // 📚 LIBROS (ID = null → INSERT)
        servicio.agregarRecurso(
                new Libro(null, "El llamado de Cthulhu", "H. P. Lovecraft", 1928, "ISBN-HP001"));
        servicio.agregarRecurso(
                new Libro(null, "En las montañas de la locura", "H. P. Lovecraft", 1936, "ISBN-HP002"));
        servicio.agregarRecurso(
                new Libro(null, "La sombra sobre Innsmouth", "H. P. Lovecraft", 1931, "ISBN-HP003"));

        // 📰 PERIÓDICOS
        servicio.agregarRecurso(
                new Periodico(null, "El Colombiano", "Editorial Medellín", 2024));
        servicio.agregarRecurso(
                new Periodico(null, "Semana", "Publicaciones Semana", 2023));
        servicio.agregarRecurso(
                new Periodico(null, "El País", "Editorial Cali", 2022));

        // 💻 COMPUTADORES
        servicio.agregarRecurso(
                new Computador(null, "HP Victus 16", "HP", "Victus 16", TipoComputador.PORTATIL));
        servicio.agregarRecurso(
                new Computador(null, "Lenovo Legion T5", "Lenovo", "Legion T5", TipoComputador.ESCRITORIO));
        servicio.agregarRecurso(
                new Computador(null, "HP Pavilion 15", "HP", "Pavilion 15", TipoComputador.PORTATIL));

        System.out.println("✅ Recursos agregados correctamente.");

        // ================= BUSCAR =================
        System.out.println("\n2. BUSCANDO RECURSOS POR 'Tiempo'");
        String criterioBusqueda = "Tiempo";
        List<Recurso> resultados = servicio.buscarPorCriterio(criterioBusqueda);

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron resultados.");
        } else {
            resultados.forEach(System.out::println);
        }

        // ================= ACTUALIZAR =================
        System.out.println("\n3. ACTUALIZANDO UN RECURSO");

        if (!resultados.isEmpty()) {
            Recurso r = resultados.get(0);
            Recurso actualizado;

            if (r instanceof Periodico p) {
                actualizado = new Periodico(
                        p.getId(),
                        "Diario El Tiempo - Edición Modificada",
                        p.getEditorial(),
                        p.getAnio());
            } else if (r instanceof Libro l) {
                actualizado = new Libro(
                        l.getId(),
                        "Diario El Tiempo - Edición Modificada",
                        l.getAutor(),
                        l.getAnio(),
                        l.getIsbn());
            } else if (r instanceof Computador c) {
                actualizado = new Computador(
                        c.getId(),
                        "Diario El Tiempo - Edición Modificada",
                        c.getMarca(),
                        c.getModelo(),
                        c.getTipo());
            } else {
                actualizado = r;
            }

            servicio.modificar(r.getId(), actualizado);
            System.out.println("✅ Recurso actualizado correctamente.");
        }

        // ================= LISTAR =================
        System.out.println("\n4. LISTANDO TODOS LOS RECURSOS");
        servicio.listarTodos().forEach(System.out::println);
    }
}
