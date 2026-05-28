package uni1a;

public class Pelicula extends ContenidoAudiovisual {
    private String estudio;

    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    @Override
    public void mostrarDetalles() {
        mostrarDatosBase("la película");
        System.out.println("Estudio: " + estudio);
        System.out.println();
    }

    @Override
    public String convertirACSV() {
        return "PELICULA," + getTitulo() + "," + getDuracionEnMinutos() + "," + getGenero() + "," + estudio;
    }
}