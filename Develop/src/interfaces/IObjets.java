package interfaces;

import java.util.Collection;

import objets.Objet;

public interface IObjets extends Collection<Objet> {

	public Integer ajouterObjet(String nom);

	public String getNomObjet(Integer id);

	public void setNomObjet(Integer id, String nom);

	public void supprimerObjet(Integer id);

	public Collection<Integer> getListeObjets();

}
