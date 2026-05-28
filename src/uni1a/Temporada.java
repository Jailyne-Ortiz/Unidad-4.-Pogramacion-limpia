package uni1a;

public class Temporada implements Mostrable, ExportableCSV {
    private int numero;
    private int cantidadEpisodios;

    public Temporada(int numero, int cantidadEpisodios) {
        this.numero = numero;
        this.cantidadEpisodios = cantidadEpisodios;
    }

    public int getNumero() {
        return numero;
    }

    public int getCantidadEpisodios() {
        return cantidadEpisodios;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Temporada:");
        System.out.println("Número: " + numero);
        System.out.println("Cantidad de episodios: " + cantidadEpisodios);
        System.out.println();
    }

    @Override
    public String convertirACSV() {
        return numero + "," + cantidadEpisodios;
    }
}