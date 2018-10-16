package grafos;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

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
		
		@Test(expected = IllegalArgumentException.class)
		public void conjuntoNuloTest() {
			Grafo g = new Grafo(5);
			g.esClique(null);			
		}
		
		@Test
		public void cliqueVaciaTest() {
			Grafo g = new Grafo(5);
			Set<Integer> set = new HashSet<Integer>();
			assertTrue(g.esClique(set));
		}
		
		@Test
		public void cliqueUnitarioTest() {
			Grafo g = new Grafo(5);
			int[] vertices = { 2 };
			assertTrue( g.esClique( toSet(vertices) ) );
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void verticeNegativoTest() {
			Grafo g = new Grafo(5);
			int[] vertices = { -1 };
			g.esClique( toSet(vertices) );

		}
		
		@Test(expected = IllegalArgumentException.class)
		public void verticeExcedidoTest() {
			Grafo g = new Grafo(5);
			int[] vertices = { 5 };
			g.esClique( toSet(vertices) );

		}
		
		@Test //(expected = IllegalArgumentException.class)
		public void dosNoVecinosTest() {
			Grafo g = new Grafo(5);
			int[] vertices = { 3, 4 };
			assertFalse( g.esClique( toSet(vertices) ) );

		}
		
		@Test
		public void dosVecinosTest()
		{
			Grafo grafo = K4ConAntena();			
			int[] vertices = { 2, 3 };
			assertTrue( grafo.esClique( toSet(vertices) ) );

		}
		
		@Test
		public void casiTrianguloTest()
		{
			Grafo grafo = K4ConAntena();
			int[] vertices = { 2, 3, 4 };
			assertFalse( grafo.esClique( toSet(vertices) ) );

		}
		
		@Test
		public void cliqueDe4Test()
		{
			Grafo grafo = K4ConAntena();
			int[] vertices = { 0, 1, 2, 3 };
			assertTrue( grafo.esClique( toSet(vertices) ) );

		}

		private Grafo K4ConAntena()
		{
			Grafo ret = new Grafo(5);
			ret.agregarArista(0, 1);
			ret.agregarArista(0, 2);
			ret.agregarArista(0, 3);
			ret.agregarArista(1, 2);
			ret.agregarArista(1, 3);
			ret.agregarArista(2, 3);
			ret.agregarArista(2, 4);
			
			return ret;
		}
		
		private Set<Integer> toSet(int[] arreglo)
		{
			Set<Integer> ret = new HashSet<Integer>();
			for(int i=0; i<arreglo.length; ++i)
				ret.add( arreglo[i] );
			
			return ret;
		}


}
