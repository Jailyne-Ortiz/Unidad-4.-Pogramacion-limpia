package uni1a;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContenidoAudiovisualTest {

    @Test
    public void testPeliculaConvierteACSV() {
        Pelicula pelicula = new Pelicula("Avatar", 125, "Accion", "20th Century Studios");

        assertEquals("Avatar", pelicula.getTitulo());
        assertEquals(125, pelicula.getDuracionEnMinutos());
        assertEquals("Accion", pelicula.getGenero());
        assertEquals("20th Century Studios", pelicula.getEstudio());
        assertEquals("PELICULA,Avatar,125,Accion,20th Century Studios", pelicula.convertirACSV());
    }

    @Test
    public void testSerieConvierteACSV() {
        SerieDeTV serie = new SerieDeTV("Game of Thrones", 60, "Fantasy", 8);

        assertEquals("Game of Thrones", serie.getTitulo());
        assertEquals(60, serie.getDuracionEnMinutos());
        assertEquals("Fantasy", serie.getGenero());
        assertEquals(8, serie.getTemporadas());
        assertEquals("SERIE,Game of Thrones,60,Fantasy,8", serie.convertirACSV());
    }

    @Test
    public void testDocumentalConvierteACSV() {
        Documental documental = new Documental("Cosmos", 45, "Science", "Astronomy");

        assertEquals("Cosmos", documental.getTitulo());
        assertEquals(45, documental.getDuracionEnMinutos());
        assertEquals("Science", documental.getGenero());
        assertEquals("Astronomy", documental.getTema());
        assertEquals("DOCUMENTAL,Cosmos,45,Science,Astronomy", documental.convertirACSV());
    }
}