package uni1a;

import java.io.*;
import java.util.ArrayList;
import java.util.function.Function;

public class RepositorioCSV<T extends ExportableCSV> implements LectorDatos<T>, EscritorDatos<T> {
    private String nombreArchivo;
    private String encabezado;
    private Function<String, T> creadorObjeto;

    public RepositorioCSV(String nombreArchivo, String encabezado, Function<String, T> creadorObjeto) {
        this.nombreArchivo = nombreArchivo;
        this.encabezado = encabezado;
        this.creadorObjeto = creadorObjeto;
    }

    @Override
    public void guardar(ArrayList<T> datos) {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));

            escritor.write(encabezado);
            escritor.newLine();

            for (T dato : datos) {
                escritor.write(dato.convertirACSV());
                escritor.newLine();
            }

            escritor.close();

        } catch (IOException e) {
            // No se imprime nada para mantener limpia la consola.
        }
    }

    @Override
    public ArrayList<T> leer() {
        ArrayList<T> datos = new ArrayList<>();

        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            boolean esEncabezado = true;

            while ((linea = lector.readLine()) != null) {
                if (esEncabezado) {
                    esEncabezado = false;
                } else {
                    datos.add(creadorObjeto.apply(linea));
                }
            }

            lector.close();

        } catch (IOException e) {
            // Si el archivo no existe o no se puede leer, se devuelve la lista vacía.
        }

        return datos;
    }
}