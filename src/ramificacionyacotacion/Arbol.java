
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
    
    public void printArbol(){
        System.out.println("El árbol tiene los siguientes nodos: ");
        for (int i = 0; i < estructura.size(); i++) {
            Nodo nodo = estructura.get(i);
            System.out.println("Nodo " + nodo.vertice.id + " con estapas: [" + 
                    nodo.vertice.etapas[0] + "," + nodo.vertice.etapas[1] + 
                    "] ");
            /*for (int j = 0; j < nodo.pesoHijos.size(); j++) {
                System.out.println();
                
            }*/
        }
    }
}
