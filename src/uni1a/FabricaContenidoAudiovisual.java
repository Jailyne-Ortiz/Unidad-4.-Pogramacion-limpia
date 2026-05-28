package uni1a;

public class FabricaContenidoAudiovisual {

    public static ContenidoAudiovisual crearDesdeCSV(String linea) {
        String[] datos = linea.split(",");

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
}