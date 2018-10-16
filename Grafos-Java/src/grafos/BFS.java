package grafos;

import java.util.Set;

public class BFS {

	public static boolean esConexo(Grafo g) {
		if( g == null) throw new IllegalArgumentException("Es grafo es null");
		
		if( g.vertices() == 0) return true;
		
		return alcanzables(g,0).size() == g.vertices();	
	}
	
	static Set<Integer> alcanzables(Grafo g, int origen){
		throw new RuntimeException("no implementado");
	}
}
