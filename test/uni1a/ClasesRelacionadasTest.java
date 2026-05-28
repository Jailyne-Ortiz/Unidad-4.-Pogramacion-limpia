package uni1a;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClasesRelacionadasTest {

    @Test
    public void testActorConvierteACSV() {
        Actor actor = new Actor("Sam Worthington", 47, "Australiano");

        assertEquals("Sam Worthington", actor.getNombre());
        assertEquals(47, actor.getEdad());
        assertEquals("Australiano", actor.getNacionalidad());
        assertEquals("Sam Worthington,47,Australiano", actor.convertirACSV());
    }

    @Test
    public void testTemporadaConvierteACSV() {
        Temporada temporada = new Temporada(1, 10);

        assertEquals(1, temporada.getNumero());
        assertEquals(10, temporada.getCantidadEpisodios());
        assertEquals("1,10", temporada.convertirACSV());
    }

    @Test
    public void testInvestigadorConvierteACSV() {
        Investigador investigador = new Investigador("Carl Sagan", "Astronomia");

        assertEquals("Carl Sagan", investigador.getNombre());
        assertEquals("Astronomia", investigador.getEspecialidad());
        assertEquals("Carl Sagan,Astronomia", investigador.convertirACSV());
    }
}