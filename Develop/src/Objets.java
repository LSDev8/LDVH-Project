import java.util.ArrayList;

public class Objets extends ArrayList<Objet> implements IObjets {

    private int cpt = 0;

    public Objets createObjets(Objets o){
	if(this == o)
	    exit(-1);
	for(Objet e : o)
	    creationObjet(e.getNom());
    }

    public Integer creationObjet(String nom) {
	IObjet o = new Objet(cpt++,nom);
	add(cpt,o);
	return cpt;
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

    public ArrayList<IObjet> getObjets(){
	return (ArrayList<IObjet>)this;
    }

    private void add(Object e){
	super.add(e);
    }
}
