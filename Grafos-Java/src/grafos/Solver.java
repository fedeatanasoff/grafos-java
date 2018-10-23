package grafos;

import java.util.HashSet;
import java.util.Set;

public class Solver
{
	private Grafo _grafo;
	
	public Solver(Grafo grafo)
	{
		_grafo = grafo;
	}
	
	private int _generados;
	
	public void generarTodosLosSubconjuntosDeVertices()
	{
		_generados = 0;
		Set<Integer> vacio = new HashSet<Integer>();
		recursion(0, vacio);
	}
	
	private void recursion(int actual, Set<Integer> conjunto)
	{
		// Caso base
		if( actual == _grafo.vertices() )
		{
			mostrar(conjunto);
			_generados++;
		}
		else
		{
			// Caso recursivo
			conjunto.add(actual);
			recursion(actual+1, conjunto);
			
			conjunto.remove(actual);
			recursion(actual+1, conjunto);
		}
	}
	
	public int cantidadGenerada()
	{
		return _generados;
	}
	
	private void mostrar(Set<Integer> conjunto)
	{
		System.out.print("{ ");
		
		for(Integer v: conjunto)
			System.out.print(v + " ");

		System.out.println("}");
	}
	
	public static void main(String[] args)
	{
		Grafo grafo = new Grafo(16);
		
		Solver solver = new Solver(grafo);
		solver.generarTodosLosSubconjuntosDeVertices();
		
		System.out.println("Subconjuntos generados: " + solver.cantidadGenerada());
	}
	
}

