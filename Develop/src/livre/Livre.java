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
	//private ISections sections;
	private ArrayList<Section> sections;
	private ArrayList<Enchainement> ench;

	//Sauvegarde
	private ObjectOutputStream out;
	private ObjectInputStream in;

	//Création d'un nouveau livre
	public void creerLivre(String nom, String chemin){

		this.chemin = chemin;
		titre = nom;
		
		File f = new File(chemin);
		try {
			if(!f.createNewFile()) //Le livre existe déjà
				throw new NamingException("Name already taken");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sections = new ArrayList<>();
		ench = new ArrayList<>();
	}
	
	//Ouvre un livre qui existe déjà
	public void creerLivre(String chemin) throws IOException{
		ouvrirLivre(chemin);
	}

	//TODO: + Rendre la classe sérializable
	public void ouvrirLivre(String chemin) throws IOException{
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

	private void writeObject(java.io.ObjectOutputStream out)
			throws IOException{
		out.writeObject(titre);
		out.writeObject(sections);
		out.writeObject(ench);

	}
	private void readObject(java.io.ObjectInputStream in)
			throws IOException, ClassNotFoundException{
		titre = (String) in.readObject();
		sections = (ArrayList<Section>) in.readObject();
		ench = in.readObject();
	}
	private void readObjectNoData()
			throws ObjectStreamException{

	}

	@Override
	public void changerTitre(String nom) {
		this.titre = nom;
	}

	@Override
	public Collection<Integer> getListeSection() {
		Collection<Integer> it = new ArrayList<>();

		for(Section e : sections)
			it.add(e.getID());
		
		return it;
	}

	@Override
	public Collection<Integer> getListeEnchainement() {
		Collection<Integer> it = new ArrayList<>();

		for(Enchainement e : ench)
			it.add(e.getID());
		
		return it;
	}

	@Override
	public Collection<Integer> getListeObjetsEnchainement() {
		Collection<Integer> it = new ArrayList<>();

		for(Enchainement e : ench)
			it.addAll(e.getObjets());
		
		return it;
	}

	@Override
	public Collection<Integer> getListeObjetsSection() {
		Collection<Integer> it = new ArrayList<>();

		for(Section e : sections)
			it.addAll(e.getObjets());
		
		return it;	
	}

	@Override
	public Integer ajouterSection(String text) {
		sections.add(new Section(sections.size()));
		sections.get(sections.size()-1).setText(text);
		return sections.size()-1;
	}

	@Override
	public Integer ajouterSectionAvecEnsemble(String text, Collection<Integer> ens) {
		Section s = sections.get(ajouterSection(text));
		for(Integer i: ens)
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
	public void supprimerObjetSection(Integer idSection, Integer idObjet) throws UnknownObjetException {
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
		ench.add(new Enchainement( ench.size(), sections.get(idA), sections.get(idB), text));
		return ench.size()-1;
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
			ench.get(idEnchainement).setSource(sections.get(idSource));
		
	}

	@Override
	public void setDestinationEnchainement(Integer idEnchainement, Integer idSection) {
		ench.get(idEnchainement).setDestination(sections.get(idSection));
		
	}

	@Override
	public void supprimerObjetEnchainement(Integer idSection, Integer idObjet) {
		ench.get(idSection).delObjet(idObjet);
	}

}
