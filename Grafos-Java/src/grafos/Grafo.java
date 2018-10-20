package grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Grafo {
	
	private ArrayList<Set<Integer>> _vecinos;
	
	public Grafo(int vertices) {
		_vecinos = new ArrayList<Set<Integer>>(vertices);
		
		for(int i=0; i < vertices; i++) {
			_vecinos.add(new HashSet<Integer>());
		}
	}
	
	public void agregarArista(int i, int j) {
		
		verificarArista(i, j);		
		_vecinos.get(i).add(j);
		_vecinos.get(j).add(i);
	}
	
	public void eliminarArista(int i, int j) {
		_vecinos.get(i).remove(j);
		_vecinos.get(j).remove(i);
	}
	
	public boolean existeArista(int i, int j) {
		verificarArista(i, j);
		return _vecinos.get(i).contains(j);
	}
	
	public int vertices() {
		return _vecinos.size();
	}
	
	private void verificarArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
	}
	
	private void verificarVertice(int i) {
		if( i < 0 || i >= vertices() ) {
			throw new IllegalArgumentException("se intento agregar una arista con un vertice invalido! ("+i+")");
		}
	}
	
	private void verificarDistintos(int i, int j) {
		if( i == j) {
			throw new IllegalArgumentException("se intento agregar una arista con dos vertices iguales!");
		}
	}
	
	public int grado(int i) {
		verificarVertice(i);
		
		return _vecinos.get(i).size();
	}
	
	public Set<Integer> vecinos(int i){
		verificarVertice(i);
		return _vecinos.get(i);
	}

	public boolean esClique(Set<Integer> conjunto) {
		if(conjunto == null) {
			throw new IllegalArgumentException("el conjunto no puede ser nulo!");
		}
		
		for (Integer i : conjunto)
			verificarVertice(i);

		for (Integer i : conjunto)
			for (Integer j : conjunto)
				if (i != j) {
					if (existeArista(i, j) == false)
						return false;
				}		
		return true;
	}
}
