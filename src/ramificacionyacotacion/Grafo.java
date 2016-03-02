package ramificacionyacotacion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grafo {
    private float[][] matrizAdyacente;
    private List<Arista> conjuntoAristas;
    private List<Vertice> conjuntoVertices;
 
    public Grafo(int numeroVertices) {
        if(numeroVertices > 1) {
            matrizAdyacente = new float[numeroVertices][numeroVertices];
            conjuntoAristas = new LinkedList<Arista>();
            conjuntoVertices = new ArrayList(numeroVertices);
        } else {
            throw new IllegalArgumentException("El número de vértices debe ser mayor que cero.");
        }
    }
    
    public void insertaArista(Arista arista){
        for(int i = 0; i < conjuntoVertices.size(); i++) {
            //if((conjuntoVertices.get(i).getId() == arista.getVerticeA().getId())
            //        || (conjuntoVertices.get(i).getId() == arista.getVerticeB().getId())){
            if((arista.getVerticeA().getId() > matrizAdyacente.length) || (arista.getVerticeB().getId() > matrizAdyacente.length)){
                System.out.println("Los vértices que intenta conectar no pertecen al grafo.");
                return;
            }
        }
            
        if(arista.getVerticeA().getId() == arista.getVerticeB().getId()){
            System.out.println("No se puede conectar un vértice con si mismo. ");
            return;
        }
        
        if ((matrizAdyacente[arista.getVerticeA().getId()-1][arista.getVerticeB().getId()-1] == 0) && (matrizAdyacente[arista.getVerticeB().getId()-1][arista.getVerticeA().getId()-1] == 0)){
            matrizAdyacente[arista.getVerticeA().getId()-1][arista.getVerticeB().getId()-1]= arista.getPeso();
            matrizAdyacente[arista.getVerticeB().getId()-1][arista.getVerticeA().getId()-1]= arista.getPeso();
            conjuntoAristas.add(arista);
        } else {
            System.out.println("ERROR : No se ha insertado la arista.");
            System.out.println("Ya existe una arista entre los vértices " + arista.getVerticeA()
                + " y " + arista.getVerticeB() + " con peso " + arista.getPeso());
        }
    }
    
    public void insertaVertice(Vertice vertice){
        if(vertice.etapas[1] > matrizAdyacente.length){
            throw new IllegalArgumentException("El número de etapas debe ser menor que el número de vertices.");
        }
        if((vertice.getId() < 1) || (vertice.getId() > matrizAdyacente.length)){
            throw new IllegalArgumentException("El número del vertice no pertece al rango del grafo.");
        }
        for (int i = 0; i < conjuntoVertices.size(); i++) {
            if(conjuntoVertices.get(i).getId() == vertice.getId()){
                throw new IllegalArgumentException("Este vértice ya pertenece al grafo.");
            }
        }
        conjuntoVertices.add(vertice);
        
    }
    
    public float getPeso(Vertice verticeA, Vertice verticeB){
        return matrizAdyacente[verticeA.getId()-1][verticeB.getId()-1];
    }

    public int getNumeroAristas() {
        return conjuntoAristas.size();
    }

    public List<Arista> getConjuntoAristas() {
        return conjuntoAristas;
    }

    public List<Vertice> getConjuntoVertices() {
        return conjuntoVertices;
    }
    
    public float[][] getMatrizAdyacente() {
        return matrizAdyacente;
    }
    
    public int getNumeroNodos (){
        return matrizAdyacente.length;
    }
    
    public void printMatriz(){
        for (int i = 0; i < matrizAdyacente.length; i++) {
            for (int j = 0; j < matrizAdyacente[1].length; j++) {
                System.out.print(matrizAdyacente[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
