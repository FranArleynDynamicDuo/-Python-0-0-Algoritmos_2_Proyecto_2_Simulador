/*
 *Arleyn Goncalves
 *Francisco Sucre
 * Proyecto 1 De Laboratorio Algoritmos 3
 * Servicio Secreto
 * Clase Grafo
 */

package main;
import java.util.Arrays;
import java.util.HashSet;

/*
Implementacion de la clase Grafo en la que el grafo consta de un conjunto de
nodos, guardados en un HashSet. Opcionalmente se le puede asignar un nombre
*/

public class Grafo 

{
        //STATES.
    
        private String nombre_; 
	private HashSet <Nodo> hojas_;
        
        //CONSTRUCTORS.
        
        public Grafo(String nombre, Nodo[] hojas)
                
        //Constructor con 2 argumentos que forma un grafo con un nombre y 
        //y una lista de nodos que pertenecen a el                
        
        {
            nombre_ = nombre; //Asignamos el nombre
                
            hojas_ = new HashSet(); //Inicializamos el conjunto de nodos en el
                                    //grafo como un HashSet vacio
                
            hojas_.addAll(Arrays.asList(hojas)); //Agregamos los
                                                 //nodos
        }

        
        
        public Grafo()
                
        //Constructor que no recibe argumentos y forma un grafo vacio   
                
        {

            hojas_ = new HashSet(); //Inicializamos el conjunto de nodos en el
                                    //grafo como un HashSet vacio
            
        }

        //GETTERS.
        
        public HashSet <Nodo> obtenerNodos() 
                
        //Metodo que obtiene el conjunto de nodos en el grafo, asi pueden usarse
        //o guardarse                
                
        {
            
            return hojas_; //Retorna el conjunto de los nodos del grafo
                
        }    
        

        
        //SETTERS.   

        public Grafo agregarNodo(Nodo hoja)
                
        //Metodo que agrega un nodo al conjunto de nodos del grafo  
                
        {
            hojas_.add(hoja); //Agregamos el nodo
            return this;
                
        }

        public Grafo agregarVariosNodo(Nodo[] hojas)
                
        //Metodo que agrega una lista de nodos al conjunto de nodos del grafo  
                
        {
            
            //Usamos un 'for' para recorrer todos los elementos en la lista
            //de nodos y asi agregarlos uno a uno
            
            hojas_.addAll(Arrays.asList(hojas)); //Agregamos un nodo al
                                                         //conjunto
                
            return this; //Devuelve el grafo con su conjunto de nodos
                         //modificado
                
        }       
        
        public Grafo removerrNodo(Nodo hoja)
                
        //Metodo que remueve un nodo del conjunto de nodos del grafo  
                
        {
            
            hojas_.remove(hoja); //Removemos el nodo
            return this;
                
        } 
        
        public Grafo RemoverVariosNodos(Nodo[] hojas)
                
        //Metodo que remueve varios nodos del grafo
                
        {
            
            //Usamos un 'for' para recorrer todos los elementos en la lista
            //de nodos y asi removerlos uno a uno
            
            hojas_.removeAll(Arrays.asList(hojas)); //removemos un nodo del
                                                    //conjunto
                
            return this; //Devuelve el grafo con su conjunto de nodos
                         //modificado
                
        }       
        
        //METODOS COMPLEJOS.
        
        public HashSet <Nodo> aplanarRed()
                
        {
                
            return hojas_;
                
        }
        
        public HashSet <Nodo> cobertores()
                
        {
                
            return hojas_;
                
        }
        
        public void imprimir()
                
        //Metodo que imprime todos los nodos del grafo junto con sus conjuntos
        //de adyacencia                
                
        {
            
            int i = 0; //Inicio el contador para saber cuando estoy en el
                       //ultimo nodo
            System.out.println();
            System.out.println("Los Nodos Del grafo son: ");
            System.out.println();
            System.out.println("---------------------------");
            System.out.println();
            
            
            for (Nodo hojas : hojas_) //Recorro todos los nodos del conjunto 
                                      //ir imprimiendolos 1 a 1

            {

                hojas.imprimir();
                i = i + 1;
                       
            }

                               
            System.out.println();
            System.out.println("---------------------------");

        
        }
        
}

    

