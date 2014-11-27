import java.util.ArrayList;

//Ensemble de sections
public class Sections extends ArrayList<Section> implements ISections{

	//Les indices d'une ArrayList pouvant changer...
	public static int cpt = 0;

	public Integer creerSection(){
		Section sect = new Section(cpt++);
		add(sect.getID(), sect);
		return sect.getID();
	}

	public Integer setTexteSection(Integer id, String texte){
		get(id).setText(texte);
		return 0;
	}

	public String getTexteSection(Integer id){
		return get(id).getText();
	}

	public String[] listerSection(){
		String[] liste = new String[size()];
		int i = 0;

		for(Section s: this)
			liste[i++] = "[" + s.getID() + "] " + s.getText();

		return liste;
	}

	public void supprimerSection(Integer id){
		remove(id);
	}

	public void addObject(Integer idS, Integer idO){
		//Je sais pas...	
	}

	public void removeObjet(Integer idS, Integer idObj)
		throws UnknownObjetException{
		get(idS).removeObjet(idObj);

	}
}
