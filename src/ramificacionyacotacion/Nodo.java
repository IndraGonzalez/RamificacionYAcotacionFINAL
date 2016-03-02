
package ramificacionyacotacion;

import java.util.HashMap;
import java.util.List;

public class Nodo implements Comparable<Nodo> {
    Vertice vertice;
    HashMap<Nodo,Float> pesoHijos;
    Nodo padre;

    public Nodo(Vertice vertice, Nodo padre) {
        this.vertice = vertice;
        this.padre = padre;
        pesoHijos = new HashMap<Nodo,Float>();
    }

    @Override
    public int compareTo(Nodo nodo) {
        float pesoNodo1 = this.padre.pesoHijos.get(this);
        float pesoNodo2 = nodo.padre.pesoHijos.get(nodo);
        if(pesoNodo1 < pesoNodo2){
            return -1;
        } else if (pesoNodo1 > pesoNodo2) {
            return 1;
        } else {
            return 0;
        }
    }
    
    
}
