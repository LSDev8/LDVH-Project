import java.io.Serializable;
import java.util.ArrayList;

public class Livre implements ILivre {
	
	private String titre, chemin;
	private Sections sections;
	private Enchainements ench;

	public void creerLivre(String nom, String chemin){

		this.chemin = chemin;
		titre = nom;

		sections  = new Sections();
		ench = new Enchainements();
	}

	public IEnchainements getEnchainements(){
		return ench;
	}

	public ISections getSections(){
		return sections;
	}

	public IObjets getObjets(){

		Objets o;

		for(Enchainement e : ench){
			o.addAll(e.getObjets());
		}

		return o;
	}


	//TODO: + Rendre la classe sérializable
	public void ouvrirChemin(String chemin){
		return ;
	}
	
	public void sauvegarderLivre(){
		return ;
	}

	public void supprimerLivre(){
		return ;
	}
}
