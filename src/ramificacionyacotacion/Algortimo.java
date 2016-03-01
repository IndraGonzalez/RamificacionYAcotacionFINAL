
package ramificacionyacotacion;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Algortimo {
    
    Grafo grafo;
    Nodo inicio;
    Vertice fin;
    Arbol arbol;
    Stack caminoActual;
    Stack caminoSolucion;
    int pesoSolucion;
    int pesoActual;
    
    public Algortimo(Grafo grafo, Vertice inicio, Vertice fin) {
        this.grafo = grafo;
        this.inicio = new Nodo(inicio,null);
        this.fin = fin;
        caminoActual.add(inicio);
    }
    
    public void ramificar (Nodo nodo){
        float[] fila = grafo.getMatrizAdyacente()[nodo.vertice.getId()];
        int etapaHijo;
        int etapaPadre = nodo.vertice.getEtapas()[1];
        Vertice vertice;
        for (int i = 0; i < fila.length; i++) {
            if(fila[i] > 0){
                vertice = grafo.getConjuntoVertices().get(i);
                etapaHijo = vertice.getEtapas()[1];
                if(etapaHijo > etapaPadre){
                    nodo.hijos.add(new Nodo(vertice, nodo));
                }
            }
        }
    }
    
    public Nodo getMenor (List<Nodo> hijos){
        Nodo padre = hijos.get(0).padre;
        Nodo hijoMenor = hijos.get(0);
        float pesoMenor= grafo.getPeso(padre.vertice, hijoMenor.vertice);
        for (int i = 1; i < hijos.size(); i++) {
            Nodo nodoActual = hijos.get(i);
            float pesoActual = grafo.getPeso(padre.vertice, nodoActual.vertice);
            if(pesoActual < pesoMenor){
                pesoMenor = pesoActual;
                hijoMenor = nodoActual;
            }
        }
        pesoActual += pesoMenor;
        return hijoMenor;
    }
}
