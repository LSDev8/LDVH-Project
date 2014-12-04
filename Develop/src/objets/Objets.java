package objets;

import interfaces.*;

import java.util.ArrayList;

public class Objets extends ArrayList<Objet> implements IObjets {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8453940332587040685L;
	private int compteur = 0;

    public void createObjets(IObjets o){
	if(this == o)
	    System.exit(-1);
	for(Objet e : o)
	    creationObjet(e.getNom());
    }

    public Integer creationObjet(String nom) {
	Objet o = new Objet(compteur,nom);
	add(compteur,o);
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

   public ArrayList<Objet> getObjets(){
	return this;
    }
       
}
