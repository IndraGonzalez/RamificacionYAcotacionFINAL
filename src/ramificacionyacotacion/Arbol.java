
package ramificacionyacotacion;

import java.util.LinkedList;
import java.util.List;

public class Arbol {
    List<Nodo> estructura;
    
    public Arbol(Nodo inicio) {
        this.estructura = new LinkedList();
        estructura.add(inicio);
    }
    
    public void insertaNodo(Nodo nodo){
        estructura.add(nodo);
    }
}
