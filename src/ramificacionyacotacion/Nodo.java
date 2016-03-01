
package ramificacionyacotacion;

import java.util.List;

public class Nodo {
    Vertice vertice;
    List<Nodo> hijos;
    Nodo padre;

    public Nodo(Vertice vertice, Nodo padre) {
        this.vertice = vertice;
        this.padre = padre;
    }

    public void setHijos(List<Nodo> hijos) {
        this.hijos = hijos;
    }

}
