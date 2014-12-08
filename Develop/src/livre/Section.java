package livre;

import java.util.ArrayList;
import java.util.Collection;

import exceptions.UnknownObjetException;

//TODO: Définir une interface ISection
public class Section {

	private Integer id;
	private String text;
	private ArrayList<Integer> idObjets;
	/**
	 * La liste des echainements du livre dont cette section est la source
	 * Pour pouvoir plus facilement parcourir le graphe
	 */
	private ArrayList<Integer> idEnchSrc;
  
	public Section(Integer n) {
		idObjets = new ArrayList<>();
		id = n;
	}
	
	//Nécessaire pour respecter l'unicité des IDs malgré les 
	//suppressions.
	public void setID(Integer id){
		this.id = id;
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

	public void removeObjet(Integer idObj) {
		idObjets.remove(idObj);
	}

	public void addObjet(Integer idObj) {
		idObjets.add(idObj);
	}
	
	public Collection<Integer> getObjets() {
			return idObjets;
	}

}
