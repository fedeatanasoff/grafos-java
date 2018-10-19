package grafos;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class Assert {

	public static void iguales(int[] esperado, Set<Integer> obtenido) {
		assertEquals(esperado.length, obtenido.size());

		for (Integer elemento : esperado)
			assertTrue(obtenido.contains(elemento));

	}

}
