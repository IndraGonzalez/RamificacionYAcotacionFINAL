
package ramificacionyacotacion;

public class Main {

    
    public static void main(String[] args) {
         
        System.out.println("-------Inicio de pruebas-------");
        System.out.println("");
        System.out.println("-1er CASO- Solución única y directa");
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
        grafo1.printMatriz();
        
        RamificacionYAcotacion algoritmo = new RamificacionYAcotacion(grafo1, vertice01, vertice31);
        algoritmo.ejecutar();
        algoritmo.arbol.printArbol();
        
        
        
        /*System.out.println("");
        List<Arista> conjuntoAristas1 = grafo1.getConjuntoAristas();
        System.out.println("Conjunto de aristas del grafo");
        printConjuntoAristas(conjuntoAristas1);
        
        System.out.println("");
        System.out.println("La suma de pesos del arbol mínimo de entrada es: " + 138.9);
        System.out.println("");
        
        System.out.println("N = " + matrizAdyacente1.length);
        System.out.println("");
        
        System.out.print("Comprobación grafo entrada : ");
        comprobacionConexo(grafo1);
        System.out.println("");
        
        Kruskal kruskal1 = new Kruskal(grafo1);
        List<Arista> solucion1 = kruskal1.ejecutar();
        printSolucion(solucion1);
        
        Grafo grafoSolucion1 = creacionGrafoSolucion(solucion1);
        System.out.println("");
        
        System.out.println("La suma de pesos del arbol mínimo de salida es: " + comprobacionPesos(solucion1));
        System.out.println("");
        
        System.out.println("El número de aristas es " + solucion1.size() + " que es igual a N - 1 (" + (matrizAdyacente1.length-1) + ")");
        System.out.println("");
        
        
        System.out.print("Comprobación grafo salida : ");
        comprobacionConexo(grafoSolucion1);
        System.out.println("");
        
        System.out.println("---------------------------------------------");
        
    
        
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
    
}
