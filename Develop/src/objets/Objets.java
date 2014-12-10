package objets;

import interfaces.IObjets;

import java.util.ArrayList;
import java.util.Collection;

public class Objets extends ArrayList<Objet> implements IObjets {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8453940332587040685L;
	private int compteur = 0;

	public void createObjets(IObjets o) {
		if (this == o)
		    throw new IllegalArgumentException("Copie récursive non autorisée");
		for (Objet e : o)
			ajouterObjet(e.getNom());
	}

	public Integer ajouterObjet(String nom) {
		Objet o = new Objet(compteur, nom);
		add(compteur, o);
		return compteur++;
	}

	@Override
	public String getNomObjet(Integer id) {
		return get(id).getNom();
	}

	@Override
	public void setNomObjet(Integer id, String nom) {
		get(id).setNom(nom);
	}

	@Override
	public void supprimerObjet(Integer id) {
		remove(get(id));
	}

	public ArrayList<Objet> getObjets() {
		return this;
	}

	@Override
	public Collection<Integer> getListeObjets() {
		ArrayList<Integer> l = new ArrayList<>();

		for (Objet o : this)
			l.add(o.getId());

		return l;
	}

}
