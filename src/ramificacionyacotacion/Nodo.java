
package ramificacionyacotacion;

import java.util.HashMap;
import java.util.List;

public class Nodo {
    Vertice vertice;
    HashMap<Nodo,Float> pesoHijos;
    Nodo padre;

    public Nodo(Vertice vertice, Nodo padre) {
        this.vertice = vertice;
        this.padre = padre;
    }
}
