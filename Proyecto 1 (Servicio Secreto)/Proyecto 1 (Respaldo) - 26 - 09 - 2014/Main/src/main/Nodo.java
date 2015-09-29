/*
 *Arleyn Goncalves
 *Francisco Sucre
 * Proyecto 1 De Laboratorio Algoritmos 3
 * Servicio Secreto
 * Clase Nodo
 */
package main;
import java.util.Arrays;
import java.util.HashSet;

/**
 Las funcionalidades básicas que se esperan de la clase Nodo son las siguientes:
 
 Un constructor que reciba únicamente el nombre del nodo en cuestión
 e inicialice el conjunto de nodos adyacentes en vacío. LISTO
 
 Un constructor que reciba el nombre del nodo en cuestión y el conjunto de 
 nodos adyacentes. LISTO
 
 Un método obtenerNombre que devuelva el nombre del nodo. LISTO

 Un método obtenerAdyacentes que devuelva el conjunto de nodos adyacentes.LISTO

 Un método agregarAdyacente que reciba un nodo y lo agregue al conjunto de
 adyacentes LISTO

 Un método agregarVariosAdyacentes que reciba un conjunto de nodos y 
 agregue todos al conjunto de adyacentes LISTO

 Un método imprimir que imprima una representación del nodo
 con el siguiente formato: LISTO
 
 [nombre] -> [nombre-ady-0, nombre-ady-1, ..., nombre-ady-n]
 *
 */


public class Nodo

{
	//states
    
	private String nombre_;
	private HashSet<Nodo> adyacentes_;

	//constructors.

        //Constructor de nodos con lista de adyacencia
        
	public Nodo(String nombre,Nodo[] adyacentes)
            {	

                nombre_ = nombre;
                adyacentes_ = new HashSet(); 
                adyacentes_.addAll(Arrays.asList(adyacentes));

            }
                    
        //Constructor de nodos sin lista de adyacencia  
                    
                    
        public Nodo(String nombre)
            {	

                nombre_ = nombre;
                adyacentes_ = new HashSet();  
                    
            }
        
	//setters y getters.

	//Metodo para obtener el nombre de un nodo y guardarlo en una variable

	public String getNombre()

            {
                return nombre_;
            }
        
        public HashSet<Nodo> getList()
                
        {
        
            return adyacentes_;
            
        }

	//Metodo para agregar un nodo a la lista de adyacencia de un nodo

	public Nodo add(Nodo nodoNuevo)

            {
			
		adyacentes_.add(nodoNuevo);
                return this;
                                    
            } 
        
        //Metodo que agrega una lista de nodos a la lista de adyacencia de un
        //nodo
        
        public Nodo addMany(Nodo... hojasNew)
                
            {
            
                //Usamos un 'for' para recorrer todos los elementos en la lista
                //de nodos y agregarlos uno a uno
                
                for (Nodo hojaNueva : hojasNew)
                    {
                    
                       adyacentes_.add(hojaNueva);
                    
                    }
                
                return this;
                
            }

	//Metodo para remover un nodo de la lista de adyacencia de un nodo

	public Nodo remove(Nodo nodoBotar)

            {		
                adyacentes_.remove(nodoBotar);
                return this;

            } 
        
        //Metodo para remover una lista de nodos de la lista de adyacencia
        //de un nodo
        
        public Nodo removeMany(Nodo[] hojasOld)
                
            {
            
                //Usamos un 'for' para recorrer todos los elementos en la lista
                //de nodos y remover uno a uno de las adyacencias
                
                for (Nodo hojaVieja : hojasOld)
                    {
                    
                       adyacentes_.remove(hojaVieja);
                    
                    }
                
                return this;
                
            }
        
        //Metodo que imprime el nombre del nodo y su lista de adyacencia
        
        public void imprimirNodo()
                
            {
                
                String lista = ""; //Inicializo el string donde imprimire todos
                                   //loa nodos adyacentes
                
                int contador = 0;
                
                //Recorro toda la lista de adyacencia y concateno el nombre de
                //cada nodo a la lista
                
                for (Nodo hoja : adyacentes_)

                    {
                       
                       lista += hoja.nombre_;
                       contador = contador + 1;
                       
                       if (contador != adyacentes_.size())
                               
                               {
                               
                                   lista += ", ";
                                   
                               }
                       
                       
                       
                    }
                
                System.out.println("["+ nombre_ + "] -> [" + lista + "]");
        
            }
 
}