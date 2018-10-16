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
			Set<Integer> set = new HashSet<Integer>();
			set.add(2);
			assertTrue(g.esClique(set));
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void verticeNegativoTest() {
			Grafo g = new Grafo(5);
			Set<Integer> set = new HashSet<Integer>();
			set.add(-1);
			assertFalse(g.esClique(set));
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void verticeExcedidoTest() {
			Grafo g = new Grafo(5);
			Set<Integer> set = new HashSet<Integer>();
			set.add(5);
			g.esClique(set);
		}
		
		@Test //(expected = IllegalArgumentException.class)
		public void dosNoVecinosTest() {
			Grafo g = new Grafo(5);
			Set<Integer> set = new HashSet<Integer>();
			set.add(3);
			set.add(4);
			g.esClique(set);
		}
		
		@Test
		public void dosVecinosTest()
		{
			Grafo grafo = K4ConAntena();
			
			Set<Integer> set = new HashSet<Integer>();
			set.add(3);
			set.add(2);
			
			assertTrue( grafo.esClique(set) );
		}
		
		@Test
		public void casiTrianguloTest()
		{
			Grafo grafo = K4ConAntena();
			
			Set<Integer> set = new HashSet<Integer>();
			set.add(2);
			set.add(3);
			set.add(4);
			
			assertFalse( grafo.esClique(set) );
		}
		
		@Test
		public void cliqueDe4Test()
		{
			Grafo grafo = K4ConAntena();
			
			Set<Integer> set = new HashSet<Integer>();
			set.add(0);
			set.add(2);
			set.add(3);
			set.add(1);
			
			assertTrue( grafo.esClique(set) );
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

}
