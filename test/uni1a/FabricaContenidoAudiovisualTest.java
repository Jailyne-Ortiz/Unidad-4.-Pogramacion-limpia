package uni1a;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FabricaContenidoAudiovisualTest {

    @Test
    public void testCrearPeliculaDesdeCSV() {
        ContenidoAudiovisual contenido =
                FabricaContenidoAudiovisual.crearDesdeCSV("PELICULA,Avatar,125,Accion,20th Century Studios");

        assertTrue(contenido instanceof Pelicula);
        assertEquals("Avatar", contenido.getTitulo());
    }

    @Test
    public void testCrearSerieDesdeCSV() {
        ContenidoAudiovisual contenido =
                FabricaContenidoAudiovisual.crearDesdeCSV("SERIE,Game of Thrones,60,Fantasy,8");

        assertTrue(contenido instanceof SerieDeTV);
        assertEquals("Game of Thrones", contenido.getTitulo());
    }

    @Test
    public void testCrearDocumentalDesdeCSV() {
        ContenidoAudiovisual contenido =
                FabricaContenidoAudiovisual.crearDesdeCSV("DOCUMENTAL,Cosmos,45,Science,Astronomy");

        assertTrue(contenido instanceof Documental);
        assertEquals("Cosmos", contenido.getTitulo());
    }
}