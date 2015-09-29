/*
 *Arleyn Goncalves
 *Francisco Sucre
 * Proyecto 1 De Laboratorio Algoritmos 3
 * Servicio Secreto
 * Clase Grafo
 */
package main;
import java.util.HashSet;


//No borrar los codigos en comentario, luego creare un archivo de grafo
//luego hare un archivo de grafo general para
//estudiar o copiar en otros programas

/**
 Las funcionalidades básicas que se esperan de la clase Grafo 
 son las siguientes:
 
 Un constructor sin argumentos que inicialice el conjunto en vacío. LISTO

 Un método obtenerNodos que devuelva el conjunto de nodos del grafo. LISTO

 Un método agregarNodo que reciba un nodo y lo agrege al conjunto 
 de nodos del grafo.
 
 Un método imprimir que imprima una representación del grafo,
 donde cada nodo del conjunto es escrito en una línea diferente.
 
 */
public class Grafo2

{
        //States
    
        private String nombre_; 
	private HashSet<Nodo> hojas_;
        
        //Constructors

        /*
        
        public Grafo(String nombre, Nodo nodoPadre)
        
        {
               nombre_ = nombre;
               hojas_ = new HashSet();
               hojas_.add(nodoPadre);
        }
        
        */
        
        public Grafo2()
        
        {

            hojas_ = new HashSet();
            
        }

        //Getters
        
        public HashSet<Nodo> getNodos() 
                
        {
            
                return hojas_;
                
        }    
        
        public HashSet<Nodo> obtenerAlcanzables()
                
                {
                
                    return hojas_;
                
                }        
        //setters   
        

        public boolean agregarNodo(Nodo nodo) 
        
        {
            
                return hojas_.add(nodo);
                
        }

        /*

        public HashSet<Arista> getAristas() {
                return aristas;
        }

        public Nodo getNodo(int codigo) {
                for (Nodo nodo : nodos) {
                        if (nodo.getCodigo() == codigo)
                                return nodo;
                }
                return null;
        }

        public void setNodos(HashSet<Nodo> nodos) {
                this.nodos = nodos;

        }

        public void setAristas(HashSet<Arista> aristas) {
                this.aristas = aristas;

        }

        public Arista getArista(int codigo) {
                for (Arista arista : aristas) {
                        if (arista.getCodigo() == codigo)
                                return arista;
                }
                return null;
        
        */
        
        
        
        public HashSet<Nodo> aplanarRed()
                
                {
                
                    return hojas_;
                
                }
        
        public HashSet <Nodo> cobertores()
                
        {

        	ArrayList lista = new ArrayList();

        	int contador = 0;

        	for (Nodo hoja : hojas_)

        	{

        		if lista.contains(hoja) == True

        		{
        			hoja.obtenerAlcanzable;
        			lista.add(hoja.obtenerAlcanzable);
        			contador = contador + 1;


        		}

        	}
                
            return hojas_;
                
        }

    

