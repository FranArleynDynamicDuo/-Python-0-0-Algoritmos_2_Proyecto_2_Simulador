/*
 * Arleyn Goncalves
 * Francisco Sucre
 * Proyecto 3 De Laboratorio Algoritmos 3
 * Rutas de Transporte
 * Clase RutasTransporte
 */
package rutastransporte;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author franciscosucre
 */
public class RutasTransporte 
{

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, 
            IOException 
    {
        // TODO code application logic here
        
        int i;
        File file = new File (args[0]);
        FileReader fileReader = new FileReader(file);
        File archivo = new File("output.txt");
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(archivo));        
        
           try (BufferedReader in = new BufferedReader(fileReader)) 
            {
                String s; // Variable para leer lineas delaentrada
                String[] palabras; // Variable para separar las palabras de
                                   // la linea que leeremos
                Mapa[] mapas; // Arreglo para los distintos casos de prueba
                int numCasos; // Entero done guardaremos el numero de Ciudades
                int numCiudades; // Entero con el cual ubicaremos 
                                  // la linea en la que estamos
                int numAutopistas; // Numero de aristas del caso actual
                int origen;
                int destino;
                int f;
                
                
                
                s = in.readLine();
                palabras = s.split(" ");
                numCasos = (new Integer(palabras[0]));
                mapas = new Mapa[numCasos];
                ArrayList<Ciudad> conectados = new ArrayList();
                HashSet<Autopista> aristasAgregar = new HashSet();
                
                for (i = 0; i < numCasos ; i++)
                {  
                    mapas[i] = new Mapa("Mapa " + 
                            (String.valueOf(i + 1)));
                    
                    s = in.readLine();
                    
                    palabras = s.split(" ");  // Separamos la linea
              
                    numCiudades = (new Integer(palabras[0]));         
                    numAutopistas = (new Integer(palabras[1]));
                    
                    Ciudad[] ciudadesAgre = new Ciudad[numCiudades]; 
                                                    // Lista de los 
                                                    // Ciudades creados
                    int j = 0;
                    int linea = 0;
                
                    // Creo cuantos Ciudades sean necesario

                    while ((numCiudades > linea))
                    {   
                        s = in.readLine();
                        palabras = s.split(" ");
                        ciudadesAgre[j] =(new Ciudad(String.valueOf(palabras[0]),
                                new Integer(palabras[1])));
                        linea += 1;
                        j += 1;
                    }       

                    linea = 0; // Contador de lineas para la lectura
                    
                    // Obtengo las autopistas del archivo
                    
                    while ((numAutopistas > linea))

                    {
                        s = in.readLine();
                        palabras = s.split(" ");
                        origen = 0;
                        destino = 0;
                        
                        
                        for (f = 0 ; f < numCiudades ; f++ )
                        {
                        
                            if (ciudadesAgre[f].obtenerNombre().equals(
                                    palabras[0]))
                                {
                                    origen = f;
                                }
                            if (ciudadesAgre[f].obtenerNombre().equals(
                                    palabras[1]))
                                {
                                    destino = f;
                                }
                            if (destino != 0 && origen != 0)
                                {
                                    break;
                                }
                        }

                        int peaje = new Integer(palabras[2]);
                        
                        // Agregamos las adyacencias
                        
                        ciudadesAgre[origen].agregarAdyacente(
                                ciudadesAgre[destino]);
                        
                        conectados.add(0, ciudadesAgre[origen]); 
                        conectados.add(1, ciudadesAgre[destino]);
                        
                        // Agregamos la arista al nodo y al universo
                        
                        aristasAgregar.add(new Autopista(
                                    -peaje, (ArrayList<Ciudad>) 
                                            conectados.clone()));
                        
                        for (Autopista autopistaAgregar : aristasAgregar)
                        {
                            ciudadesAgre[origen].agregarAutopista(
                                    autopistaAgregar);
                            mapas[i].agregarAutopista(autopistaAgregar);
                        }
                        
                        /*
                        
                        ciudadesAgre[origen].agregarAutopista(new Autopista(
                                    -peaje, (ArrayList<Ciudad>) 
                                            conectados.clone()));
                        
                        mapas[i].obtenerAutopistas().add(new Autopista(
                                    -peaje, (ArrayList<Ciudad>) 
                                            conectados.clone()));
                        */
                        
                        conectados.clear(); // Vaciamos la lista para usarla de
                                            // nuevo
                        aristasAgregar.clear();
                        
                        int x;
                        
                        // Agregamos los nodos al universo en el que trabajamos
                        
                        for (x = 0; x < ciudadesAgre.length; x++ )
                        {
                            
                            mapas[i].agregarCiudad(ciudadesAgre[x]);
                        
                        }
                                
                        linea = linea + 1;
                        
                    }
                    
                    mapas[i].analizarRutas(bw);
                    
                    if (i != numCasos - 1)
                    {
                        System.out.println();
                    }
                    

                    
                }
                    
            }
           
           bw.close();
    }
}
