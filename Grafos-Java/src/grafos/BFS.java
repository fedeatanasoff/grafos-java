package grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFS {

	private static ArrayList<Integer> L;
	private static boolean[] marcados;

	public static boolean esConexo(Grafo g) {
		if (g == null)
			throw new IllegalArgumentException("Es grafo es null");

		if (g.vertices() == 0)
			return true;

		return alcanzables(g, 0).size() == g.vertices();
	}

	static Set<Integer> alcanzables(Grafo g, int origen) {
		inicializar(g, origen);

		while (L.size() > 0) {
			int i = L.get(0);
			marcados[i] = true;

			agregarVecinosPendientes(g, i);
			L.remove(0);
		}

		return marcados();
	}

	private static void inicializar(Grafo grafo, int origen) {
		// Los vrtices pendientes de visitar
		L = new ArrayList<Integer>();
		L.add(origen);

		// Los vrtices visitados
		marcados = new boolean[grafo.vertices()];
	}

	private static void agregarVecinosPendientes(Grafo grafo, int i) {
		for (Integer v : grafo.vecinos(i))
			if (marcados[v] == false && L.contains(v) == false)
				L.add(v);
	}

	private static Set<Integer> marcados() {
		Set<Integer> ret = new HashSet<Integer>();

		for (int i = 0; i < marcados.length; ++i)
			if (marcados[i] == true)
				ret.add(i);

		return ret;
	}
}
