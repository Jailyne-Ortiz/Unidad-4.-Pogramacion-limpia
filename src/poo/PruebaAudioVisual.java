package poo;

import uni1a.ControladorContenido;
import uni1a.VistaConsola;

public class PruebaAudioVisual {
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        ControladorContenido controlador = new ControladorContenido(vista);

        controlador.iniciar();
    }
}