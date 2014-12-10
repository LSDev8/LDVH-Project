package interfaces;

import java.io.IOException;

import controleur.Controleur;
import objets.Objets;
import livre.Livre;

public class ComposantFactory {

	public static ILivre createLivre(String nom, String chemin) throws IOException {
		return new Livre(nom, chemin);
	}

	public static ILivre createLivre(String chemin) throws IOException {
		return new Livre(chemin);
	}
	
	public static IObjets createObjets() {
		return new Objets();
	}

	public static IControleur createControleur() {
		return new Controleur();
	}

	
}
