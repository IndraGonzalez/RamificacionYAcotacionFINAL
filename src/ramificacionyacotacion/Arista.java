package ramificacionyacotacion;

public class Arista implements Comparable<Arista> {
    private Vertice verticeA;
    private Vertice verticeB;
    private float peso;

    public Arista(Vertice verticeA, Vertice verticeB, float peso) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.peso = peso;
    }

    public Vertice getVerticeA() {
        return verticeA;
    }

    public Vertice getVerticeB() {
        return verticeB;
    }

    
    public float getPeso() {
        return peso;
    }

    @Override
    public int compareTo(Arista a) {
        if(this.peso < a.peso) {
            return -1;
        } 
        if (this.peso > a.peso){
            return 1;
        }
        return 0;
    }
   
}
