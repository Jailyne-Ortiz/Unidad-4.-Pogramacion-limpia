package uni1a;

public class Investigador implements Mostrable, ExportableCSV {
    private String nombre;
    private String especialidad;

    public Investigador(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Investigador:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Especialidad: " + especialidad);
        System.out.println();
    }

    @Override
    public String convertirACSV() {
        return nombre + "," + especialidad;
    }
}