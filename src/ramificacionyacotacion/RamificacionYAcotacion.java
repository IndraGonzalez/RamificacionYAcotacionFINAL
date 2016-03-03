
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
    float pesoActual;
    
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
        float[] fila = grafo.getMatrizAdyacente()[nodo.vertice.getId()-1];
        List<Nodo> hijos = new ArrayList<Nodo>();
        int etapaHijo;
        int etapaPadre = nodo.vertice.getEtapas()[0];
        System.out.println("Entra a ramificar: " + nodo.vertice.id);
        Vertice vertice;
        for (int i = 0; i < fila.length; i++) {
            if(fila[i] > 0){
                vertice = grafo.getConjuntoVertices().get(i);     
                System.out.println("Va a añadir el hijo: " + vertice.id);
                etapaHijo = vertice.getEtapas()[0];
                if(etapaHijo > etapaPadre){
                    Nodo nuevoNodo = new Nodo(vertice, nodo);
                    System.out.println("Añade el hijo: " + vertice.id);
                    hijos.add(nuevoNodo);
                    nodo.pesoHijos.put(nuevoNodo.vertice.id,fila[i]);
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
                sumaPesos += grafo.getPeso(actual.vertice, siguiente.vertice);
            }
        }
        return sumaPesos;
    }
    
    public void recursivo (Nodo nodo, ArrayList<Nodo> camino){
        if(nodo.vertice.id == fin.id){
            caminoSolucion = (List<Nodo>) camino.clone();
            pesoSolucion = calculaPesoCamino(caminoSolucion);
            pesoActual = 0;
            System.out.println("** Peso solución = " + pesoSolucion);
            return;
        }
        List<Nodo> hijos = ramificar(nodo);
        System.out.println("Tamaño de los hijos del nodo " + nodo.vertice.id + " es: " + hijos.size());
        if(hijos.size() == 0){
            System.out.println("Entró a ramificar " + nodo.vertice.id + " y estaba vacío");
            return;
        }
        ordenar(hijos);
        Iterator<Nodo> iterator = hijos.iterator();
        while(iterator.hasNext()){
            Nodo next = iterator.next();
            List<Nodo> caminoConNodoAcual = (List<Nodo>)camino.clone();
            caminoConNodoAcual.add(next);
            pesoActual = calculaPesoCamino(caminoConNodoAcual);
            System.out.println("* Peso actual en el nodo " + next.vertice.id + " = " + pesoActual);
            System.out.println("Camino: ");
            for (int i = 0; i < camino.size(); i++) {
                System.out.println(camino.get(i).vertice.id);
            }
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
}