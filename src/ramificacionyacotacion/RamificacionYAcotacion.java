
package ramificacionyacotacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RamificacionYAcotacion {
    
    Grafo grafo;
    Nodo inicio;
    Vertice fin;
    Arbol arbol;
    List<Nodo> caminoSolucion;
    float pesoSolucion;
    
    public RamificacionYAcotacion(Grafo grafo, Vertice inicio, Vertice fin) {
        this.grafo = grafo;
        this.inicio = new Nodo(inicio,null);
        this.fin = fin;
        caminoSolucion = new ArrayList<Nodo>();
        pesoSolucion = -1;
        arbol = new Arbol(this.inicio);
    }
    
    public List<Nodo> ramificar (Nodo nodo){
        float[] fila = grafo.getMatrizAdyacente()[nodo.vertice.getId()];
        List<Nodo> hijos = new ArrayList<Nodo>();
        int etapaHijo;
        int etapaPadre = nodo.vertice.getEtapas()[1];
        Vertice vertice;
        for (int i = 0; i < fila.length; i++) {
            if(fila[i] > 0){
                vertice = grafo.getConjuntoVertices().get(i);
                
                etapaHijo = vertice.getEtapas()[1];
                if(etapaHijo > etapaPadre){
                    Nodo nuevoNodo = new Nodo(vertice, nodo);
                    hijos.add(nuevoNodo);
                    nodo.pesoHijos.put(nuevoNodo,fila[i]);
                    arbol.estructura.add(nodo);
                }
            }
        }
        return hijos;
    }
    
    public void ordenar (List<Nodo> hijos){
        Collections.sort(hijos);
    }
    
    public float calculaPesoCamino(List<Nodo> camino){
        float sumaPesos = 0;
        Nodo actual;
        Nodo siguiente;
        for (int i = 0; i < camino.size(); i++) {
            actual = camino.get(i);
            if(i+1 < camino.size()){
                siguiente = camino.get(i+1);
                sumaPesos += grafo.getPeso(actual.vertice, siguiente.vertice);
            }
        }
        return sumaPesos;
    }
    
    public void recursivo (Nodo nodo, ArrayList<Nodo> camino){
        if(nodo.vertice.id == fin.id){
            caminoSolucion = (List<Nodo>) camino.clone();
            pesoSolucion = calculaPesoCamino(caminoSolucion);
            return;
        }
        List<Nodo> hijos = ramificar(nodo);
        ordenar(hijos);
        Iterator<Nodo> iterator = hijos.iterator();
        while(iterator.hasNext()){
            Nodo next = iterator.next();
            float pesoActual = calculaPesoCamino(camino);
            if((pesoActual >= pesoSolucion) && (pesoSolucion != -1)){
                return;
            }
            if(next.pesoHijos.isEmpty()) return;
            camino.add(next);
            recursivo(next,camino);
        }
    }
    
    public List<Nodo> ejecutar(){
        List<Nodo> camino = new ArrayList<Nodo>();
        camino.add(inicio);
        recursivo(inicio, (ArrayList<Nodo>) camino);
        return caminoSolucion;
    }
}