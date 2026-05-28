package uni1a;

public class Actor implements Mostrable, ExportableCSV {
    private String nombre;
    private int edad;
    private String nacionalidad;

    public Actor(String nombre, int edad, String nacionalidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Actor:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Nacionalidad: " + nacionalidad);
        System.out.println();
    }

    @Override
    public String convertirACSV() {
        return nombre + "," + edad + "," + nacionalidad;
    }
}