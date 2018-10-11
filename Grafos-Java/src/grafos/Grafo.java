package grafos;

public class Grafo {
	
	private boolean[][] _ady;
	
	public Grafo(int vertices) {
		this._ady = new boolean[vertices][vertices];
	}
	
	public void agregarArista(int i, int j) {
		
		if( i < 0 || i >= vertices() ) {
			throw new IllegalArgumentException("se intento agregar una arista con un vertice invalido! ("+i+")");
		}
		
		if( j < 0 || j >= vertices() ) {
			throw new IllegalArgumentException("se intento agregar una arista con un vertice invalido! ("+j+")");
		}
		
		if( i == j) {
			throw new IllegalArgumentException("se intento agregar una arista con dos vertices iguales!");
		}
		
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

}
