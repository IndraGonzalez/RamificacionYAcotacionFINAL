
package ramificacionyacotacion;

import java.util.List;

public class Main {

    
    public static void main(String[] args) {
         
        System.out.println("-------Inicio de pruebas-------");
        System.out.println("");
        System.out.println("---------------------------------------------");
        System.out.println("-1er CASO- \nHay dos soluciones del mismo peso. \nCogerá la primera. ");
        System.out.println("---------------------------------------------");
        
        Grafo grafo1 = new Grafo(8);
        
        Vertice vertice01 = new Vertice(1, new int[]{0,1});
        Vertice vertice11 = new Vertice(2, new int[]{1,1});
        Vertice vertice12 = new Vertice(3, new int[]{1,2});
        Vertice vertice13 = new Vertice(4, new int[]{1,3});
        Vertice vertice21 = new Vertice(5, new int[]{2,1});
        Vertice vertice22 = new Vertice(6, new int[]{2,2});
        Vertice vertice23 = new Vertice(7, new int[]{2,3});
        Vertice vertice31 = new Vertice(8, new int[]{3,1});
        
        grafo1.insertaVertice(vertice01);
        grafo1.insertaVertice(vertice11);
        grafo1.insertaVertice(vertice12);
        grafo1.insertaVertice(vertice13);
        grafo1.insertaVertice(vertice21);
        grafo1.insertaVertice(vertice22);
        grafo1.insertaVertice(vertice23);
        grafo1.insertaVertice(vertice31);
        
        grafo1.insertaArista(new Arista(vertice01, vertice11, 1));
        grafo1.insertaArista(new Arista(vertice01, vertice12, 3));
        grafo1.insertaArista(new Arista(vertice01, vertice13, 2));
        grafo1.insertaArista(new Arista(vertice11, vertice21, 5));
        grafo1.insertaArista(new Arista(vertice11, vertice23, 3));
        grafo1.insertaArista(new Arista(vertice12, vertice21, 4));
        grafo1.insertaArista(new Arista(vertice12, vertice22, 3));
        grafo1.insertaArista(new Arista(vertice13, vertice22, 2));
        grafo1.insertaArista(new Arista(vertice13, vertice23, 7));
        grafo1.insertaArista(new Arista(vertice21, vertice31, 4));
        grafo1.insertaArista(new Arista(vertice22, vertice31, 1));
        grafo1.insertaArista(new Arista(vertice23, vertice31, 1));
        
        System.out.println("");
        System.out.println("Matriz Adyacente del grafo");
        System.out.println("");
        grafo1.printMatriz();
        System.out.println("");
        
        RamificacionYAcotacion algoritmo = new RamificacionYAcotacion(grafo1, vertice01, vertice31);
        
        List<Nodo> solucion = algoritmo.ejecutar();
        System.out.println("");
        printSolucion(solucion,algoritmo);
        System.out.println("");
        
        System.out.println("---------------------------------------------");
        System.out.println("-2º CASO- \nHay dos soluciones: primero encuentra la de mayor peso"
                + "\ny, después, encuentra la solución óptima, de menor peso.");
        System.out.println("---------------------------------------------");
        
        Grafo grafo2 = new Grafo(8);
        
        grafo2.insertaVertice(vertice01);
        grafo2.insertaVertice(vertice11);
        grafo2.insertaVertice(vertice12);
        grafo2.insertaVertice(vertice13);
        grafo2.insertaVertice(vertice21);
        grafo2.insertaVertice(vertice22);
        grafo2.insertaVertice(vertice23);
        grafo2.insertaVertice(vertice31);
        
        grafo2.insertaArista(new Arista(vertice01, vertice11, 1));
        grafo2.insertaArista(new Arista(vertice01, vertice12, 3));
        grafo2.insertaArista(new Arista(vertice01, vertice13, 2));
        grafo2.insertaArista(new Arista(vertice11, vertice21, 5));
        grafo2.insertaArista(new Arista(vertice11, vertice23, 3));
        grafo2.insertaArista(new Arista(vertice12, vertice21, 4));
        grafo2.insertaArista(new Arista(vertice12, vertice22, 3));
        grafo2.insertaArista(new Arista(vertice13, vertice22, 1));
        grafo2.insertaArista(new Arista(vertice13, vertice23, 7));
        grafo2.insertaArista(new Arista(vertice21, vertice31, 4));
        grafo2.insertaArista(new Arista(vertice22, vertice31, 1));
        grafo2.insertaArista(new Arista(vertice23, vertice31, 1));
        
        System.out.println("");
        System.out.println("Matriz Adyacente del grafo");
        System.out.println("");
        grafo2.printMatriz();
        System.out.println("");
        
        RamificacionYAcotacion algoritmo2 = new RamificacionYAcotacion(grafo2, vertice01, vertice31);
        
        List<Nodo> solucion2 = algoritmo2.ejecutar();
        System.out.println("");
        printSolucion(solucion2,algoritmo2);
        System.out.println("");
        
        System.out.println("---------------------------------------------");
        System.out.println("-3er CASO- \nNo hay solución. \nEl vértice solución está asilado.");
        System.out.println("---------------------------------------------");
        
        
        Grafo grafo3 = new Grafo(8);
        
        grafo3.insertaVertice(vertice01);
        grafo3.insertaVertice(vertice11);
        grafo3.insertaVertice(vertice12);
        grafo3.insertaVertice(vertice13);
        grafo3.insertaVertice(vertice21);
        grafo3.insertaVertice(vertice22);
        grafo3.insertaVertice(vertice23);
        grafo3.insertaVertice(vertice31);
        
        grafo3.insertaArista(new Arista(vertice01, vertice11, 1));
        grafo3.insertaArista(new Arista(vertice01, vertice12, 3));
        grafo3.insertaArista(new Arista(vertice01, vertice13, 2));
        grafo3.insertaArista(new Arista(vertice11, vertice21, 5));
        grafo3.insertaArista(new Arista(vertice11, vertice23, 3));
        grafo3.insertaArista(new Arista(vertice12, vertice21, 4));
        grafo3.insertaArista(new Arista(vertice12, vertice22, 3));
        grafo3.insertaArista(new Arista(vertice13, vertice22, 1));
        grafo3.insertaArista(new Arista(vertice13, vertice23, 7));
        
        System.out.println("");
        System.out.println("Matriz Adyacente del grafo");
        System.out.println("");
        grafo3.printMatriz();
        System.out.println("");
        
        RamificacionYAcotacion algoritmo3 = new RamificacionYAcotacion(grafo3, vertice01, vertice31);
        
        List<Nodo> solucion3 = algoritmo3.ejecutar();
        System.out.println("");
        printSolucion(solucion3,algoritmo3);
        System.out.println("");
        
        
        /**
         * Pruebas de las etapas del grafo.
         * Comprobación de que la modificación que incluye etapas y vértices 
         * en el grafo es correcta.
         * Al quitar los comentarios de las pruebas, se ven las excepciones.
         
        
        Grafo grafo1 = new Grafo(2);
        Vertice vertice1 = new Vertice(1, new int[]{16,1});
        Vertice vertice2 = new Vertice(2, new int[]{4,6});
        grafo1.insertaVertice(vertice1);
        grafo1.insertaVertice(vertice2);
        grafo1.insertaArista(new Arista(vertice1, vertice2, 2));
        
        Vertice vertice3 = new Vertice(2, new int[]{0,1,3,4,5});
        
        */
               
    }

    private static void printSolucion(List<Nodo> solucion, RamificacionYAcotacion algoritmo) {
        System.out.print("Solucion: ");
        if(solucion.isEmpty()){
            System.out.println("NO HAY SOLUCIÓN");
        } else {
            for (int i = 0; i < solucion.size(); i++) {
                if(i == solucion.size()-1){
                   System.out.print(solucion.get(i).getVertice().getId()); 
                } else {
                   System.out.print(solucion.get(i).getVertice().getId() + " --> ");
                }
            }
        }
        
        System.out.println("");
        System.out.println("");
        algoritmo.getArbol().printArbol();  
        System.out.println("");
    }
    
}
