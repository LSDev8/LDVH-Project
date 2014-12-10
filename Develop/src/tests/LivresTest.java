package tests;

import interfaces.IObjets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.NamingException;

import livre.Livre;
import objets.Objets;

import org.junit.Before;
import org.junit.Test;

public class LivresTest {

	private Livre l;
	private String titre = "none", chemin = "/tmp/newLivre";

	@Before
	public void setUp() throws IOException {
		l = new Livre(titre,chemin);
	}

	@Test
	public void testTitre() {
		assert (l.getTitre() == titre);
		l.setTitre("Aventure");
		assert (l.getTitre() == "Aventure");
		titre = "Aventure";
	}

	
	@Test
	public void testAjoutSectionMultiple() {
		int ancientSize;
		ArrayList<Integer> list;
		Integer idSectionA, idSectionB;
		String texteA = "Le titre de A", texteB = "Le titre de B";

		ancientSize = l.getListeSection().size();

		idSectionA = l.ajouterSection(texteA);
		idSectionB = l.ajouterSection(texteB);

		assert (l.getTextSection(idSectionA) == texteA);
		assert (l.getTextSection(idSectionB) == texteB);

		list = (ArrayList<Integer>) l.getListeSection();
		assert (list.size() == ancientSize + 2);

		for (Integer i : list) {
			if (i == idSectionA)
				assert (l.getTextSection(idSectionA) == texteA);
			if (i == idSectionB)
				assert (l.getTextSection(idSectionA) == texteB);
		}

		// Le identifiants sont toujours valables
		l.supprimerSection(idSectionA);
		assert (l.getListeSection().size() == ancientSize + 1);
		assert (l.getTextSection(idSectionA) == texteB);

	}	
}
