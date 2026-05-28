package uni1a;

import java.util.ArrayList;

public class ControladorContenido {
    private ArrayList<ContenidoAudiovisual> contenidos;
    private ArrayList<Actor> actores;
    private ArrayList<Temporada> temporadas;
    private ArrayList<Investigador> investigadores;
    private VistaConsola vista;

    private RepositorioCSV<ContenidoAudiovisual> repositorioContenidos;
    private RepositorioCSV<Actor> repositorioActores;
    private RepositorioCSV<Temporada> repositorioTemporadas;
    private RepositorioCSV<Investigador> repositorioInvestigadores;

    public ControladorContenido(VistaConsola vista) {
        this.vista = vista;

        contenidos = new ArrayList<>();
        actores = new ArrayList<>();
        temporadas = new ArrayList<>();
        investigadores = new ArrayList<>();

        inicializarDatos();
        inicializarRepositorios();
    }

    private void inicializarDatos() {
        contenidos.add(new Pelicula("Avatar", 125, "Accion", "20th Century Studios"));
        contenidos.add(new SerieDeTV("Game of Thrones", 60, "Fantasy", 8));
        contenidos.add(new Documental("Cosmos", 45, "Science", "Astronomy"));

        actores.add(new Actor("Sam Worthington", 47, "Australiano"));
        actores.add(new Actor("Emilia Clarke", 37, "Británica"));

        temporadas.add(new Temporada(1, 10));
        temporadas.add(new Temporada(2, 10));

        investigadores.add(new Investigador("Carl Sagan", "Astronomía"));
        investigadores.add(new Investigador("Neil deGrasse Tyson", "Astrofísica"));
    }

    private void inicializarRepositorios() {
        repositorioContenidos = new RepositorioCSV<>(
                "contenidos_guardados.csv",
                "tipo,titulo,duracion,genero,datoExtra",
                FabricaContenidoAudiovisual::crearDesdeCSV
        );

        repositorioActores = new RepositorioCSV<>(
                "actores_guardados.csv",
                "nombre,edad,nacionalidad",
                linea -> {
                    String[] datos = linea.split(",");
                    return new Actor(datos[0], Integer.parseInt(datos[1]), datos[2]);
                }
        );

        repositorioTemporadas = new RepositorioCSV<>(
                "temporadas_guardadas.csv",
                "numero,cantidadEpisodios",
                linea -> {
                    String[] datos = linea.split(",");
                    return new Temporada(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]));
                }
        );

        repositorioInvestigadores = new RepositorioCSV<>(
                "investigadores_guardados.csv",
                "nombre,especialidad",
                linea -> {
                    String[] datos = linea.split(",");
                    return new Investigador(datos[0], datos[1]);
                }
        );
    }

    public void iniciar() {
        int opcion;

        do {
            opcion = vista.mostrarMenu();
            ejecutarOpcion(opcion);
        } while (opcion != 6);
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                vista.mostrarContenidos(contenidos);
                break;
            case 2:
                vista.mostrarActores(actores);
                break;
            case 3:
                vista.mostrarTemporadas(temporadas);
                break;
            case 4:
                vista.mostrarInvestigadores(investigadores);
                break;
            case 5:
                guardarDatos();
                vista.mostrarMensaje("Datos guardados.");
                break;
            case 6:
                vista.mostrarMensaje("Programa finalizado.");
                break;
            default:
                vista.mostrarMensaje("Opción no válida.");
                break;
        }
    }

    private void guardarDatos() {
        repositorioContenidos.guardar(contenidos);
        repositorioActores.guardar(actores);
        repositorioTemporadas.guardar(temporadas);
        repositorioInvestigadores.guardar(investigadores);
    }
}