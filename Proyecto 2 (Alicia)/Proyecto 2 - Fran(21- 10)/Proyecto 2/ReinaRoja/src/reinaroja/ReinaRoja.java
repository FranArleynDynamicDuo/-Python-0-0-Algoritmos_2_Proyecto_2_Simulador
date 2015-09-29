/*
 *Arleyn Goncalves
 *Francisco Sucre
 * Proyecto 2 De Laboratorio Algoritmos 3
 * Alicia
 * Clase ReinaRoja
 */

package reinaroja;

import java.io.IOException;

/**
 * Clase Reina Roja donde llamaremos los procedimientos
 * @author franciscosucre
 */
public class ReinaRoja {

    /**
     * @param args Escribimos el nombre del .txt que usaremos
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException 
    
    {
        
        Grafo prueba = new Grafo();
        System.out.println("Se va a usar el documento " + args[0]);
        prueba.leerArbolRR(args[0]);
        prueba.imprimir();
        Integer[] intentos = new Integer[prueba.obtenerIteraciones() + 1];
        int i = 0;
        int minimoCorte = 0;


        for (i = 0; i < prueba.obtenerIteraciones() - 1; i++)
        
        {
            intentos[i] = prueba.crearDisputas();
        }
        
        minimoCorte = intentos[0];
        
        // 5) Esto se repite tantas veces como iteraciones se hayan
        // especificado y se toma la menor        

        for (i = 1; i < prueba.obtenerIteraciones() - 1; i++)

        {        
            if (intentos[i] < minimoCorte)
            {                    
                minimoCorte = intentos[i];        
            }            
        }
        System.out.println("El minimo numero de cortes es " + minimoCorte);
    }            
}
