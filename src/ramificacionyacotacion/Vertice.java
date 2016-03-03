
package ramificacionyacotacion;

public class Vertice {
    private int id;
    private int[] etapas;

    public Vertice(int id, int i , int j) {
        this.id = id;
        this.etapas = new int[]{i,j};
    }

    public Vertice(int id, int[] etapas) {
        this.id = id;
        if(etapas.length != 2){
            throw new IllegalArgumentException("La etapa tendrá tamaño 2: número de etapa y número del vértice de la etapa");
        }
        this.etapas = etapas;
    }

    public int getId() {
        return id;
    }

    public int[] getEtapas() {
        return etapas;
    }
}
    
    


