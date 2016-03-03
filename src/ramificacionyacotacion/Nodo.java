
package ramificacionyacotacion;

import java.util.HashMap;
import java.util.List;

public class Nodo implements Comparable<Nodo> {
    private Vertice vertice;
    private HashMap<Integer,Float> pesoHijos;
    private Nodo padre;

    public Nodo(Vertice vertice, Nodo padre) {
        this.vertice = vertice;
        this.padre = padre;
        pesoHijos = new HashMap<Integer,Float>();
    }

    public Vertice getVertice() {
        return vertice;
    }

    public HashMap<Integer, Float> getPesoHijos() {
        return pesoHijos;
    }

    public Nodo getPadre() {
        return padre;
    }

    @Override
    public int compareTo(Nodo nodo) {
        float pesoNodo1 = this.padre.pesoHijos.get(this.vertice.getId());
        float pesoNodo2 = nodo.padre.pesoHijos.get(nodo.vertice.getId());
        if(pesoNodo1 < pesoNodo2){
            return -1;
        } else if (pesoNodo1 > pesoNodo2) {
            return 1;
        } else {
            return 0;
        }
    }
    
    
}
