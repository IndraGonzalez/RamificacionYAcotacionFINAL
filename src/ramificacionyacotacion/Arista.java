package ramificacionyacotacion;




public class Arista implements Comparable<Arista> {
    private int nodoA;
    private int nodoB;
    private float peso;

    public Arista(int nodoA, int nodoB, float peso) {
        this.nodoA = nodoA;
        this.nodoB = nodoB;
        this.peso = peso;
    }

    public int getNodoA() {
        return nodoA;
    }

    public int getNodoB() {
        return nodoB;
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
