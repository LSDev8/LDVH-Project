package interfaces;

import java.util.Collection;

import objets.Objet;

public interface IObjets extends Collection<Objet> {

	public Integer ajouterObjet(String nom);

	public String getNomObjet(Integer id);

	public void setNomObjet(Integer id, String nom);

	/**
	 * 
	 * @param id
	 */
	public void supprimerObjet(Integer id);

	/**
	 * Retroune les identifiants des l'ensemble des objets contenus
	 * @return Collection d'integers
 	 */
	public Collection<Integer> getListeObjets();

}
