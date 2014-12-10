package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import livre.Livre;

import org.junit.Before;
import org.junit.Test;

public class EnchainementTest {

	private Livre l;
	private String titre = "none", chemin = "/tmp/newLivre";
	
	@Before
	public void setUp() throws Exception {
		l = new Livre(titre, chemin);
	}

	@Test
	public void testCreerEnchainement(){
		String testS = "enchainement 1";
		Integer idSectionA, idSectionB;
		idSectionA = l.ajouterSection("Section 1");
		idSectionB = l.ajouterSection("Section 2");
		Integer idEnchainement = l.creerEnchainement(idSectionA, idSectionB, testS);

		assert(l.getTextEnchainement(idEnchainement).equals(testS));
	}
	
	@Test
	public void testSupprimerEnchainement(){
		int ancientSize;
		ArrayList<Integer> list;
		Integer idSectionA, idSectionB, idEnchainement;
		String texteA = "Le titre de A", texteB = "Le titre de B";
		String textEnchainement = "Je passe de A vers B!";

		ancientSize = l.getListeEnchainement().size();

		idSectionA = l.ajouterSection(texteA);
		idSectionB = l.ajouterSection(texteB);

		idEnchainement = l.creerEnchainement(idSectionA, idSectionB, textEnchainement);
		
		this.l.supprimerEnchainement(idEnchainement);
		assert(this.l.getListeEnchainement().size()==0);
	}
	
	@Test
	public void testModifierTextEnchainement(){
		String testS = "enchainement 1";
		Integer idSectionA, idSectionB;
		idSectionA = l.ajouterSection("Section 1");
		idSectionB = l.ajouterSection("Section 2");
		Integer idEnchainement = l.creerEnchainement(idSectionA, idSectionB, testS);
		
		l.modifierTextEnchainement(idEnchainement, "enchainement 2");
		
		assert(l.getTextEnchainement(idEnchainement).equals("enchainemnt 2"));
	}
	
	@Test
	public void testGetTextEnchainement(){
		String testS = "enchainement 1";
		Integer idSectionA, idSectionB;
		idSectionA = l.ajouterSection("Section 1");
		idSectionB = l.ajouterSection("Section 2");
		Integer idEnchainement = l.creerEnchainement(idSectionA, idSectionB, testS);
		
		assert(l.getTextEnchainement(idEnchainement).equals("enchainemnt 1"));
	}
	
	@Test
	public void testSetSourceEnchainement(){
		String testS = "enchainement 1";
		Integer idSectionA, idSectionB, idSectionC;
		idSectionA = l.ajouterSection("Section 1");
		idSectionB = l.ajouterSection("Section 2");
		idSectionC = l.ajouterSection("Section 3");
		Integer idEnchainement = l.creerEnchainement(idSectionA, idSectionB, testS);
	
		l.setSourceEnchainement(idEnchainement, idSectionC);
		
		assert(l.getIdSourceEnchainement(idEnchainement) == idSectionC);
	}
	
	@Test
	public void testSetDestinationEnchainement(){
		String testS = "enchainement 1";
		Integer idSectionA, idSectionB, idSectionC;
		idSectionA = l.ajouterSection("Section 1");
		idSectionB = l.ajouterSection("Section 2");
		idSectionC = l.ajouterSection("Section 3");
		Integer idEnchainement = l.creerEnchainement(idSectionA, idSectionB, testS);
	
		l.setDestinationEnchainement(idEnchainement, idSectionC);
		
		assert(l.getIdDestEnchainement(idEnchainement) == idSectionC);
	}
	
	@Test
	public void testGetIdSourceEnchainement(){
		String testS = "enchainement 1";
		Integer idSectionA, idSectionB;
		idSectionA = l.ajouterSection("Section 1");
		idSectionB = l.ajouterSection("Section 2");
		Integer idEnchainement = l.creerEnchainement(idSectionA, idSectionB, testS);
		
		assert(l.getIdSourceEnchainement(idSectionB) == idSectionA);
	}
	
	@Test
	public void testGetIdDestEnchainement(){
		String testS = "enchainement 1";
		Integer idSectionA, idSectionB;
		idSectionA = l.ajouterSection("Section 1");
		idSectionB = l.ajouterSection("Section 2");
		Integer idEnchainement = l.creerEnchainement(idSectionA, idSectionB, testS);
		
		assert(l.getIdDestEnchainement(idSectionA) == idSectionB);
	}
}
