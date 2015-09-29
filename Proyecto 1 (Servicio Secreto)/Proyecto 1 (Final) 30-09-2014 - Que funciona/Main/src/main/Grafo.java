/*
 * Arleyn Goncalves
 * Francisco Sucre
 * Proyecto 1 De Laboratorio Algoritmos 3
 * Servicio Secreto
 * Clase Grafo
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
   Implementacion de la clase Grafo en la que el grafo consta de un conjunto de
   nodos, guardados en un HashSet. Opcionalmente se le puede asignar un nombre
*/

public class Grafo 

{
        // STATES.
    
        private String nombre_; 
	private HashSet <Nodo> hojas_;
        
        // CONSTRUCTORS.
        
        public Grafo(String nombre, HashSet<Nodo> hojas)
                
        // Constructor con 2 argumentos que forma un grafo con un nombre y 
        // y una lista de nodos que pertenecen a el                
        
        {
            nombre_ = nombre; // Asignamos el nombre
                
            hojas_ = hojas; // Agregamos los nodos
        }
        
        
        public Grafo()
                
        // Constructor que no recibe argumentos y forma un grafo vacio   
                
        {

            hojas_ = new HashSet(); // Inicializamos el conjunto de nodos en el
                                    // grafo como un HashSet vacio
            
        }

        // GETTERS.
        
        public HashSet <Nodo> obtenerNodos() 
                
        // Metodo que obtiene el conjunto de nodos en el grafo, asi pueden 
        // usarse o guardarse                
                
        {
            
            return hojas_; // Retorna el conjunto de los nodos del grafo
                
        }    
        
        // SETTERS.   

        public Grafo agregarNodo(Nodo hoja)
                
        // Metodo que agrega un nodo al conjunto de nodos del grafo  
                
        {
            hojas_.add(hoja); // Agregamos el nodo
            boolean repetido;   // Variable para examinar si hay otro nodo con
                                // el mismo nombre en el grafo
            
            for (Nodo adyacentes : hoja.obtenerAdyacentes())
                
                // Ya que estamos trabajando con un grafo no dirigido entonces
                // las adyacencias deben ser en los otros sentidos, entonces
                // agregamos el nuevo nodo al conjunto de adyacencia de los 
                // nodos que estan en el conjunto de adyacencia del nuevo nodo

                    
            {
                repetido = false;
                
                for (Nodo nodo : hoja.obtenerAdyacentes())
                {
                
                    repetido = hoja.obtenerNombre().equals
                               (nodo.obtenerNombre());
                    
                    if (repetido == true)
                    {
                        break;
                    }
                
                }
                
                if (repetido == false)
                    
                {
                    adyacentes.agregarAdyacente(hoja);
                }
            }
            
            return this;
                
        }

        public Grafo agregarVariosNodo(Nodo[] hojas)
                
        // Metodo que agrega una lista de nodos al conjunto de nodos del grafo  
                
        {
            
            // Usamos un 'for' para recorrer todos los elementos en la lista
            // de nodos y asi agregarlos uno a uno
            
            hojas_.addAll(Arrays.asList(hojas)); // Agregamos un nodo al
                                                 // conjunto
                
            return this; // Devuelve el grafo con su conjunto de nodos
                         // modificado
                
        }       
        
        public Grafo removerNodo(Nodo hoja)
                
        // Metodo que remueve un nodo del conjunto de nodos del grafo  
                
        {
            
            hojas_.remove(hoja); // Removemos el nodo
            return this;
                
        } 
        
        public Grafo RemoverVariosNodos(Nodo[] hojas)
                
        // Metodo que remueve varios nodos del grafo
                
        {
            
            // Usamos un 'for' para recorrer todos los elementos en la lista
            // de nodos y asi removerlos uno a uno
            
            hojas_.removeAll(Arrays.asList(hojas)); // removemos un nodo del
                                                    // conjunto
                
            return this; // Devuelve el grafo con su conjunto de nodos
                         // modificado
                
        }       
        
        // COMPLEX METHODS.
        
        public Grafo aplanarRed()
                
        // Metodo que recorre el grafo e imprime los nodos alcanzables por cada
        // nodo en el grafo
                
        {

            
            Grafo aplanado = new Grafo();
            
            for (Nodo hoja : hojas_) // Recorro todos los nodos del conjunto 
                                     // e imprimimos sus alcanzables 1 a 1
            {
                aplanado.agregarNodo(new Nodo(hoja.obtenerNombre(),
                                     hoja.obtenerAlcanzables()));
            }

            return aplanado;
            
        }
        
        
        public int cobertores()
                
            // Metodo que recorre el grafo y calcula la cantidad de mensajes
            // necesarios para contactar a todos los nodos
                
        {
            
            HashSet<Nodo> visitados = new HashSet (); // Conjunto de los nodos 
                                                      // ya visitados
            
            HashSet<Nodo> alcanzados = new HashSet(); // Conjunto de los nodos
                                                      // alcanzados por un nodo
                                                      // elegido
            int mensajes = 0; // Contador de los mensajes necesarios
            
            for (Nodo hoja : hojas_)
                
                // Recorremos el grafo, nodo por nodo, almacenando los
                // visitados en un conjunto, y cuando volvemos a pasar por un
                // nodo visitado lo ignoramos y no hacemos el recorrido

            {
                
                if (!(visitados.contains(hoja))) // Verificamos si el nodo ya
                                                 // ya fue visitado

        	{   
                    alcanzados = hoja.obtenerAlcanzables();
                    Nodo impreso = new Nodo(hoja.obtenerNombre(),alcanzados);
                    impreso.imprimir();
                    
                    // Obtenemos los alcanzables desde el nodo en que trabajamos
                    
                    for (Nodo nodos : alcanzados)
                    {
                        
                        visitados.add(nodos); // Agregamos los nuevos nodos a
                                              // la lista de visitados
                        
                    }
                    
                    alcanzados.clear(); // Reiniciamos la lista de alcanzados
                                        // para trabajar en un nuevo nodo
                    
                    mensajes = mensajes + 1; // Sumamos un mensaje por cada
                                             // recorrido hecho

        	}

            }
            
            return mensajes;
        }
       
    
        public void imprimir()
                
        // Metodo que imprime todos los nodos del grafo junto con sus conjuntos
        // de adyacencia                
                
        {
            
            int i = 0; // Inicio el mensajes para saber cuando estoy en el
                       // ultimo nodo
            //System.out.println();
            //System.out.println("Los Nodos Del grafo son: ");
            System.out.println();
            System.out.println("---------------------------");
            System.out.println();
            
            for (Nodo hojas : hojas_) // Recorro todos los nodos del conjunto 
                                      // ir imprimiendolos 1 a 1

            {

                hojas.imprimir();
                i = i + 1;
                       
            }
                               
            System.out.println();
            System.out.println("---------------------------");
            System.out.println();
        
        }
        
}