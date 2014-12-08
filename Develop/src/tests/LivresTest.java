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
	public void setUp() {
		l = new Livre();
		try {
			l.creerLivre(titre, chemin);
		} catch (IOException | NamingException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			assert (false);
		}
	}

	@Test
	public void testTitre() {
		assert (l.getTitre() == titre);
		l.setTitre("Aventure");
		assert (l.getTitre() == "Aventure");
		titre = "Aventure";
	}

	@Test
	public void testAjouterSectionText() {
		Integer idSection = l.ajouterSection("Une page");
		assert (l.getTextSection(idSection) == "Une page");
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

	@Test
	public void testAjoutEnchainement() {
		int ancientSize;
		ArrayList<Integer> list;
		Integer idSectionA, idSectionB, idEnchainement;
		String texteA = "Le titre de A", texteB = "Le titre de B";
		String textEnchainement = "Je passe de A vers B!";

		ancientSize = l.getListeEnchainement().size();

		idSectionA = l.ajouterSection(texteA);
		idSectionB = l.ajouterSection(texteB);

		idEnchainement = l.creerEnchainement(idSectionA, idSectionB,
				textEnchainement);
		assert (l.getListeSection().size() == ancientSize + 1);

		list = (ArrayList<Integer>) l.getListeEnchainement();
		for (Integer i : list)
			if (i == idEnchainement)
				assert (l.getTextEnchainement(i) == textEnchainement);

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
	public void testAjouterObjetEnchainement() {
		final String texteSectA = "Titre section A";
		final String texteSectB = "Titre section B";
		final String texteEnchainement = "Je passe de A vers B!";
		final String texteObj = "clef";

		Integer idSectionA, idSectionB, idEnchainement, idObj;
		IObjets o;
		Collection<Integer> objsEnch;

		o = new Objets();
		idObj = o.ajouterObjet(texteObj);

		idSectionA = this.l.ajouterSection(texteSectA);
		idSectionB = this.l.ajouterSection(texteSectB);

		idEnchainement = this.l.creerEnchainement(idSectionA, idSectionB,
				texteEnchainement);

		this.l.ajouterObjetEnchainement(idEnchainement, idObj);

		objsEnch = this.l.getListeObjetsEnchainement();

		assert (objsEnch.size() == 1);
		assert (objsEnch.contains(idObj));
	}

	@Test
	public void testSupprimerObjetEnchainement() {
		final String texteSectA = "Titre section A";
		final String texteSectB = "Titre section B";
		final String texteEnchainement = "Je passe de A vers B!";
		final String texteObj = "clef";

		Integer idSectionA, idSectionB, idEnchainement, idObj;
		IObjets o;
		Collection<Integer> objsEnch;

		o = new Objets();
		idObj = o.ajouterObjet(texteObj);

		idSectionA = this.l.ajouterSection(texteSectA);
		idSectionB = this.l.ajouterSection(texteSectB);

		idEnchainement = this.l.creerEnchainement(
				idSectionA, 
				idSectionB,
				texteEnchainement
		);

		this.l.ajouterObjetEnchainement(idEnchainement, idObj);
		this.l.supprimerObjetEnchainement(idEnchainement, idObj);

		assert (this.l.getListeObjetsEnchainement().size() == 0);

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
	public void testSupprimerSection(){
		final String texteSect = "Titre section";
		
		this.l.supprimerSection(this.l.ajouterSection(texteSect));
		assert(this.l.getListeSection().size()==0);
	}
	
	@Test
	public void testSupprimerEnchainemet(){
		int ancientSize;
		ArrayList<Integer> list;
		Integer idSectionA, idSectionB, idEnchainement;
		String texteA = "Le titre de A", texteB = "Le titre de B";
		String textEnchainement = "Je passe de A vers B!";

		ancientSize = l.getListeEnchainement().size();

		idSectionA = l.ajouterSection(texteA);
		idSectionB = l.ajouterSection(texteB);

		idEnchainement = l.creerEnchainement(idSectionA, idSectionB,
				textEnchainement);
		

		this.l.supp
		list = (ArrayList<Integer>) l.getListeEnchainement();
		

}
