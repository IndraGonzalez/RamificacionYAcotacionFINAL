
package ramificacionyacotacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RamificacionYAcotacion {
    
    private Grafo grafo;
    private Nodo inicio;
    private Vertice fin;
    private Arbol arbol;
    private List<Nodo> caminoSolucion;
    private float pesoSolucion;
    private float pesoActual;
    
    public RamificacionYAcotacion(Grafo grafo, Vertice inicio, Vertice fin) {
        this.grafo = grafo;
        this.inicio = new Nodo(inicio,null);
        this.fin = fin;
        caminoSolucion = new ArrayList<Nodo>();
        pesoSolucion = -1;
        pesoActual = 0;
        arbol = new Arbol(this.inicio);
    }
    
    public List<Nodo> ramificar (Nodo nodo){
        float[] fila = grafo.getMatrizAdyacente()[nodo.getVertice().getId()-1];
        List<Nodo> hijos = new ArrayList<Nodo>();
        int etapaHijo;
        int etapaPadre = nodo.getVertice().getEtapas()[0];
        Vertice vertice;
        for (int i = 0; i < fila.length; i++) {
            if(fila[i] > 0){
                vertice = grafo.getConjuntoVertices().get(i);     
                etapaHijo = vertice.getEtapas()[0];
                if(etapaHijo > etapaPadre){
                    Nodo nuevoNodo = new Nodo(vertice, nodo);
                    hijos.add(nuevoNodo);
                    nodo.getPesoHijos().put(nuevoNodo.getVertice().getId(),fila[i]);
                    arbol.insertaNodo(nuevoNodo);
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
            if((i+1) < camino.size()){
                siguiente = camino.get(i+1);
                sumaPesos += grafo.getPeso(actual.getVertice(), siguiente.getVertice());
            }
        }
        return sumaPesos;
    }
    
    public void recursivo (Nodo nodo, ArrayList<Nodo> camino){
        if(nodo.getVertice().getId() == fin.getId()){
            caminoSolucion = (List<Nodo>) camino.clone();
            pesoSolucion = calculaPesoCamino(caminoSolucion);
            pesoActual = 0;
            return;
        }
        List<Nodo> hijos = ramificar(nodo);
        if(hijos.size() == 0){
            return;
        }
        ordenar(hijos);
        Iterator<Nodo> iterator = hijos.iterator();
        while(iterator.hasNext()){
            Nodo next = iterator.next();
            List<Nodo> caminoConNodoAcual = (List<Nodo>)camino.clone();
            caminoConNodoAcual.add(next);
            pesoActual = calculaPesoCamino(caminoConNodoAcual);
            if((pesoActual >= pesoSolucion) && (pesoSolucion != -1)){
                return;
            }
            
            camino.add(next);
            recursivo(next,camino);
            camino.remove(next);
            
        }
    }
    
    public List<Nodo> ejecutar(){
        List<Nodo> camino = new ArrayList<Nodo>();
        camino.add(inicio);
        recursivo(inicio, (ArrayList<Nodo>) camino);
        return caminoSolucion;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public Vertice getFin() {
        return fin;
    }

    public Arbol getArbol() {
        return arbol;
    }

    public List<Nodo> getCaminoSolucion() {
        return caminoSolucion;
    }

    public float getPesoSolucion() {
        return pesoSolucion;
    }

    public float getPesoActual() {
        return pesoActual;
    }
    
    
}