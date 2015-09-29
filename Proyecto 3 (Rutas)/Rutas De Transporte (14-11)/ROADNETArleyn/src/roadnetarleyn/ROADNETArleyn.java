
package roadnetarleyn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ROADNETArleyn 

{
    public static void main(String[] args) throws FileNotFoundException,
            IOException 
            
    {
        Integer numPruebas;
        Integer numCiudades;
        Integer linea = 0;
        Integer [][] Matriz;
        Boolean check = false;
        File file = new File (args[0]);
        FileReader fileReader = new FileReader(file);
        
            try (BufferedReader in = new BufferedReader(fileReader)) 
                
            {
                String s;
                String[] palabras;
                
                s = in.readLine();
                palabras = s.split(" ");
                numPruebas = (new Integer(palabras[0]));
                
                s = in.readLine();
                palabras = s.split(" ");
                numCiudades = (new Integer(palabras[0]));
                
                linea = 0;
                Matriz = (new Integer[numCiudades][numCiudades]); 
     
                while ((linea < numCiudades))
                {
                int i = 0;
                int j = 0;
                int k;
                int columna;
                int fila;

                for (i = 0; i < numCiudades; i++)
                {
                    
                s = in.readLine();
                palabras = s.split(" ");
                    
                    for (j = 0; j < numCiudades; j++)
                        {
                        Matriz[i][j] = (new Integer(palabras[j]));
                        linea = linea + 1;
                        }
                }
                 
                for(fila = 0; fila < numCiudades ; fila++)
                {
                    for(columna = 0; columna < numCiudades ;columna ++)
                    {     
                       for (k = 0 ; k < numCiudades ; k++)
                       {
                            if (Matriz[columna][k] >= Matriz[columna][fila] + Matriz[fila][k])

                            {
                                Matriz[columna][k] = Matriz[columna][fila] + Matriz[fila][k];

                                if  ((Matriz[columna][k] == columna) && (columna != fila))
                                {
                                    System.out.println((fila+1) + " " + (columna+1));
                                }
                                
                            }
            
                     }
                       
                       
                }
                    
                }
                    
                }

            }
}
}