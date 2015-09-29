/*
 * Francisco Sucre
 * Quiz 2
 * ROADNNET
 * Clase ROADNET
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author franciscosucre
 */
public class ROADNET 

{
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, 
            IOException 
    
    {
        int i; // Contador para correr los distintos casos de prueba
        
        File file = new File (args[0]); // Variable para abrir y leer el archivo
                                        // de entrada
        
        FileReader fileReader = new FileReader(file);
        
           try (BufferedReader in = new BufferedReader(fileReader)) 
            {
                String s; // Variable para leer lineas delaentrada
                
                String[] palabras; // Variable para separar las palabras de
                                   // la linea que leeremos
                
                Integer[][] distancias; // Matriz en la que guardaremos los 
                                        // valores de las distancias entre los
                                        // pueblos 
                
                Boolean[][] listaVecinos; // Matriz de vecinos ya descubiertos 
                                          // para no repetir los pares
                
                int numCasos; // Numero de casos de prueba
                
                int numPueblos; // Numero de pueblos en un caso
                
                int f; // Contadores usados para recorrer la matriz
                int j;
                
                Boolean vecinos = true; // Booleano para evaluar si se cumple
                                        // la condicion de vecinos
                
                
                s = in.readLine(); // Se lee una linea
                
                palabras = s.split(" "); // Separamos la linea
                
                numCasos = (new Integer(palabras[0])); // Obtenemos el numero de
                                                       // casos a probar          
                
                for (i = 0; i < numCasos ; i++)
                {  
                    s = in.readLine(); // Se lee una linea de la entrada
                    palabras = s.split(" "); // Separamos la linea
                    
                    numPueblos = (new Integer(palabras[0])); // Obtenemos el
                                                             // numero de
                                                             // pueblos para
                                                             // el caso de 
                                                             // prueba
                    
                    // Inicializo las matrices que usare para los calculos
                    
                    distancias = new Integer[numPueblos][numPueblos];                    
                    listaVecinos = new Boolean[numPueblos][numPueblos];
                    
                    // Inicializamos la matriz booleana, asumiendo que al inicio
                    // que nadie es vecino
                    
                    for (f = 0 ; f < numPueblos; f++)
                    {
                        for (j = 0; j < numPueblos; j++)
                        {
                            listaVecinos[f][j] = false;
                        }
                    }

                    // Leemos el archivo y obtenemos las distancias entre los
                    // objetos
                    
                    for (f = 0 ; f < numPueblos; f++)
                    {
                        s = in.readLine();
                        palabras = s.split(" ");
                        
                        for (j = 0; j < numPueblos; j++)
                        {
                            // Asigno los elementos de la matriz
                            distancias[f][j] = new Integer(palabras[j]);
                        }
                    }
                    
                    // Contadores que usaremos para hacer las 
                    // comparaciones entre los elementos de la matriz
                    
                    int a; 
                    int b;
                    int c;
                    
                    // Recorremos la matriz de distancia y comparamos los
                    // elementos para calcular los pueblos vecinos
                    
                    for (a = 0 ; a < numPueblos; a++)
                    {
                        for (b = 0; b < numPueblos; b++)
                        {
                            vecinos = true;
                            
                            for (c = 0; c < numPueblos; c++)
                            {
                                if ((a != b) && (c != a) && (c != b && 
                                        (distancias[a][b] == distancias[a][c] +
                                        distancias[b][c])))
                                {
                                    vecinos = false; // Con que se cumpla un
                                                     // solo caso ya se sabe que
                                                     // a y b no son vecinos asi
                                                     // cancelamos la busqueda
                                    break;
                                }
                            }
                            
                            // Imprimimos las parejas de vecinos calculadas y
                            // marcamos a los pueblos como vecinos si 
                            // los pueblos no son los mismos y si no fueron
                            // previamente marcados como vecinos, 
                            
                            if (vecinos && (a != b) &&  !listaVecinos[a][b] && 
                                   !listaVecinos[b][a])
                            {
                                listaVecinos[a][b] = true;
                                listaVecinos[b][a] = true;
                                System.out.println((a + 1) + " " + (b + 1));
                            }
                        }
                    }
                }
            }
    }
}
    
    

