package tests;

import static org.junit.Assert.*;
import interfaces.IObjets;

import java.io.IOException;
import java.util.Collection;

import javax.naming.NamingException;

import livre.Livre;
import objets.Objets;

import org.junit.Before;
import org.junit.Test;

import exceptions.UnknownObjetException;

public class SectionsTest {

	private Livre l;
	private String titre = "none", chemin = "/tmp/newLivre";

	@Before
	public void setUp() throws Exception {
		l = new Livre(titre, chemin);
	}

	@Test
	public void testAjouterSection() {
		Integer idSection = l.ajouterSection("Une page");
		assert (l.getTextSection(idSection) == "Une page");
	}

	@Test
	public void testAjouterSectionEns() {
		fail("A faire");
	}

	@Test
	public void testModifierTextSection() {
		Integer idSection = l.ajouterSection("Une page");
		l.modifierTextSection(idSection, "coucou");
		assert(l.getTextSection(idSection) == "coucou");
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
	public void testSupprimerSection() {
		final String texteSect = "Titre section";

		this.l.supprimerSection(this.l.ajouterSection(texteSect));
		assert (this.l.getListeSection().size() == 0);
	}

	@Test
	public void testGetTextSection() {
		Integer idSection = l.ajouterSection("Une page");
		assert(l.getTextSection(idSection) == "Une page");
	}

	@Test
	public void testGetListeObjetsSection() {
		fail("A faire");
	}
}
