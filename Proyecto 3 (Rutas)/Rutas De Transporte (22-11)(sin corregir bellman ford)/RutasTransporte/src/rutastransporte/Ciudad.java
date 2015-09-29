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
        private Boolean visitado_;
        // CONSTRUCTORS
        
        public Ciudad(String nombre)
                
                // Constructor de Ciudad que recibe el nombre del ciudad
                
        {        
            nombre_ = nombre;
            adyacentes_ = new HashSet<Ciudad>();
            autopistas_ = new HashSet<Autopista>();
            distancia_ = 0;
            predecesor_ = null;
            visitado_ = false;
        }
        
        public Ciudad(String nombre, Integer costo)
                
                // Constructor de Ciudad que recibe el nombre del ciudad
                
        {        
            nombre_ = nombre;
            adyacentes_ = new HashSet<Ciudad>();
            autopistas_ = new HashSet<Autopista>();
            ganancia_ = costo;
            distancia_ = 0;
            predecesor_ = null;
            visitado_ = false;
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
            visitado_ = false;
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
            visitado_ = false;
        }        
        
        public Ciudad(String nombre, Ciudad ciudad)
                
                // Constructor de Ciudad que recibe el nombre del ciudad y un ciudad
                
        {       
            nombre_ = nombre;
            adyacentes_.add(ciudad); 
            autopistas_ = new HashSet<Autopista>();
            distancia_ = 0;
            predecesor_ = null;
            visitado_ = false;
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
        {
        
            return distancia_;
            
        }
        
        public Integer obtenerGanancia()
        {
            return ganancia_;
        }
        
        public Ciudad obtenerPredecesor()
        {
            return predecesor_;
        }   
        
        public boolean esVisitado() 
        
        { 
            
          return visitado_;
            
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
        
        
        public Ciudad agregarVariosAdyacentes(HashSet<Ciudad> conjunto)
                
        // Metodo que agrega una lista de ciudads a la lista de adyacencia de un
        // ciudad                
                
        {
            
            // Usamos un 'for' para recorrer todos los elementos en la lista
            // de ciudads y asi agregarlos uno a uno
            
            for (Ciudad ciudad : conjunto)
                
            {
            
                adyacentes_.add((Ciudad) ciudad);
            
            }
                
            return this; // Devuelve el ciudad con su conjunto de adyacencia
                         // modificado
                
        }

        public Ciudad agregarAutopista(Autopista arista)
                
                // Metodo que agrega una arista al conjunto de aristas de un
                // ciudad
                
        {
        
            autopistas_.add(arista);
            return this;
            
        }
        
        public Ciudad modificarPredecesor(Ciudad predecesorNuevo)
        {
            predecesor_ = predecesorNuevo;
            return predecesor_;
        }           
        
	public Ciudad remover(Ciudad ciudadBotar)
                
	// Metodo para remover un ciudad de la lista de adyacencia de un ciudad                

        {		
            adyacentes_.remove(ciudadBotar); // Removemos el ciudad del conjunto
            
            return this; // Devuelve el Ciudad con su conjunto de adyacencia
                         // modificado

        } 

        
        public Ciudad removerVarios(HashSet<Ciudad> ciudads)
                
        // Metodo para remover una lista de ciudads de la lista de adyacencia
        // de un ciudad     
                
        {
            
            // Usamos un 'for' para recorrer todos los elementos en la lista
            // de ciudads y removerrr uno a uno de las adyacencias
                
            for (Ciudad hojaVieja : ciudads)
                    
            {
                    
                adyacentes_.remove(hojaVieja); // Removemos el ciudad
                    
            }
                
            return this;
                
        }          

        public Ciudad modificarDistancia(Integer distanciaNueva)
        {
            distancia_ = distanciaNueva;
            return this;
        }
        
        public Ciudad modificarGanancia(Integer gananciaNueva)
        {
            ganancia_ = gananciaNueva;
            return this;
        }        
        
        public Ciudad resetearVisitados()
        
        // Metodo que cambia todos los booleanos de los nodos alcanzables a
        // false
                
        {
            
            Queue<Ciudad> cola = new LinkedList<Ciudad>(); // Cola usada para
                                                       // recorrer el grafo
            
            HashSet<Ciudad> alcanzable = new HashSet<Ciudad>();   // Conjunto de
                                                              // nodos
                                                              //alcanzables
                                                              // desde un nodo
            
            cola.add((Ciudad) this); //Agrego el nodo original a la cola
            
           while (!cola.isEmpty())
            
            // Mientras la cola no este vacia recorrere el arbol   
               
            {   

                alcanzable.add((Ciudad)cola.peek()); // Añado el primer nodo en la
                                                   // cola a la lista de
                                                   // alcanzables
                
                for (Ciudad nodo : cola.peek().adyacentes_)
                    
                // Recorremos los nodos adyacentes de la cabeza de la cola
                    
                {
                    if (nodo.esVisitado() == true)
                
                    // Si el nodo tiene '.visitado' se cambia a falsey lo
                    // agregamos a la cola
                        
                    {
                    
                        nodo.visitado_ = false;
                        cola.add(nodo);
                        
                    }
                    
                }
                
                cola.remove();
            
            }        
            
            return this;
        }
        
        public Boolean ciudadeIguales(Ciudad ciudadComparada)
        {
        
            return nombre_.equals(ciudadComparada.nombre_);
        
        }
        
        public Boolean ciudadAlcanzable(Ciudad ciudadBuscada)
        {
            
            Boolean alcanzable = false;
        
            for (Ciudad ciudades: adyacentes_)
                    {
                    
                        for (Ciudad ciudades1 : ciudades.obtenerAlcanzables())
                        {
                            if (ciudades1.obtenerNombre().equals(
                                    ciudadBuscada.obtenerNombre()))
                            {
                                alcanzable = true;
                            }
                        }
                        
                    }
            
            return alcanzable;
        
        }
        
        public HashSet<Ciudad> obtenerAlcanzables()
                
        // Metodo que dado un nodo, devuelva un conjunto con todos los nodos 
        // que son alcanzables desde el mismo (incluyéndolo a el mismo)
                
        {   
            
            visitado_ = false; // Inicializo el booleano 'visitado' del nodo
            
            this.resetearVisitados(); // Reseteo el booleano 'visitado' para
                                      // los alcanzables del nodo
            
            Queue<Ciudad> cola = new LinkedList<Ciudad>();  // Cola usada para
                                                        // recorrer el grafo 
            
            HashSet<Ciudad> alcanzable = new HashSet<Ciudad>(); // Conjunto de nodos
                                                            // alcanzables
                                                            // desde un nodo
            
            for (Ciudad ciudadesAgregar : adyacentes_)
            {
                cola.add(ciudadesAgregar);  //Agrego el nodo original a la cola
                ciudadesAgregar.visitado_ = true;
            }
            
            while (!cola.isEmpty())

            // Mientras la cola no este vacia recorrere el arbol                
                
            {   
                alcanzable.add((Ciudad)cola.peek()); // Añado el primer nodo 
                                                     // en la cola a la lista de
                                                     // alcanzables
                
                for (Ciudad nodo : cola.peek().adyacentes_)
                    
                // Recorro todos los nodos del conjunto de adyacencia del nodo
                // que esta de primero en la cola
                
                {
                    if (nodo.esVisitado() == false) // Busco los nodos no
                                                    // visitados
                
                    {
                    
                        nodo.visitado_ = true; // Marco el nodo como visitado
                        cola.add(nodo); // Lo agrego a la cola
                        
                    }
                    
                }
                
                cola.remove(); // Remuevo el primer Ciudad de la cola 
            
            }

            this.resetearVisitados();
            return alcanzable;
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