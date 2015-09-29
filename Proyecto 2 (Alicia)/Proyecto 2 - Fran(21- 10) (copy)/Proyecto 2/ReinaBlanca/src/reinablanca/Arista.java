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
        
        private final Integer costo_;
        private HashSet<Nodo> incidentes_;
        
        public Arista(Integer costo)
                
        {
            costo_ = costo;
        }
        
        public Arista(Integer costo, HashSet<Nodo> nodos)
                
        {  
            costo_ = costo;
            
            if (nodos.size() != 2)
                
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
        
        {
            return incidentes_; 
        }
        
        public Integer obtenerCosto()
        
        {
            return costo_;   
        }
        
    }   