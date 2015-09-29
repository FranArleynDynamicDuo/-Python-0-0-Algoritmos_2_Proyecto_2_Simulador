/*
 * Arleyn Goncalves
 * Francisco Sucre
 * Proyecto 2 De Laboratorio Algoritmos 3
 * Alicia
 * Clase Nodo
 */

package reinablanca;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author franciscosucre
 */
    public class Nodo

    {
        
        // STATES
        
        private String nombre_;
        private HashSet<Nodo> adyacentes_;
        private HashSet<Arista> aristas_;
        private Boolean visitado_;
        
        // CONSTRUCTORS
        
        public Nodo(String nombre)
                
        {
        
            nombre_ = nombre;
            adyacentes_ = new HashSet<Nodo>();
            aristas_ = new HashSet<Arista>();
            
        }
        
        public Nodo(String nombre, HashSet<Nodo> adyacentes)
        
        {
        
            nombre_ = nombre;
            adyacentes_ = adyacentes;
            
        }
        
        public Nodo(String nombre, HashSet<Nodo> adyacentes,
                HashSet<Arista> arista)
        
        {
        
            nombre_ = nombre;
            adyacentes_ = adyacentes;
            aristas_ = arista;
            
            
        }        
        
        public Nodo(String nombre, Nodo nodo)
        
        {
        
            nombre_ = nombre;
            adyacentes_.add(nodo);
            
        }

        public Nodo(String nombre, Nodo nodo, Arista arista)
        
        {
        
            nombre_ = nombre;
            adyacentes_.add(nodo);
            aristas_.add(arista);
            
        }

	// GETTERS.

	public String obtenerNombre()
                
        // Metodo para obtener el nombre de un nodo y guardarlo en una variable

        {
            return nombre_; // Hacemos return solo con el nombre del nodo
        }
        
        public HashSet<Arista> obtenerAristas()
                
        // Metodo para obtener la lista de aristas asociadas al nodo
        
        {
        
            return aristas_;
        
        }
        
        public HashSet<Nodo> obtenerAdyacentes()
                
        // Metodo para obtener el conjunto de adyacencia de un nodo                
                
        {
            return adyacentes_; // Hacemos return solo con el conjunto
            
        }
        
        public boolean esVisitado() 
        
        { 
            
          return visitado_;
            
        }
        
        public Nodo resetearVisitados()
        
        // Metodo que cambia todos los booleanos de los nodos alcanzables a
        // false
                
        {
            
            Queue<Nodo> cola = new LinkedList<Nodo>(); // Cola usada para
                                                       // recorrer el grafo
            
            HashSet<Nodo> alcanzable = new HashSet<Nodo>();   // Conjunto de
                                                              // nodos
                                                              //alcanzables
                                                              // desde un nodo
            
            cola.add((Nodo) this); //Agrego el nodo original a la cola
            
           while (!cola.isEmpty())
            
            // Mientras la cola no este vacia recorrere el arbol   
               
            {   

                alcanzable.add((Nodo)cola.peek()); // Añado el primer nodo en la
                                                   // cola a la lista de
                                                   // alcanzables
                
                for (Nodo nodo : cola.peek().adyacentes_)
                    
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
        
        public HashSet<Nodo> obtenerAlcanzables()
                
        // Metodo que dado un nodo, devuelva un conjunto con todos los nodos 
        // que son alcanzables desde el mismo (incluyéndolo a el mismo)
                
        {   
            
            visitado_ = false; // Inicializo el booleano 'visitado' del nodo
            
            this.resetearVisitados(); // Reseteo el booleano 'visitado' para
                                      // los alcanzables del nodo
            
            Queue<Nodo> cola = new LinkedList<Nodo>();  // Cola usada para
                                                        // recorrer el grafo 
            
            HashSet<Nodo> alcanzable = new HashSet<Nodo>(); // Conjunto de nodos
                                                            // alcanzables
                                                            // desde un nodo
                                                            
            cola.add((Nodo) this);  //Agrego el nodo original a la cola
            visitado_ = true;   // Marco el nodo original como visitado
            
            while (!cola.isEmpty())

            // Mientras la cola no este vacia recorrere el arbol                
                
            {   
                alcanzable.add((Nodo)cola.peek()); // Añado el primer nodo en la
                                                   // cola a la lista de
                                                   // alcanzables
                
                for (Nodo nodo : cola.peek().adyacentes_)
                    
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
                
                cola.remove(); // Remuevo el primer Nodo de la cola 
            
            }

            this.resetearVisitados();
            return alcanzable;
        } 

        
        
        
	public Nodo agregarAdyacente(Nodo nodoNuevo)
                
	// Metodo para agregarAdyacente un nodo a la lista de adyacencia
        // de un nodo
                
        {
            
            adyacentes_.add(nodoNuevo); // Añadimos el nuevo nodo al conjunto
                                        // de adyacencia
            
            return this; // Y hacemos return con el conjunto modificado
                                    
        } 
        
        
        public Nodo agregarVariosAdyacentes(HashSet<Nodo> conjunto)
                
        // Metodo que agrega una lista de nodos a la lista de adyacencia de un
        // nodo                
                
        {
            
            // Usamos un 'for' para recorrer todos los elementos en la lista
            // de nodos y asi agregarlos uno a uno
            
            for (Nodo nodo : conjunto)
                
            {
            
                adyacentes_.add((Nodo) nodo);
            
            }
                
            return this; // Devuelve el nodo con su conjunto de adyacencia
                         // modificado
                
        }

        public Nodo agregarArista(Arista arista)
        {
        
            aristas_.add(arista);
            return this;
            
        }
        
	public Nodo remover(Nodo nodoBotar)
                
	// Metodo para remover un nodo de la lista de adyacencia de un nodo                

        {		
            adyacentes_.remove(nodoBotar); // Removemos el nodo del conjunto
            
            return this; // Devuelve el Nodo con su conjunto de adyacencia
                         // modificado

        } 

        
        public Nodo removerVarios(HashSet<Nodo> nodos)
                
        // Metodo para remover una lista de nodos de la lista de adyacencia
        // de un nodo     
                
        {
            
            // Usamos un 'for' para recorrer todos los elementos en la lista
            // de nodos y removerrr uno a uno de las adyacencias
                
            for (Nodo hojaVieja : nodos)
                    
            {
                    
                adyacentes_.remove(hojaVieja); // Removemos el nodo
                    
            }
                
            return this;
                
        }          

        public void imprimir()
                
        // Metodo que imprime el nombre del nodo y su conjunto de adyacencia
                
        {
                
            String lista = ""; // Inicializo el string donde imprimire todos
                               // los nodos adyacentes
                
            int contador = 0;
                
            // Recorro toda la lista de adyacencia y concateno el nombre de
            // cada nodo a la lista
                
            for (Nodo hoja : adyacentes_)

            {
                       
                lista += hoja.nombre_;
                contador = contador + 1;
                       
                // Sino es el ultimo nodo, añado una ',' para separarlo
                // de siguiente
                       
                if (contador != adyacentes_.size())
                               
                {
                               
                    lista += ", ";
                                   
                }      
                       
            }
                
            System.out.println("["+ nombre_ + "] -> [" + lista + "]");
        }        
        
    }