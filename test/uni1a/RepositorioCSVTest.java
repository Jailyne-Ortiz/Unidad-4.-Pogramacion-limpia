package uni1a;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class RepositorioCSVTest {

    @TempDir
    File carpetaTemporal;

    @Test
    public void testGuardarYLeerActores() {
        File archivo = new File(carpetaTemporal, "actores.csv");

        RepositorioCSV<Actor> repositorio = new RepositorioCSV<>(
                archivo.getAbsolutePath(),
                "nombre,edad,nacionalidad",
                linea -> {
                    String[] datos = linea.split(",");
                    return new Actor(datos[0], Integer.parseInt(datos[1]), datos[2]);
                }
        );

        ArrayList<Actor> actores = new ArrayList<>();
        actores.add(new Actor("Emilia Clarke", 37, "Britanica"));

        repositorio.guardar(actores);

        ArrayList<Actor> actoresLeidos = repositorio.leer();

        assertEquals(1, actoresLeidos.size());
        assertEquals("Emilia Clarke", actoresLeidos.get(0).getNombre());
        assertEquals(37, actoresLeidos.get(0).getEdad());
        assertEquals("Britanica", actoresLeidos.get(0).getNacionalidad());
    }

    @Test
    public void testLeerArchivoInexistenteDevuelveListaVacia() {
        File archivo = new File(carpetaTemporal, "no_existe.csv");

        RepositorioCSV<Actor> repositorio = new RepositorioCSV<>(
                archivo.getAbsolutePath(),
                "nombre,edad,nacionalidad",
                linea -> {
                    String[] datos = linea.split(",");
                    return new Actor(datos[0], Integer.parseInt(datos[1]), datos[2]);
                }
        );

        ArrayList<Actor> actores = repositorio.leer();

        assertTrue(actores.isEmpty());
    }
}
