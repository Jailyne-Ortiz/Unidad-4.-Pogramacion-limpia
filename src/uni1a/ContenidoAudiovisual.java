package uni1a;

public abstract class ContenidoAudiovisual implements Mostrable, ExportableCSV {
    private static int contador = 0;

    private String titulo;
    private int duracionEnMinutos;
    private String genero;
    private int id;

    public ContenidoAudiovisual(String titulo, int duracionEnMinutos, String genero) {
        this.id = contador++;
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public String getGenero() {
        return genero;
    }

    public int getId() {
        return id;
    }

    protected void mostrarDatosBase(String tipoContenido) {
        System.out.println("Detalles de " + tipoContenido + ":");
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Duración en minutos: " + duracionEnMinutos);
        System.out.println("Género: " + genero);
    }
}