package uni1a;

import java.io.*;
import java.util.ArrayList;

public class GestorArchivos {

    public static void guardarContenidos(String nombreArchivo, ArrayList<ContenidoAudiovisual> contenidos) {
        ArrayList<String> lineas = new ArrayList<>();
        lineas.add("tipo,titulo,duracion,genero,datoExtra");

        for (ContenidoAudiovisual contenido : contenidos) {
            lineas.add(contenido.convertirACSV());
        }

        escribirArchivo(nombreArchivo, lineas, "contenidos");
    }

    public static ArrayList<ContenidoAudiovisual> leerContenidos(String nombreArchivo) {
        ArrayList<ContenidoAudiovisual> contenidos = new ArrayList<>();
        ArrayList<String> lineas = leerArchivoSinEncabezado(nombreArchivo, "contenidos");

        for (String linea : lineas) {
            String[] datos = linea.split(",");
            contenidos.add(crearContenidoDesdeCSV(datos));
        }

        return contenidos;
    }

    private static ContenidoAudiovisual crearContenidoDesdeCSV(String[] datos) {
        String tipo = datos[0];
        String titulo = datos[1];
        int duracion = Integer.parseInt(datos[2]);
        String genero = datos[3];
        String datoExtra = datos[4];

        if (tipo.equalsIgnoreCase("PELICULA")) {
            return new Pelicula(titulo, duracion, genero, datoExtra);
        }

        if (tipo.equalsIgnoreCase("SERIE")) {
            return new SerieDeTV(titulo, duracion, genero, Integer.parseInt(datoExtra));
        }

        return new Documental(titulo, duracion, genero, datoExtra);
    }

    public static void guardarActores(String nombreArchivo, ArrayList<Actor> actores) {
        ArrayList<String> lineas = new ArrayList<>();
        lineas.add("nombre,edad,nacionalidad");

        for (Actor actor : actores) {
            lineas.add(actor.convertirACSV());
        }

        escribirArchivo(nombreArchivo, lineas, "actores");
    }

    public static ArrayList<Actor> leerActores(String nombreArchivo) {
        ArrayList<Actor> actores = new ArrayList<>();
        ArrayList<String> lineas = leerArchivoSinEncabezado(nombreArchivo, "actores");

        for (String linea : lineas) {
            String[] datos = linea.split(",");
            actores.add(new Actor(datos[0], Integer.parseInt(datos[1]), datos[2]));
        }

        return actores;
    }

    public static void guardarTemporadas(String nombreArchivo, ArrayList<Temporada> temporadas) {
        ArrayList<String> lineas = new ArrayList<>();
        lineas.add("numero,cantidadEpisodios");

        for (Temporada temporada : temporadas) {
            lineas.add(temporada.convertirACSV());
        }

        escribirArchivo(nombreArchivo, lineas, "temporadas");
    }

    public static ArrayList<Temporada> leerTemporadas(String nombreArchivo) {
        ArrayList<Temporada> temporadas = new ArrayList<>();
        ArrayList<String> lineas = leerArchivoSinEncabezado(nombreArchivo, "temporadas");

        for (String linea : lineas) {
            String[] datos = linea.split(",");
            temporadas.add(new Temporada(Integer.parseInt(datos[0]), Integer.parseInt(datos[1])));
        }

        return temporadas;
    }

    public static void guardarInvestigadores(String nombreArchivo, ArrayList<Investigador> investigadores) {
        ArrayList<String> lineas = new ArrayList<>();
        lineas.add("nombre,especialidad");

        for (Investigador investigador : investigadores) {
            lineas.add(investigador.convertirACSV());
        }

        escribirArchivo(nombreArchivo, lineas, "investigadores");
    }

    public static ArrayList<Investigador> leerInvestigadores(String nombreArchivo) {
        ArrayList<Investigador> investigadores = new ArrayList<>();
        ArrayList<String> lineas = leerArchivoSinEncabezado(nombreArchivo, "investigadores");

        for (String linea : lineas) {
            String[] datos = linea.split(",");
            investigadores.add(new Investigador(datos[0], datos[1]));
        }

        return investigadores;
    }

    private static void escribirArchivo(String nombreArchivo, ArrayList<String> lineas, String tipoDato) {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));

            for (String linea : lineas) {
                escritor.write(linea);
                escritor.newLine();
            }

            escritor.close();

        } catch (IOException e) {
            System.out.println("Error al guardar " + tipoDato + ": " + e.getMessage());
        }
    }

    private static ArrayList<String> leerArchivoSinEncabezado(String nombreArchivo, String tipoDato) {
        ArrayList<String> lineas = new ArrayList<>();

        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            boolean esEncabezado = true;

            while ((linea = lector.readLine()) != null) {
                if (esEncabezado) {
                    esEncabezado = false;
                } else {
                    lineas.add(linea);
                }
            }

            lector.close();

        } catch (IOException e) {
            System.out.println("Error al leer " + tipoDato + ": " + e.getMessage());
        }

        return lineas;
    }
}