package grafos;

import java.util.ArrayList;
import java.util.Set;

public class BFS {

	public static boolean esConexo(Grafo g) {
		if( g == null) throw new IllegalArgumentException("Es grafo es null");
		
		if( g.vertices() == 0) return true;
		
		return alcanzables(g,0).size() == g.vertices();	
	}
	
	static Set<Integer> alcanzables(Grafo g, int origen) {
		inicializar(g, origen);

		while (L.size() > 0) {
			return marcados();

		}
	}
	private static void inicializar(Grafo grafo, int origen) 
	{
		//Los vrtices pendientes de visitar
		L = new ArrayList<Integer>();
		L.add(origen);
		
		//Los vrtices visitados
		marcados = new boolean[grafo.vertices()];	
	}

}
