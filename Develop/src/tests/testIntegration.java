package tests;

import static org.junit.Assert.*;
import interfaces.IObjets;

import java.util.Collection;

import livre.Livre;
import objets.Objets;

import org.junit.Before;
import org.junit.Test;

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

		idSect = this.l.ajouterSection(texteSect);

		this.l.ajouterObjetSection(idSect, idObj);
		objsSect = this.l.getListeObjetsSection(idSect);

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

		idSect = this.l.ajouterSection(texteSect);

		this.l.ajouterObjetSection(idSect, idObj);
		this.l.supprimerObjetSection(idSect, idObj);

		assert (this.l.getListeObjetsSection(idSect).size() == 0);
	}

	@Test
	public void testGetListeObjetsSection() {
		fail("A faire");
	}
	
	@Test
	public void testGetListeObjetsEnchainement(){
		fail("A faire");
	}
		
	@Test
	public void testAjouterObjetEnchainement(){
		fail("A faire");
	}
	
	@Test
	public void testSupprimerObjetEnchainement(){
		fail("A faire");
	}
}
