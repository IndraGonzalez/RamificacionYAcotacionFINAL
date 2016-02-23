package ramificacionyacotacion;

import java.util.LinkedList;
import java.util.List;

public class Grafo {
    private float[][] matrizAdyacente;
    private List<Arista> conjuntoAristas;
 
    public Grafo(int numeroNodos) {
        if(numeroNodos > 1) {
            matrizAdyacente = new float[numeroNodos][numeroNodos];
            conjuntoAristas = new LinkedList<Arista>();
        } else {
            throw new IllegalArgumentException("El número de nodos debe ser mayor que cero.");
        }
    }
    
    public void insertaArista(Arista arista){
        if((arista.getNodoA() > matrizAdyacente.length) || (arista.getNodoB() > matrizAdyacente.length)){
            System.out.println("Los nodos que intenta conectar no pertecen al grafo.");
            return;
        } 
        if(arista.getNodoA() == arista.getNodoB()){
            System.out.println("No se puede conectar un nodo con si mismo. ");
            return;
        }
        
        if ((matrizAdyacente[arista.getNodoA()-1][arista.getNodoB()-1] == 0) && (matrizAdyacente[arista.getNodoB()-1][arista.getNodoA()-1] == 0)){
            matrizAdyacente[arista.getNodoA()-1][arista.getNodoB()-1]= arista.getPeso();
            matrizAdyacente[arista.getNodoB()-1][arista.getNodoA()-1]= arista.getPeso();
            conjuntoAristas.add(arista);
        } else {
            System.out.println("ERROR : No se ha insertado la arista.");
            System.out.println("Ya existe una arista entre los nodos " + arista.getNodoA()
                + " y " + arista.getNodoB() + " con peso " + arista.getPeso());
        }
    }
    
    public float obtenerPeso(int nodoA, int nodoB){
        return matrizAdyacente[nodoA-1][nodoB-1];
    }

    public int getNumeroAristas() {
        return conjuntoAristas.size();
    }

    public List<Arista> getConjuntoAristas() {
        return conjuntoAristas;
    }
    
    public float[][] getMatrizAdyacente() {
        return matrizAdyacente;
    }
    
    public int getNumeroNodos (){
        return matrizAdyacente.length;
    }
}
