/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rutastransporte;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Implmentacion de la claso Mapa para el Proyecto 2 de CI2693
 * @author franciscosucre
 */
     class Mapa
    {
        // STATES
        
        private String nombre_;
        private HashSet<Ciudad> ciudades_;        
        private HashSet<Autopista> autopistas_;
        private Integer iteraciones_;
     
        // CONSTRUCTORS.
        
        public Mapa(HashSet<Ciudad> hojas,HashSet<Autopista> aristas)
                
        // Constructor con 2 argumentos que forma un grafo con un conjunto de 
        // aristas y una lista de ciudads que pertenecen a el                
        
        {
            autopistas_ = aristas;    
            ciudades_ = hojas; // Agregamos los ciudads
        }
        
        
        public Mapa()
                
        // Constructor que no recibe argumentos y forma un grafo vacio   
                
        {
            ciudades_ = new HashSet<>(); // Inicializamos el conjunto de ciudads
                                         //  en e lgrafo como un HashSet vacio
            autopistas_ = new HashSet<Autopista>();           
        }
        
        public Mapa(String nombre)
                
        // Constructor que no recibe argumentos y forma un grafo vacio   
                
        {
            nombre_ = nombre;
            ciudades_ = new HashSet<>(); // Inicializamos el conjunto de 
                                         // ciudades en el grafo como un HashSet
                                         // vacio
            autopistas_ = new HashSet<Autopista>();           
        }        
        public Mapa(Ciudad ciudadNuevo)
                
        // Constructor que no recibe argumentos y forma un grafo vacio   
                
        {
            ciudades_ = new HashSet<>(); // Inicializamos el conjunto de 
                                         // ciudades en el grafo como un HashSet
                                         // vacio
            ciudades_.add(ciudadNuevo);
            autopistas_ = new HashSet<Autopista>();
        }        

        // GETTERS.
        
        public int obtenerIteraciones()
        {
            return iteraciones_;
        }
        
        public HashSet <Ciudad> obtenerCiudades() 
                
        // Metodo que obtiene el conjunto de ciudads en el grafo, asi pueden 
        // usarse o guardarse                
                
        {      
            return ciudades_; // Retorna el conjunto de los ciudads del grafo    
        }    

        public HashSet <Autopista> obtenerAutopistas() 
                
        // Metodo que obtiene el conjunto de ciudads en el grafo, asi pueden 
        // usarse o guardarse                
                
        {
            return autopistas_; // Retorna el conjunto de los ciudads del grafo       
        }
        
        // SETTERS.   

        public Mapa agregarCiudad(Ciudad hoja)
                
        // Metodo que agrega un ciudad al conjunto de ciudads del grafo  
                
        {
            ciudades_.add(hoja);   // Agregamos el ciudad
            boolean repetido;   // Variable para examinar si hay otro ciudad con
                                // el mismo nombre en el grafo
            return this;      
        }
        
        public Mapa agregarAutopista(Autopista autopista)
                
        // Metodo que agrega un ciudad al conjunto de ciudads del grafo  
                
        {
            autopistas_.add(autopista);  // Agregamos el ciudad
                                         // Variable para examinar si hay otro ciudad con
                                         // el mismo nombre en el grafo
            return this;      
        }        
        
        public Mapa removerCiudad(Ciudad hoja)
                
        // Metodo que remueve un ciudad del conjunto de ciudads del grafo  
                
        {
            
            ciudades_.remove(hoja); // Removemos el ciudad
            return this;
                
        } 
          
        public Autopista encontrarAutopista(Ciudad origen,Ciudad Destino)
        {
            Autopista resultado = null;
            
            for (Autopista aristas: autopistas_)
            {
            
                if ((aristas.obtenerOrigen().ciudadeIguales(origen)) && 
                        (aristas.obtenerDestino().ciudadeIguales(Destino)))
                {
                
                    resultado = aristas;
                    
                }
            
            }
        
            if (resultado == null)
            {
            
                System.out.println("ERROR BUSCANDO LAS ARISTAS");
            
            }
            
            return resultado;
        
        }
        
        
        // COMPLEX METHODS.        

        public void analizarRutas(BufferedWriter bw) throws IOException
            {

                // Inicializamos el nodoOrigen del cual comenzaremos nuestro 
                // recorrido del grafo, y su distancia a si mismo en 0

                Ciudad nodoOrigen = new Ciudad("Ciudad origen", ciudades_);
                ArrayList<Ciudad> nodosAgregar = new ArrayList();
                nodoOrigen.modificarDistancia(0);
                ArrayList<Autopista> aristasCiclo = new ArrayList();
                ArrayList<ArrayList<Ciudad>> rutasEncontradas = new ArrayList();
                Boolean[] rentables; 

                // Agregamos adyacencias a todos los nodos del arbol 

                for (Ciudad nodos : ciudades_)

                {
                    nodos.modificarDistancia(nodos.obtenerGanancia());
                    nodosAgregar.add(0,nodoOrigen);
                    nodosAgregar.add(1,nodos);
                    
                    aristasCiclo.add(new Autopista(0, 
                            (ArrayList<Ciudad>) 
                            nodosAgregar.clone()));
                    
                    for (Autopista aristasAgre: aristasCiclo )
                    {
                        nodoOrigen.agregarAutopista(aristasAgre);
                        autopistas_.add(aristasAgre);
                    }
                    
                    nodosAgregar.clear();
                    aristasCiclo.clear();
                }
                
                ciudades_.add(nodoOrigen);
                
                int i;

                // Relajamos cada arista del grafo tantas veces como numero de 
                // nodos haya en el grafo

                for (i = 0 ; i < ((ciudades_).size()) ; i++ )
                {
                    for (Autopista aristas : autopistas_ )
                    {
                        if (aristas.obtenerDestino().obtenerDistancia() > 
                                aristas.obtenerOrigen().obtenerDistancia()
                                + aristas.obtenerCosto())
                        {
                            aristas.obtenerDestino().modificarDistancia(aristas.
                                    obtenerOrigen().obtenerDistancia() + 
                                    aristas.obtenerCosto());
                            
                            aristas.obtenerDestino().modificarPredecesor(
                                    aristas.obtenerOrigen());
                        }

                    }
                }

                // Comprobamos si hay ciclos negativos
                
                Boolean respuesta = false;
                
                for (Autopista aristas : autopistas_ )
                {
                    if (aristas.obtenerDestino().obtenerDistancia() > aristas.
                            obtenerOrigen().obtenerDistancia() + 
                            aristas.obtenerCosto())
                    {
                        aristasCiclo.add(aristas);
                    }
                }
                
                Boolean vuelta = false;
                ArrayList<Ciudad> recorrido = new ArrayList();
                ArrayList<ArrayList<Ciudad>> recorridos = new ArrayList();
                HashSet<Ciudad> nodosDescartados = new HashSet();
                
                
                int gananciaTotal;
                int peajeTotal;
                int balanceTotal;
                
                int f = 0;
                
                for (Autopista ciclos : aristasCiclo)
                {
                    recorrido.add(0, ciclos.obtenerDestino());
                    
                    for (i = 1; i < 100; i++)
                    {
                       recorrido.add(i,recorrido.get(i - 1).obtenerPredecesor()
                       );
                       
                       if (recorrido.get(i).ciudadeIguales(recorrido.get(0)))
                       {
                           rutasEncontradas.add(f,(
                                   ArrayList<Ciudad>) recorrido.clone());
                           recorrido.clear();
                           break;
                       } 
                    }
                    f =+ 1;
                }
                
                // Recorremos y comparamos las rutas para descartar repetidas
                
                int tamañoOriginal = rutasEncontradas.size();
                
                for (i = 0; i < tamañoOriginal; i++)
                {
                    gananciaTotal = 0;
                    peajeTotal = 0;
                    balanceTotal = 0;
                    String lista = null;
                    
                    for (f = 0; f < rutasEncontradas.get(i).size(); f++)
                    {
                        
                        if (f < rutasEncontradas.get(i).size() - 1)
                        {
                        gananciaTotal = gananciaTotal + rutasEncontradas.get(i)
                                .get(f).obtenerGanancia();
                        peajeTotal = peajeTotal + this.encontrarAutopista(
                                rutasEncontradas.get(i).get(f + 1), 
                                rutasEncontradas.get(i).get(f)).obtenerCosto();
                        }
                        
                        if (f == rutasEncontradas.get(i).size() - 1)
                        {
                            peajeTotal =peajeTotal + (this.encontrarAutopista(
                                rutasEncontradas.get(i).get(f).
                                        obtenerPredecesor(), 
                                rutasEncontradas.get(i).get(f))).obtenerCosto();
                        }
                        
                    }
                    
                    balanceTotal = gananciaTotal + peajeTotal;
                    
                    if ((balanceTotal < 0))
                    {
                    
                        for (f = 0; f < rutasEncontradas.get(i).size() - 1; f++)
                        { 
                            if (nodosDescartados.containsAll(
                                    rutasEncontradas.get(i)))
                            {
                                break;
                            }
                            
                            nodosDescartados.add(
                                    rutasEncontradas.get(i).get(rutasEncontradas.get(i).size() - 2 - f));
                            
                            if (f == 0)
                            {
                            lista = rutasEncontradas.get(i).get(rutasEncontradas.get(i).size() - 2 - f).
                                    obtenerNombre() + " ";
                            }
                            
                            if ((f < rutasEncontradas.get(i).size() - 1) && 
                                    (f != 0))
                            {
                            lista = lista + rutasEncontradas.get(i).get(rutasEncontradas.get(i).size() - 2 - f).
                                    obtenerNombre() + " ";
                            }
                            
                            if (f == rutasEncontradas.get(i).size() - 1)
                            {
                            lista = lista + rutasEncontradas.get(i).get(rutasEncontradas.get(i).size() - 2 - f).
                                    obtenerNombre();
                            }  
                        }
                        
                        if (lista != null)
                        {
                            bw.append(lista);
                            System.out.println(lista);
                            
                            if (i < tamañoOriginal - 1)
                            {
                                bw.newLine();
                            }
                        }
                    } 
                }

                
                if (nodosDescartados.isEmpty())
                {
                    System.out.println("TODAS LAS RUTAS SON RENTABLES");
                    bw.append("TODAS LAS RUTAS SON RENTABLES");
                }
                
                bw.write("\n");
            }
      


    public void imprimir()
                
        // Metodo que imprime todos los ciudads del grafo junto con sus 
        // conjuntos de adyacencia                
                
        { 
            int i = 0; // Inicio el mensajes para saber cuando estoy en el
                       // ultimo ciudad
            //System.out.println();
            //System.out.println("Los Ciudads Del grafo son: ");
            System.out.println();
            System.out.println("---------------------------");
            System.out.println();
            
            for (Ciudad hojas : ciudades_) // Recorro todos los ciudades del
                                           // conjunto para ir imprimiendolas

            {

                hojas.imprimir();
                i = i + 1;
                       
            }
                               
            System.out.println();
            System.out.println("---------------------------");
            System.out.println();
        }        
}