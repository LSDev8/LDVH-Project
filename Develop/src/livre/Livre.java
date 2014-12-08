package livre;

import interfaces.ILivre;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.NamingException;

import exceptions.UnknownObjetException;

public class Livre implements ILivre, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titre, chemin;
	// private ISections sections;
	private ArrayList<Section> sections;
	private ArrayList<Enchainement> ench;

	// Sauvegarde
	private ObjectOutputStream out;
	private ObjectInputStream in;

	// Création d'un nouveau livre
	public void creerLivre(String nom, String chemin) throws IOException,
			NamingException {

		this.chemin = chemin;
		titre = nom;

		File f = new File(chemin);
		try {
			f.createNewFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				e.printStackTrace();
			} catch (Exception e1) {
			}
			throw e;
		}

		sections = new ArrayList<>();
		ench = new ArrayList<>();
	}

	// Ouvre un livre qui existe déjà
	public void creerLivre(String chemin) throws IOException {
		ouvrirLivre(chemin);
	}

	// TODO: + Rendre la classe sérializable
	public void ouvrirLivre(String chemin) throws IOException {
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

	public void sauvegarderLivre() throws IOException {
		FileOutputStream fileOut = new FileOutputStream(chemin);
		out = new ObjectOutputStream(fileOut);

		writeObject(out);

		out.close();
		out = null;
		fileOut.close();
		return;
	}

	public void supprimerLivre() {
		File f = new File(chemin);
		f.delete();

		return;
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {

		// TODO: Modifier quand Sections sera complété
		throw new IOException("Non implémenté");
		/*
		 * out.writeObject(titre); out.writeObject(sections);
		 * out.writeObject(ench);
		 */

	}

	private void readObject(java.io.ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		titre = (String) in.readObject();

		throw new IOException("Non implémenté");

		// sections = (ArrayList<Section>) in.readObject();
		// ench = in.readObject();
	}

	@SuppressWarnings("unused")
	private void readObjectNoData() throws ObjectStreamException {
	}

	public String getTitre() {
		return titre;
	}

	@Override
	public void setTitre(String nom) {
		this.titre = nom;
	}

	@Override
	public Collection<Integer> getListeSection() {
		Collection<Integer> it = new ArrayList<>();

		for (Section e : sections)
			it.add(e.getID());

		return it;
	}

	@Override
	public Collection<Integer> getListeEnchainement() {
		Collection<Integer> it = new ArrayList<>();

		for (Enchainement e : ench)
			it.add(e.getID());

		return it;
	}

	@Override
	public Collection<Integer> getListeObjetsEnchainement() {
		Collection<Integer> it = new ArrayList<>();

		for (Enchainement e : ench)
			it.addAll(e.getObjets());

		return it;
	}

	@Override
	public Collection<Integer> getListeObjetsSection() {
		Collection<Integer> it = new ArrayList<>();

		for (Section e : sections)
			it.addAll(e.getObjets());

		return it;
	}

	@Override
	public Integer ajouterSection(String text) {
		Integer id;
		Section s = new Section(0);
		sections.add(s);
		id = sections.indexOf(s);
		s.setID(id);
		s.setText(text);
		return id;
	}

	@Override
	public Integer ajouterSectionAvecEnsemble(String text,
			Collection<Integer> ens) {
		Section s = sections.get(ajouterSection(text));
		for (Integer i : ens)
			s.addObjet(i);
		return s.getID();

	}

	@Override
	public void modifierTextSection(Integer id, String text) {
		sections.get(id).setText(text);
	}

	@Override
	public void ajouterObjetSection(Integer idSection, Integer idObjet) {
		sections.get(idSection).addObjet(idObjet);
	}

	@Override
	public void supprimerObjetSection(Integer idSection, Integer idObjet)
			throws UnknownObjetException {
		sections.get(idSection).removeObjet(idObjet);

	}

	@Override
	public String getTextSection(Integer idSection) {
		return sections.get(idSection).getText();
	}

	@Override
	public Collection<Integer> getListeObjetsSection(Integer idSection) {
		return sections.get(idSection).getObjets();
	}

	@Override
	public Integer creerEnchainement(Integer idA, Integer idB, String text) {
		Integer id;
		Enchainement e = new Enchainement(0, sections.get(idA),
				sections.get(idB), text);
		ench.add(e);
		id = ench.indexOf(e);
		e.setID(id);
		sections.get(idA).addEnch(id);
		return id;
	}

	@Override
	public void modifierTextEnchainement(Integer id, String text) {
		ench.get(id).setText(text);

	}

	@Override
	public void ajouterObjetEnchainement(Integer idEnchainement, Integer idObjet) {
		ench.get(idEnchainement).addObjet(idObjet);
	}

	@Override
	public void setSourceEnchainement(Integer idEnchainement, Integer idSource) {
		sections.get(ench.get(idEnchainement).getIdSourceEnchainement()).delEnch(idEnchainement);
		ench.get(idEnchainement).setSource(sections.get(idSource));
		sections.get(idSource).addEnch(idEnchainement);

	}

	@Override
	public void setDestinationEnchainement(Integer idEnchainement,
			Integer idSection) {
		ench.get(idEnchainement).setDestination(sections.get(idSection));

	}

	@Override
	public void supprimerObjetEnchainement(Integer idSection, Integer idObjet) {
		ench.get(idSection).delObjet(idObjet);
	}

	@Override
	public String getTextEnchainement(Integer id) {
		return ench.get(id).getText();
	}

	public void supprimerSection(Integer id) {
		ench.remove(id);
	}

	/**
	 * Cette méthode rend la liste des indices des Sections qui ne sont pas
	 * atteignables. On part du principe que la section d'indice zéro est
	 * toujours atteignable, c'est la section de départ
	 * 
	 * Ou pour résumer:
	 * 
	 * Johnny walks around, strutting along the lanes of Section and
	 * Enchainement, finding those who don't belong, who never found their place
	 * in the flow of the story. 
	 * And then, he kills them. 
	 * Just kidding... 
	 * He just points his finger so that the Stasi may know who they are. What they
	 * do with this informations is up to them. 
	 * 
	 * He's innocent. 
	 * 
	 * He swears.
	 * 
	 * @author 2900600
	 * 
	 * @param l Le livre à chercher
	 * @return La liste des indices des Sections non atteingnables
	 */
	public Collection<Integer> innaccessible() {
		
		Integer dest;
		ILivre l = this;
		//Indices des sections non accessibles
		Collection<Integer> inaccessibles = l.getListeSection();
		//Indices des sections que l'on est en train de parcourir
		Collection<Integer> visites = new ArrayList<>();
		
		//Si la liste des sections est vide, on rend un ensemble vide
		if(sections.size() == 0)
			return (Collection<Integer>) new ArrayList<Integer>();
		
		//On considère toujours que la section zéro est accessible
		inaccessibles.remove((Integer) 0);
		visites.add((Integer) 0);

		//Tant qu'une sections reste à visiter
		while(visites.size() > 0){
			//pour le premier membre de la liste
			for(Integer i : visites){
				//on le supprime de la liste
				visites.remove(i);
				//Et des sections non accessibles
				inaccessibles.remove(i);
				//Pour chacune de ces sections cibles
				for(Integer s : sections.get(i).getListeEnch()){
					dest = sections.get(s).getIdDestinationEnchainement();
					//Si elles sont encore dans la liste des inaccessibles
					if(inaccessibles.contains(dest))
						//On prévoit de les visiter
						visites.add(dest);
				}

			}
		}





		
		return inaccessibles;

	}
}
