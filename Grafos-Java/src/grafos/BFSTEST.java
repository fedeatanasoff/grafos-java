package grafos;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class BFSTEST {

	@Test(expected = IllegalArgumentException.class)
	public void conexoNull() {
		BFS.esConexo(null);
	}
	
	@Test
	public void conexoVacioTest() {
		Grafo g = new Grafo(0);
		assertTrue(BFS.esConexo(g));
	}
	
	@Test
	public void noEsConexo() {
		Grafo g = cuadradoMasArista();
		assertFalse(BFS.esConexo(g));		
		
	}
	
	@Test
	public void conexoTest() {
		Grafo g = cuadradoMasArista();
		g.agregarArista(1, 4);
		assertTrue(BFS.esConexo(g));
	}
	
	private Grafo cuadradoMasArista()
	{
		Grafo ret = new Grafo(6);
		ret.agregarArista(0, 1);
		ret.agregarArista(0, 2);
		ret.agregarArista(2, 3);
		ret.agregarArista(3, 1);
		ret.agregarArista(4, 5);
		
		return ret;
	}
	
	@Test
	public void alcanzablesTest()
	{
		Grafo grafo = cuadradoMasArista();
		Set<Integer> cuadrado = BFS.alcanzables(grafo, 1);
		
		int[] esperado = {0, 1, 2, 3};
		Assert.iguales(esperado, cuadrado);
	}
	
	@Test
	public void todosalcanzablesTest()
	{
		Grafo grafo = cuadradoMasArista();
		grafo.agregarArista(1, 5);
		Set<Integer> todos = BFS.alcanzables(grafo, 1);
		
		int[] esperado = {0, 1, 2, 3, 4, 5};
		Assert.iguales(esperado, todos);
	}

	@Test
	public void alcanzableAisladoTest()
	{
		Grafo grafo = cuadradoMasArista();
		grafo.eliminarArista(4, 5);
		Set<Integer> cuatro = BFS.alcanzables(grafo, 4);
		
		int[] esperado = { 4 };
		Assert.iguales(esperado, cuatro);
	}




}
