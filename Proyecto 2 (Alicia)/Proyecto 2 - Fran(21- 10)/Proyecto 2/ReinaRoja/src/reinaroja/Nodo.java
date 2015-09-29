/*
 * Arleyn Goncalves
 * Francisco Sucre
 * Proyecto 2 De Laboratorio Algoritmos 3
 * Alicia
 * Clase Nodo
 */
package reinaroja;

import java.util.HashSet;

/**
 * Implementacion de la clase Nodo para ReinaRoja
 * @author Francisco Sucre & Arleyn Goncalves
 */
    public class Nodo

    {  
        // STATES
        
        private String nombre_; // Nombre del nodo
        private HashSet<Nodo> adyacentes_; // El conjunto de los nodos 
                                             // adyacentes a cada nodo
        private HashSet<Arista> aristas_; // El conjunto de las aristas a las
                                            // cuales el nodo es incidente
        
        // CONSTRUCTORS
        
        public Nodo(String nombre)
                
                // Constructor de Nodo que recibe el nombre del nodo
                
        {        
            nombre_ = nombre;
            adyacentes_ = new HashSet<Nodo>();
            aristas_ = new HashSet<Arista>();            
        }
        
        public Nodo(String nombre, HashSet<Nodo> adyacentes)

                // Constructor de Nodo que recibe el nombre del nodo y un
                // conjunto de nodos
                
        {        
            nombre_ = nombre;
            adyacentes_ = adyacentes;          
        }
        
        public Nodo(String nombre, HashSet<Nodo> adyacentes,
                HashSet<Arista> arista)

                // Constructor de Nodo que recibe el nombre del nodo, un      
                // conjunto de nodos y un conjunto de aristas              
                
        {        
            nombre_ = nombre;
            adyacentes_ = adyacentes;
            aristas_ = arista;           
        }        
        
        public Nodo(String nombre, Nodo nodo)
                
                // Constructor de Nodo que recibe el nombre del nodo y un nodo
                
        {       
            nombre_ = nombre;
            adyacentes_.add(nodo);            
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
                
                // Metodo que agrega una arista al conjunto de aristas de un
                // nodo
                
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