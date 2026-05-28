package uni1a;

public class Documental extends ContenidoAudiovisual {
    private String tema;

    public Documental(String titulo, int duracionEnMinutos, String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public void mostrarDetalles() {
        mostrarDatosBase("el documental");
        System.out.println("Tema: " + tema);
        System.out.println();
    }

    @Override
    public String convertirACSV() {
        return "DOCUMENTAL," + getTitulo() + "," + getDuracionEnMinutos() + "," + getGenero() + "," + tema;
    }
}