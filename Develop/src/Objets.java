import java.util.ArrayList;

public class Objets implements IObjets {

	private static Integer cpt = 0;
	private ArrayList<IObjet> objl = new ArrayList<IObjet>();

	@Override
	public Integer creationObjet(String nom) {
		IObjet o = new Objet();
		o.setId(cpt++);
		o.setNom(nom);
		this.objl.add(o);
		return o.getId();
	}

	@Override
	public String getNomObjet(Integer id) {
		for (int i = 0; i < objl.size(); i++) {
			if (objl.get(i).getId() == id) {
				return objl.get(i).getNom();
			}
		}
		return null;
	}

	@Override
	public void setNomObjet(Integer id, String nom) {
		for (int i = 0; i < objl.size(); i++) {
			if (objl.get(i).getId() == id) {
				objl.get(i).setNom(nom);
			}
		}
	}

	@Override
	public void supprimerObjet(Integer id) {
		for (int i = 0; i < objl.size(); i++) {
			if (objl.get(i).getId() == id) {
				objl.remove(i);
			}
		}
	}

	public ArrayList<IObjet> getObjets(){
		return objl;
	}
}
