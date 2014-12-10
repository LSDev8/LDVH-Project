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

}
