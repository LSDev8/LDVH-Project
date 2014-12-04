package livre;

import java.util.ArrayList;
import java.util.Collection;

import exceptions.UnknownObjetException;

//TODO: Définir une interface ISection
public class Section {

	private Integer id;
	private String text;
	private ArrayList<Integer> idObjets;

	public Section(Integer n) {
		idObjets = new ArrayList<>();
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

	public void removeObjet(Integer idObj) throws UnknownObjetException {
		idObjets.remove(idObj);
	}

	public void addObjet(Integer idObj) {
		idObjets.add(idObj);
	}
	
	public Collection<Integer> getObjets() {
			return idObjets;
	}

}
