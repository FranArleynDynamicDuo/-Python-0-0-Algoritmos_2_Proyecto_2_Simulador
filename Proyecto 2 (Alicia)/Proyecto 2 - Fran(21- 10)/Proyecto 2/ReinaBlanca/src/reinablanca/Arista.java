/*
 * Arleyn Goncalves
 * Francisco Sucre
 * Proyecto 2 De Laboratorio Algoritmos 3
 * Alicia
 * Clase Arista
 */
package reinablanca;
import java.util.HashSet;

/**
 * Implementacion de las aristas
 */
    public class Arista
    
    {
        // STATES
        
        private final Integer costo_; // Costo de cada arista
        private HashSet<Nodo> incidentes_; // Nodos incidentes a la arista
        
        public Arista(Integer costo)
                
                // Constructor de la clase arista que recibe solo el costo
                
        {
            costo_ = costo;
        }
        
        public Arista(Integer costo, HashSet<Nodo> nodos)
                
                // Constructor de la clase arista que recibe el costo y el 
                // conjunto de los nodos incidentes
                
        {  
            costo_ = costo;
            
            if (nodos.size() != 2) // Comprobamos que tiene 2 incidentes
                
            {
                System.out.println("ERROR: Una arista solo puede ser incidente "
                        + "a 2 nodos");            
            }

            if (nodos.size() == 2)
                
            {            
                incidentes_ = nodos;
            }                
        }
        
        public HashSet<Nodo> obtenerIncidentes()
                
                // Metodo que obtiene el conjunto de los nodos incidentes a la
                // arista
        
        {
            return incidentes_; 
        }
        
        public Integer obtenerCosto()
                
                // Metodo que obtiene el costo de una arista
        
        {
            return costo_;   
        }
        
    }   
