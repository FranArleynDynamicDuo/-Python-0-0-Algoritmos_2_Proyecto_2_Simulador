/*
 * Arleyn Goncalves
 * Francisco Sucre
 * Proyecto 2 De Laboratorio Algoritmos 3
 * Alicia
 * Clase ColaSAleatorizadas
 */

package reinaroja;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/*
  Implementacion del TAD ColaAleatorizadas
*/

public class ColaAleatorizada 

{
    
    // STATES
    
    private ArrayList<Arista> elementos_; // Elementos de la cola
    
    // CONSTRUCTORS
    
    public ColaAleatorizada()
      
        // Constructor que inicializa la cola
            
    {
    
        elementos_ = new ArrayList<Arista>();
    }
    
    // SETTERS
    
    public ColaAleatorizada insertar(Arista entrada)
            
        // Metodo que agrega un elemento a la cola
            
    {   
        elementos_.add(entrada);
        return this;       
    }

        // Metodo que agrega varios elementos a la cola    
    
    public ColaAleatorizada insertarVarios(HashSet<Arista> entrada)
            
    {
        elementos_.addAll(entrada); // Añadimos el elemento a la cola
        return this;       
    }    

    public Arista extraerAzar()
    
        // Metodo que obtiene un elemento al azar de la cola y lo "remueve",
        // sin cambiar las probabilidades de ser extraidos de los otros
        // elementos
            
    {
        Boolean exitoso = false; // Booleano que nos indicara si logramos 
                                 // extraer un elemento que no se habia
                                 // extraido antes
        Random azar = new Random(); // Generador de numeros al "azar"
        Integer salidaIndice = 0; 
        Arista extraida = new Arista(0);
        
        while (exitoso.equals(false)) // Elegimos elementos hasta conseguir uno
                                      // que no se haya extraido antes
        {           
        salidaIndice = azar.nextInt(elementos_.size()); // Generamos un numero
            if (elementos_.get(salidaIndice) != null)
            {
                extraida = elementos_.get(salidaIndice); // Guardamos el
                                                         // elemento
                elementos_.set(salidaIndice, null);      // Lo extraemos
                exitoso = true; // Marcamos que fue exitosa la extraccion
            }
        }       
        return extraida;
    }    

    public Arista extraer(Arista salida)
            
            // Metodo que extrae un elemento seleccionado de la cola
            
    {         
        Arista extraida = new Arista(0);
        extraida = elementos_.get(elementos_.indexOf(salida)); // Guardamos el
                                                               // elemento
        elementos_.set(elementos_.indexOf(salida),null); // Lo extraemos
        return salida;  
    }      
    
    // GETTERS
    
    public boolean vacio()
    
            // Metodo que comprueba si la cola esta "vacia", es decir si ya 
            // todos sus elementos fueron extraidos
            
    {
        Boolean verificacion; // Booleano que usaremos para comprobar que todas
                              // posiciones fueron extraidas
        verificacion = true;

        for (Arista cosa : elementos_) // Recorremos la cola
        {
            verificacion = (cosa == null); // Verificamos que todos los
                                           // elementos hayan sido extraidos
            if (verificacion == false)
            {
                break; // Rompemos el ciclo al encontrar una posicion no
                       // extraida
            }   
        }
        
        return verificacion;
    }
    
    public ArrayList<Arista> obtenerElementos()
            
            // Metodo que obtiene los elementos de la cola
    
    {
        return elementos_;
    }
    
}
