package livre;

import interfaces.IObjet;
import exceptions.UnknownObjetException;
import objets.*;

//TODO: Définir une interface ISection
public class Section implements ISection {

	private Integer id;
	private String text;
	private Objets objets;

	public Section(Integer n) {
		objets = new Objets();
		id = n;
	}

	public Integer getID() {
		return id;
	}

	public void setText(String s) {
		text = s;
	}

	public String getText() {
		return text;
	}

	// J'ai pas trop compris l'implémentation de Benji
	// Donc dans le doute...
	public void removeObjet(Integer idObj) throws UnknownObjetException {
		boolean trouve = false;
		for (IObjet io : objets.getObjets()) {
			if (idObj = io.getId()) {
				objets.getObjets.remove(io);
				trouve = true;
				break;
			}
		}

		if (!trouve) {
			throw new UnknownObjetException();
		}
	}

	public void addObjet(Integer idObj) {

	}

}
