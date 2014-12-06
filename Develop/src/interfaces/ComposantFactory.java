package interfaces;

import objets.Objets;
import livre.Livre;

public class ComposantFactory {

	public static ILivre createLivre() {
		return new Livre();
	}
	
	public static IObjets createObjets() {
		return new Objets();
	}
	
}
