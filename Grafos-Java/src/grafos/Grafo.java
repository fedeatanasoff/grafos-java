package grafos;

import java.util.HashSet;
import java.util.Set;

public class Grafo {
	
	private boolean[][] _ady;
	
	public Grafo(int vertices) {
		this._ady = new boolean[vertices][vertices];
	}
	
	public void agregarArista(int i, int j) {
		
		verificarArista(i, j);		
		
		this._ady[i][j] = true;
		this._ady[j][i] = true;
	}
	
	public void eliminarArista(int i, int j) {
		this._ady[i][j] = false;
		this._ady[j][i] = false;
	}
	
	public boolean existeArista(int i, int j) {
		return this._ady[i][j];
	}
	
	public int vertices() {
		return this._ady.length;
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
		int grado = 0;
		for (int j = 0; j < vertices(); j++) {
			if (this._ady[i][j] == true) {
				++grado;
			}
		}
		return grado;
	}
	
	public Set<Integer> vecinos(int i){
		verificarVertice(i);
		
		Set<Integer> vecinos = new HashSet<Integer>();
		for( int j=0; j < vertices(); j++) {
			if (this._ady[i][j])
				vecinos.add(j);
		}
		return vecinos;		
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
