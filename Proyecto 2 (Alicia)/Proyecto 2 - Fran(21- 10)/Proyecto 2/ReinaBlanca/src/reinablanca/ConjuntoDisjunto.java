/*
 * Arleyn Goncalves
 * Francisco Sucre
 * Proyecto 2 De Laboratorio Algoritmos 3
 * Alicia
 * Clase Conjunto disjunto
 */
package reinablanca;

/**
 * Implementacion de conjunto disjunto
 */

import java.util.HashMap;


public class ConjuntoDisjunto {
    
    // STATES

    private HashMap<Nodo,Nodo> padres_; // Lista de padres de los nodos
    
    // CONSTRUCTORS.
    
    public ConjuntoDisjunto()
    
            // Constructor que inicializa la lista de padres
            
    {   
        padres_ = new HashMap<Nodo,Nodo>();
    }
    
    public ConjuntoDisjunto makeSet(Nodo representante)
    
            // Metodo que genera un conjunto a partir de un nodo
    {
        padres_.put(representante, representante); // Asignamos al nodo como su
                                                   // propio padre
        return this;  
    }
    
    public Nodo find(Nodo nodocd)
            
            // Metodo que encuentra el representante del conjunto al cual 
            // pertenece un nodo 
            
    {
        
        Nodo nodoRepresentante = new Nodo("temporal");
        
        if(padres_.get(nodocd) == null) // Comprobamos que estamos recibiendo
                                        // un conjunto inicializado
        { 
            System.out.println("El nodo no es un conjunto disjunto");
        }
        
        if (nodocd.equals(padres_.get(nodocd))) // Si el elemento es su propio
                                                // padre entonces es el 
                                                // representante
        {                   
            nodoRepresentante = nodocd;                   
        }
        
        if (!(nodocd.equals(padres_.get(nodocd)))) // Si no es igual a su padre
                                                   // entonces hacemos una
                                                   // llamada al metodo con su
                                                   // padre
        {            
            nodoRepresentante = this.find(padres_.get(nodocd));            
        }
        
        return nodoRepresentante;

    
    }
    
    public ConjuntoDisjunto Union(Nodo arbol1,Nodo arbol2)
            
            // Metodo que une dos conjuntos
    
    {
    
        if (!((padres_.containsKey(arbol1) &&  // Comprobamos que los grafos 
                padres_.containsKey(arbol2)))) // pertencen al conjunto
            
        {
            System.out.println("Estos grafos no pertenecen ambos al conjunto");
        }
        
        if ((padres_.containsKey(arbol1) && 
                padres_.containsKey(arbol2)))
        {
            padres_.put(arbol2, arbol1); // Asignamos un grafo como padre del
                                         // otro
        }
        
        return this;
        
    }
  
   
    
}

