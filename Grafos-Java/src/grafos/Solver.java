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
	private Set<Integer> _incumbente;
	
	public Set<Integer> resolver()
	{
		_generados = 0;
		_incumbente = new HashSet<Integer>();

		Set<Integer> vacio = new HashSet<Integer>();
		recursion(0, vacio);
		
		return _incumbente;

	}
	
	private void recursion(int actual, Set<Integer> conjunto)
	{
		// Caso base
		if( actual == _grafo.vertices() )
		{
			// Caso base
						if( _grafo.esClique(conjunto) && conjunto.size() > _incumbente.size() )
							_incumbente = new HashSet<Integer>(conjunto);

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
	
	private static void mostrar(Set<Integer> conjunto)
	{
		System.out.print("{ ");
		
		for(Integer v: conjunto)
			System.out.print(v + " ");

		System.out.println("}");
	}
	
	public static void main(String[] args)
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(3, 4);
		grafo.agregarArista(2, 3);
		grafo.agregarArista(2, 4);

		
		maxClique.Solver solver = new Solver(grafo);
		Set<Integer> maxClique = solver.resolver();
		mostrar(maxClique);
		
		System.out.println("Subconjuntos generados: " + solver.cantidadGenerada());
	}
	
}

