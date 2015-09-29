/*
 * Arleyn Goncalves
 * Francisco Sucre
 * Proyecto 2 De Laboratorio Algoritmos 3
 * Alicia
 * Clase Arista
 */
package reinablanca;

/**
 * Implementacion de las aristas
 */

import java.util.HashMap;


public class ConjuntoDisjunto {
    
    // STATES

    private HashMap<Nodo,Nodo> padres_; 
    
    // CONSTRUCTORS.
    
    public ConjuntoDisjunto()
    {
        
        padres_ = new HashMap<Nodo,Nodo>();
    }
    
    public ConjuntoDisjunto makeSet(Nodo representante)
            
    {
    
        padres_.put(representante, representante);
        return this;
        
    }
    
    public Nodo find(Nodo nodocd)
            
    {
        
        Nodo nodoRepresentante = new Nodo("temporal");
        
        if(padres_.get(nodocd).equals(null))
        {
        
            System.out.println("El nodo no es un conjunto disjunto");
        
        }
        
        if (nodocd.equals(padres_.get(nodocd)))
                
        {
                    
            nodoRepresentante = nodocd;
                    
        }
        
        if (!(nodocd.equals(padres_.get(nodocd))))
        
        {
            
            nodoRepresentante = this.find(padres_.get(nodocd));
            
        }
        
        return nodoRepresentante;

    
    }
    
    public ConjuntoDisjunto Union(Nodo arbol1,Nodo arbol2)
    
    {
    
        if (!((padres_.containsKey(arbol1) && 
                padres_.containsKey(arbol2))))
            
        {
            System.out.println("Estos arboles no pertenecen ambos al conjunto");
        }
        
        if ((padres_.containsKey(arbol1) && 
                padres_.containsKey(arbol2)))
        {
            padres_.put(arbol2, arbol1);
        }
        
        return this;
        
    }
  
   
    
}
