package rutastransporte;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementacion de la clase Ciudad para ReinaRoja
 * @author Francisco Sucre & Arleyn Goncalves
 */
    public class Ciudad

    {  
        // STATES
        
        private String nombre_; // Nombre del ciudad
        private HashSet<Ciudad> adyacentes_; // El conjunto de los ciudads 
                                             // adyacentes a cada ciudad
        private HashSet<Autopista> autopistas_; // El conjunto de las aristas a las
                                            // cuales el ciudad es incidente
        private Integer distancia_; // Distancia de todos los  
                                                  // ciudads aeste
        private Ciudad predecesor_; // El predecesor del ciudad   
        private Integer ganancia_;
        
        // CONSTRUCTORS
        
        public Ciudad(String nombre, Integer costo)
                
                // Constructor de Ciudad que recibe el nombre del ciudad
                
        {        
            nombre_ = nombre;
            adyacentes_ = new HashSet<Ciudad>();
            autopistas_ = new HashSet<Autopista>();
            ganancia_ = costo;
            distancia_ = 0;
            predecesor_ = null;
        }        
        
        public Ciudad(String nombre, HashSet<Ciudad> adyacentes)

                // Constructor de Ciudad que recibe el nombre del ciudad y un
                // conjunto de ciudads
                
        {        
            nombre_ = nombre;
            adyacentes_ = adyacentes;  
            autopistas_ = new HashSet<Autopista>();
            distancia_ = 0;
            predecesor_ = null;
        }
        
        public Ciudad(String nombre, HashSet<Ciudad> adyacentes,
                HashSet<Autopista> arista)

                // Constructor de Ciudad que recibe el nombre del ciudad, un      
                // conjunto de ciudads y un conjunto de aristas              
                
        {        
            nombre_ = nombre;
            adyacentes_ = adyacentes;
            autopistas_ = arista;   
            distancia_ = 0;
            predecesor_ = null;
        }        

	// GETTERS.

	public String obtenerNombre()
                
        // Metodo para obtener el nombre de un ciudad y guardarlo en una variable

        {
            return nombre_; // Hacemos return solo con el nombre del ciudad
        }
        
        public HashSet<Autopista> obtenerAutopistas()
                
        // Metodo para obtener la lista de aristas asociadas al ciudad
        
        {        
            return autopistas_;
        }
        
        public HashSet<Ciudad> obtenerAdyacentes()
                
            // Metodo para obtener el conjunto de adyacencia de un ciudad                
                
        {
            return adyacentes_; // Hacemos return solo con el conjunto           
        }

        public Integer obtenerDistancia()
                
            // Metodo que devuelve la distancia de una ciudad para la
            // implementacion del BellmanFord
                
        {
            return distancia_;
        }
        
        public Integer obtenerGanancia()
                
            // Metodo que devuelve la ganancia de una ciudad
                
        {
            return ganancia_;
        }
        
        public Ciudad obtenerPredecesor()
                
            // Metodo que obtiene el predecesor de una ciudad    
                
        {
            return predecesor_;
        }
        
        // SETTERS
        
	public Ciudad agregarAdyacente(Ciudad ciudadNuevo)
                
            // Metodo para agregarAdyacente un ciudad a la lista de adyacencia
            // de un ciudad
                
        {
            adyacentes_.add(ciudadNuevo); // Añadimos el nuevo ciudad al conjunto
                                        // de adyacencia
            
            return this; // Y hacemos return con el conjunto modificado                      
        } 
        

        public Ciudad agregarAutopista(Autopista arista)
                
            // Metodo que agrega una arista al conjunto de aristas de un
            // ciudad
                
        {
            autopistas_.add(arista);
            return this;
        }
        
        public Ciudad modificarPredecesor(Ciudad predecesorNuevo)
                
            // Metodo que modifica el predecesor de una ciudad
                
        {
            predecesor_ = predecesorNuevo;
            return predecesor_;
        }          

        public Ciudad modificarDistancia(Integer distanciaNueva)
                
            // Metodo que modifica la distancia para la implementacion del
            // BellmanFord 
                
        {
            distancia_ = distanciaNueva;
            return this;
        }    
        
        public Boolean ciudadeIguales(Ciudad ciudadComparada)
                
            // Metodo que compara 2 ciudades con sus nombres    
                
        {
            return nombre_.equals(ciudadComparada.nombre_);
        }

        public void imprimir()
                
        // Metodo que imprime el nombre del ciudad y su conjunto de adyacencia
                
        {
                
            String lista = ""; // Inicializo el string donde imprimire todos
                               // los ciudads adyacentes
                
            int contador = 0;
                
            // Recorro toda la lista de adyacencia y concateno el nombre de
            // cada ciudad a la lista
                
            for (Ciudad hoja : adyacentes_)

            {
                       
                lista += hoja.nombre_ + "(ganacia: " + hoja.ganancia_ + ")";
                contador = contador + 1;
                       
                // Sino es el ultimo ciudad, añado una ',' para separarlo
                // de siguiente
                       
                if (contador != adyacentes_.size())
                               
                {
                               
                    lista += ", ";
                                   
                }      
                       
            }
                
            System.out.println("["+ nombre_ + "(ganacia: " + ganancia_ + ") ] "
                    + "-> [" + lista + "]");
            
            
            
        }        
        
    }