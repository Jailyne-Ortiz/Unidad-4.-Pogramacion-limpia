package uni1a;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaConsola {
    private Scanner scanner;

    public VistaConsola() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("1. Ver contenidos audiovisuales");
        System.out.println("2. Ver actores");
        System.out.println("3. Ver temporadas");
        System.out.println("4. Ver investigadores");
        System.out.println("5. Guardar datos en archivos CSV");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");

        return scanner.nextInt();
    }

    public void mostrarContenidos(ArrayList<ContenidoAudiovisual> contenidos) {
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
        }
    }

    public void mostrarActores(ArrayList<Actor> actores) {
        for (Actor actor : actores) {
            actor.mostrarDetalles();
        }
    }

    public void mostrarTemporadas(ArrayList<Temporada> temporadas) {
        for (Temporada temporada : temporadas) {
            temporada.mostrarDetalles();
        }
    }

    public void mostrarInvestigadores(ArrayList<Investigador> investigadores) {
        for (Investigador investigador : investigadores) {
            investigador.mostrarDetalles();
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}