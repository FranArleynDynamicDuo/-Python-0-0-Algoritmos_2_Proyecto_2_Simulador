/*
 *Arleyn Goncalves
 *Francisco Sucre
 * Proyecto 2 De Laboratorio Algoritmos 3
 * Alicia
 * Clase ReinaBlanca
 */

package reinablanca;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class ReinaBlanca 

{


    Grafo prueba = new Grafo();
    

 
    
    public static void main(String[] args) throws IOException 
    
    
    {

        Grafo prueba = new Grafo();
        System.out.println("Se esta usando el archivo '" + args[0] + "'");
        System.out.println();
        System.out.println("Procediendo a leer el grafo");
        System.out.println();
        prueba = prueba.leerArbol(args[0]);
        System.out.println("Imprimiendo Grafo prueba");
        prueba.imprimir();
        
        int costos = prueba.minimizarMonedas();
        System.out.println("El costo minimo es " + costos);
        
        
    }
    
}

