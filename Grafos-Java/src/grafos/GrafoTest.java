package grafos;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrafoTest {

		@Test()
		public void agregarAristaTest() {
			Grafo g = new Grafo(5);
			g.agregarArista(1, 2);
			assertTrue(g.existeArista(1,2));
		}
		
		@Test
		public void aristaSimetricaTest() {
			Grafo g = new Grafo(5);
			g.agregarArista(1, 2);
			assertTrue(g.existeArista(2, 1));
		}
		
		@Test
		public void eliminarAristaTest() {
			Grafo g = new Grafo(5);
			g.agregarArista(1, 2);
			g.eliminarArista(1, 2);
			assertFalse(g.existeArista(1, 2));
		}
		
		@Test
		public void eliminarSimetricaTest() {
			Grafo g = new Grafo(5);
			g.agregarArista(1, 2);
			g.eliminarArista(1, 2);
			assertFalse(g.existeArista(2, 1));
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void primeroNegativoTest() {
			Grafo g = new Grafo(5);
			g.agregarArista(-1, 2);
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void primeroExcedido() {
			Grafo g = new Grafo(5);
			g.agregarArista(7, 2);
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void segundoNegativoTest() {
			Grafo g = new Grafo(5);
			g.agregarArista(1, -2);
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void segundooExcedido() {
			Grafo g = new Grafo(5);
			g.agregarArista(2, 12);
		}
		
		@Test(expected =IllegalArgumentException.class)
		public void verticesIgualesTest() {
			Grafo g = new Grafo(5);
			g.agregarArista(2, 2);
		}
		

}
