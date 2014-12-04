package tests;

import static org.junit.Assert.*;
import interfaces.IObjets;

import java.util.ArrayList;

import objets.Objets;

import org.junit.Before;
import org.junit.Test;

public class ArrayObjetsTest {

	Integer i;

	protected IObjets obs1;

	@Before
	public void setUp() {
		obs1 = new Objets();
		i = obs1.creationObjet("sword");
		obs1.creationObjet("sword2");
	}

	@Test
	public void testcreationObjet() {
		assertTrue(obs1.creationObjet("key") != 0);
	}

	@Test
	public void testgetNomObjet() {
		int i = obs1.creationObjet("sword");
		assertTrue(i != 0);
		assertEquals("sword", obs1.getNomObjet(i));
	}

	@Test
	public void testsetNomObjet() {
		i = obs1.creationObjet("sword2");

		obs1.setNomObjet(i, "key");
		assertEquals("key", obs1.getNomObjet(i));
	}

	@Test
	public void testsupprimerObjet() {
		int sa = obs1.size();
		obs1.supprimerObjet(1);
		assertTrue(obs1.size() == sa - 1);
	}
	
	@Test
	public void testgetObjets() {
		assertTrue(obs1.getObjets() instanceof ArrayList<?>);
	}
}
