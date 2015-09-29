/*
 * Arleyn Goncalves
 * Francisco Sucre
 * Proyecto 1 De Laboratorio Algoritmos 3
 * Servicio Secreto
 * Clase Main(Prueba)
 */
package main;
import java.util.HashSet;

public class Main 

{
  /* Nodo A (grafo de la figura 2). */
  private static final Nodo NODO_A = new Nodo("A");

  /* Nodo B (grafo de la figura 2). */
  private static final Nodo NODO_B = new Nodo("B");

  /* Nodo C (grafo de la figura 2). */
  private static final Nodo NODO_C = new Nodo("C");

  /* Nodo D (grafo de la figura 2). */
  private static final Nodo NODO_D = new Nodo("D");

  /* Nodo E (grafo de la figura 2). */
  private static final Nodo NODO_E = new Nodo("E");

  /** Grafo de la figura 2. */
  public static final Grafo GRAFO  = new Grafo();
  
  /* Constructor est�tico. */
  static
  {
    NODO_A.agregarAdyacente(NODO_B);
    NODO_A.agregarAdyacente(NODO_C);
    
    NODO_B.agregarAdyacente(NODO_A);
    NODO_B.agregarAdyacente(NODO_B);
    NODO_A.agregarAdyacente(NODO_B);
    
    NODO_C.agregarAdyacente(NODO_A);
    
    NODO_D.agregarAdyacente(NODO_E);
    
    NODO_E.agregarAdyacente(NODO_D);
    NODO_E.agregarAdyacente(NODO_E);
    
    GRAFO.agregarNodo(NODO_A);
    GRAFO.agregarNodo(NODO_B);
    GRAFO.agregarNodo(NODO_C);
    GRAFO.agregarNodo(NODO_D);
    GRAFO.agregarNodo(NODO_E);
  }
  
  /**
   * Programa principal
   * @param args Argumentos del sistema.
   */
  public static void main(String[] args)
  {
    System.out.println("Grafo:");
    GRAFO.imprimir();
    System.out.println("\nGrafo aplanado:");
    GRAFO.aplanarRed().imprimir();
    GRAFO.imprimir();
    System.out.println("\nNumero de cobertores: " + GRAFO.cobertores());
  }
}