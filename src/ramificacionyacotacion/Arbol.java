
package ramificacionyacotacion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Arbol {
    private List<Nodo> estructura;
    
    public Arbol(Nodo inicio) {
        this.estructura = new LinkedList();
        estructura.add(inicio);
    }
    
    public void insertaNodo(Nodo nodo){
        estructura.add(nodo);
    }
    
    public void printArbol(){
        System.out.println("El árbol tiene los siguientes nodos: ");
        for (int i = 0; i < estructura.size(); i++) {
            Nodo nodo = estructura.get(i);
            System.out.print("Nodo " + nodo.getVertice().getId() + " con etapas: [" + 
                    nodo.getVertice().getEtapas()[0] + "," + nodo.getVertice().getEtapas()[1] + 
                    "] ");
            if(nodo.getPadre() != null){
                System.out.print("y con padre: " + nodo.getPadre().getVertice().getId());
            } else {
                System.out.print("y soy el nodo raíz");
            }
            System.out.println("");
            HashMap<Integer, Float> map = nodo.getPesoHijos();
            Iterator it = map.entrySet().iterator();
            System.out.print("Hijos: [");
            String hijos = new String();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                int nodoHijo = (int) pair.getKey();
                hijos += nodoHijo + " ";
                it.remove();
            }
            hijos = hijos.trim();
            System.out.print(hijos);
            System.out.print("]");
            System.out.println("");
        }
    }
}
