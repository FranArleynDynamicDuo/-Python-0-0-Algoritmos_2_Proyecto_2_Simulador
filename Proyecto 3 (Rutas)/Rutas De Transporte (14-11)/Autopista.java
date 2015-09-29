/*
 * Arleyn Goncalves
 * Francisco Sucre
 * Proyecto 2 De Laboratorio Algoritmos 3
 * Alicia
 * Clase Autopista
 */
package rutastransporte;
import java.util.ArrayList;

/**
 * Implementacion de las aristas
 */
    public class Autopista
    
    {
        // STATES
        
        private Integer costo_; // Costo de cada arista
        private ArrayList<Ciudad> incidentes_; // Ciudads incidentes a la arista
        
        // CONSTRUCTORS
        
        public Autopista(Integer costo,Ciudad origen,Ciudad destino)
                
        {
            costo_ = costo;
            incidentes_.add(origen);
            incidentes_.add(destino);
        }
        
        public Autopista(Integer costo, ArrayList<Ciudad> ciudades)
                
                // Constructor de la clase arista que recibe el costo y el 
                // conjunto de los ciudads incidentes
                
        {  
            costo_ = costo;
            
            if (ciudades.size() != 2) // Comprobamos que tiene 2 incidentes   
            {
                System.out.println("ERROR: Una arista solo puede ser incidente "
                        + "a 2 ciudads");            
            }

            if (ciudades.size() == 2) 
            {            
                incidentes_ = ciudades;
            }                
        }
        
        // GETTERS
        
        public ArrayList<Ciudad> obtenerIncidentes()
                
                // Metodo que obtiene el conjunto de los ciudads incidentes a la
                // arista
        
        {
            return incidentes_; 
        }
        
        public Integer obtenerCosto()
                
                // Metodo que obtiene el costo de una arista
        
        {
            return costo_;   
        }
        
        public Ciudad obtenerOrigen()
                
                // Metodo que obtiene el costo de una arista
        
        {
            return incidentes_.get(0);   
        } 
        
        public Ciudad obtenerDestino()
                
                // Metodo que obtiene el costo de una arista
        
        {
            return incidentes_.get(1);   
        }        

        public Autopista modificarDistancia(Integer distanciaNueva)
                
                // Metodo que obtiene el conjunto de los ciudads incidentes a la
                // arista
        
        {
            costo_ = distanciaNueva;
            return this; 
        }        
    } 