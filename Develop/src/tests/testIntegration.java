package tests;

import static org.junit.Assert.*;
import interfaces.IObjets;

import java.util.Collection;

import livre.Livre;
import objets.Objets;

import org.junit.Before;
import org.junit.Test;

import exceptions.UnknownObjetException;

public class testIntegration {

	private Livre l;
	private String titre = "none", chemin = "/tmp/newLivre";

	@Before
	public void setUp() throws Exception {
		l = new Livre(titre, chemin);
	}

	@Test
	public void testAjouterObjetSection() {
		final String texteSect = "Titre section";
		final String nomObj = "clef";
		Integer idSect, idObj;
		Collection<Integer> objsSect;
		IObjets o;

		o = new Objets();
		idObj = o.ajouterObjet(nomObj);

		idSect = l.ajouterSection(texteSect);

		l.ajouterObjetSection(idSect, idObj);
		objsSect = l.getListeObjetsSection(idSect);

		assert (objsSect.size() == 1);
		assert (objsSect.contains(idObj));
	}

	@Test
	public void testSupprimerObjetSection() {
		final String texteSect = "Titre section";
		final String nomObj = "clef";
		Integer idSect, idObj;
		IObjets o;

		o = new Objets();
		idObj = o.ajouterObjet(nomObj);

		idSect = l.ajouterSection(texteSect);

		l.ajouterObjetSection(idSect, idObj);

		assert (l.getListeObjetsSection(idSect).size() == 1);

		try {
			l.supprimerObjetSection(idSect, idObj);
		} catch (UnknownObjetException e1) {
			assert (false);
		}

		assert (l.getListeObjetsSection(idSect).size() == 0);

		try {
			l.supprimerObjetSection(idSect, idObj);
			// Si la suppression fonctionne correctement, on ne doit pas
			// atteindre ce point
			assert (false);
		} catch (UnknownObjetException e) {
			//L'exception prévue a été lancée
			assert (true);
		}

	}

	@Test
	public void testGetListeObjetsSection() {
		fail("A faire");
	}

	@Test
	public void testGetListeObjetsEnchainement() {
		fail("A faire");
	}

	@Test
	public void testAjouterObjetEnchainement() {
		fail("A faire");
	}

	@Test
	public void testSupprimerObjetEnchainement() {
		fail("A faire");
	}
}
