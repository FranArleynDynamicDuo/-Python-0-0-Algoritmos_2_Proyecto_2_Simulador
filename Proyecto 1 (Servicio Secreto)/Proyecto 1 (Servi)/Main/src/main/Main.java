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
        
        //Probando constructor de Grafo sin argumentos
        
        Grafo agentesUSB = new Grafo();
        
        //Probando constructor Nodo con 1 argumento
        
        System.out.println();
        System.out.println("Probando constructor Nodo con 1 argumento");
        System.out.println();  
        
        Nodo sucre = new Nodo("Agente Sucre");
        sucre.imprimir();
        Nodo goncalves = new Nodo("Agente Goncalves");

        //Probando constructor Nodo Con 2 Argumentos
        
        Nodo lopez = new Nodo("Agente Lopez", 
                new Nodo[] {sucre, goncalves} ); //Creamos una Lista de nodos
                                                 //con new
        
        //Probando el metodo agregarAdyacente de los nodos
        
        System.out.println();
        System.out.println("Probando el metodo agregarAdyacente de los nodos y "
                + "los constructores");
        System.out.println();              
        
        sucre.agregarAdyacente(lopez);
        sucre.agregarAdyacente(goncalves);
        sucre.agregarAdyacente(sucre);
        sucre.imprimir();
        goncalves.imprimir();
        lopez.imprimir();
        lopez.agregarAdyacente(lopez);
        
        //Proabando el metodo removerVarios de Nodo      
        
        sucre.removerVarios(new Nodo[] {goncalves} );
        lopez.remover(goncalves);
        
        //Probando el metodo agregarVariosAdyacentes de Nodo
        
        System.out.println();
        System.out.println("Probando el metodo agregarVariosAdyacentes y "
                + "removerVarios de Nodo");
        System.out.println();        
        
        goncalves.agregarVariosAdyacentes(new Nodo[] {goncalves} );
        goncalves.imprimir();
        lopez.imprimir();
        sucre.imprimir();
        
        //Probando el metodo agregarNodo de Grafo
        
        System.out.println();
        System.out.println("Probando el metodo agregarNodo de Grafo");
        System.out.println();  
        
        agentesUSB.agregarNodo(lopez);
        agentesUSB.agregarNodo(sucre);
        agentesUSB.agregarNodo(goncalves);
        agentesUSB.imprimir();
        
        //Probando el metodo obtenerAdyacentes de Nodo
        
        System.out.println();
        System.out.println("Probando el metodo obtenerAdyacentes de Nodo");
        System.out.println();  
        
        lopez.obtenerAdyacentes();
        System.out.println("Los conocidos de lopez son: ");
        
        for (Nodo conocidos : lopez.obtenerAdyacentes())
        
        {
        
            conocidos.imprimir();
        
        }
        
        //Probando el metodo obtenerNombre de Nodo
        
        System.out.println();
        System.out.println("Probando el metodo obtenerNombre de Nodo");
        System.out.println();           
        
        System.out.println(sucre.obtenerNombre());
        System.out.println();
        
        //Probando el metodo obtenerNodos de Grafo
        
        System.out.println();
        System.out.println("Probando el metodo obtenerNodos de Grafo");
        System.out.println();       
        
        for (Nodo conocidos : agentesUSB.obtenerNodos())
        
        {
        
            conocidos.imprimir();
        
        }
        
    }
    
}
