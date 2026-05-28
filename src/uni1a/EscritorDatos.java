package uni1a;

import java.util.ArrayList;

public interface EscritorDatos<T> {
    void guardar(ArrayList<T> datos);
}