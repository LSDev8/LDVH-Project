import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class Livre implements ILivre, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titre, chemin;
	private Sections sections;
	private Enchainements ench;

	//Sauvegarde
	private ObjectOutputStream out;
	private ObjectInputStream in;

	public void creerLivre(String nom, String chemin){

		this.chemin = chemin;
		titre = nom;

		sections  = Sections.createSections();
		ench = new Enchainements();
	}

	public IEnchainements getEnchainements(){
		return ench;
	}

	public ISections getSections(){
		return sections;
	}

	public IObjets getObjets(){

		Objets o = new Objets();

		for(Enchainement e : ench){
			o.addAll(e.getObjets());
		}

		return o;
	}


	//TODO: + Rendre la classe sérializable
	public void ouvrirChemin(String chemin) throws IOException{
		FileInputStream fileIN = new FileInputStream(chemin);
		in = new ObjectInputStream(fileIN);

		try {
			readObject(in);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IOException();
		}
		in.close();
		in = null;
		fileIN.close();
	}

	public void sauvegarderLivre() throws IOException{
		FileOutputStream fileOut = new FileOutputStream(chemin);
		out = new ObjectOutputStream(fileOut);

		writeObject(out);

		out.close();
		out = null;
		fileOut.close();
		return ;
	}

	public void supprimerLivre(){
		File f = new File(chemin);
		f.delete();

		return ;
	}
	//On lit et on écrit dans l'ordre des déclarations:
	// titre, sections, ench

	private void writeObject(java.io.ObjectOutputStream out)
			throws IOException{
		out.writeObject(titre);
		out.writeObject(sections);
		out.writeObject(ench);

	}
	private void readObject(java.io.ObjectInputStream in)
			throws IOException, ClassNotFoundException{
		titre = (String) in.readObject();
		sections = (Sections) in.readObject();
		ench = (Enchainements) in.readObject();
	}
	private void readObjectNoData()
			throws ObjectStreamException{

	}

}
