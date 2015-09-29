/*
 * Arleyn Goncalves
 * Francisco Sucre
 * Proyecto 1 De Laboratorio Algoritmos 3
 * Servicio Secreto
 * Clase Main(Prueba)
 */
package main;

import java.util.HashSet;

public class Main 

{

    public static void main(String[] args) 
    
    {
        
        Grafo agentesUSB = new Grafo();
        Nodo sucre = new Nodo("Agente Sucre");
        sucre.imprimirNodo();
        Nodo goncalves = new Nodo("Agente Goncalves");
        Nodo elements[] = {sucre, goncalves}; // Al parecer debes crear la
                                              // Antes de usarla como argumento
        Nodo lopez = new Nodo("Agente Lopez", 
                new Nodo[] {sucre, goncalves} ); //O Creamos una lista de nodos
                                                 //con new
        sucre.add(lopez);
        sucre.add(goncalves);
        sucre.add(sucre);
        sucre.imprimirNodo();
        goncalves.imprimirNodo();
        lopez.imprimirNodo();
        lopez.add(lopez);
        sucre.removeMany(new Nodo[] {goncalves} );
        lopez.remove(goncalves);
        goncalves.addMany(new Nodo[] {goncalves} );
        goncalves.imprimirNodo();
        lopez.imprimirNodo();
        sucre.imprimirNodo();
        
        
    }
    
}
