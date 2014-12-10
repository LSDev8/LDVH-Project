package tests;

import static org.junit.Assert.*;
import interfaces.IObjets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

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
		/*
		 * Teste de manière fictive l'ajout d'un ensemble d'objets, on ne
		 * manipule que des index, qui ici ne correspondent pas à des Objets
		 * ayant été créés.
		 */
		Random r = new Random();
		ArrayList<Integer> listObjets = new ArrayList<>();
		Integer id;
		
		listObjets.add(r.nextInt());
		listObjets.add(r.nextInt());
		listObjets.add(r.nextInt());
		id = l.ajouterSectionAvecEnsembleObjets("Test Objets", listObjets);
		
		//On vérifie que les ajouts sont effectifs
		assert(listObjets.equals(l.getListeObjetsSection(id)));
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
