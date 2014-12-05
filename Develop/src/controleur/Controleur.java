package controleur;

import java.io.IOException;
import java.util.Collection;

import exceptions.UnknownObjetException;
import interfaces.ComposantFactory;
import interfaces.IControleur;
import interfaces.ILivre;
import interfaces.IObjets;

public class Controleur implements IControleur {
	private ILivre livre;
	private IObjets objets;
	
	public Controleur() {
		livre = ComposantFactory.createLivre();
		objets = ComposantFactory.createObjets();
	}
	
	@Override
	public void creerLivre(String nom, String chemin) {
		// TODO Auto-generated method stub
		livre.creerLivre(nom, chemin);
	}

	@Override
	public void ouvrirLivre(String chemin) throws IOException {
		// TODO Auto-generated method stub
		livre.ouvrirLivre(chemin);
	}

	@Override
	public void sauvegarderLivre() throws IOException {
		// TODO Auto-generated method stub
		livre.sauvegarderLivre();
	}

	@Override
	public void supprimerLivre() {
		// TODO Auto-generated method stub
		livre.supprimerLivre();
	}

	@Override
	public void changerTitre(String nom) {
		// TODO Auto-generated method stub
		livre.changerTitre(nom);
	}

	@Override
	public Collection<Integer> getListeSection() {
		// TODO Auto-generated method stub
		return livre.getListeSection();
	}

	@Override
	public Collection<Integer> getListeEnchainement() {
		// TODO Auto-generated method stub
		return livre.getListeEnchainement();
	}

	@Override
	public Collection<Integer> getListeObjetsEnchainement() {
		// TODO Auto-generated method stub
		return livre.getListeObjetsEnchainement();
	}

	@Override
	public Collection<Integer> getListeObjetsSection() {
		// TODO Auto-generated method stub
		return livre.getListeObjetsSection();
	}

	@Override
	public Integer ajouterSection(String text) {
		// TODO Auto-generated method stub
		return livre.ajouterSection(text);
	}

	@Override
	public Integer ajouterSectionAvecEnsemble(String text,
			Collection<Integer> ens) {
		// TODO Auto-generated method stub
		return livre.ajouterSectionAvecEnsemble(text, ens);
	}

	@Override
	public void modifierTextSection(Integer id, String text) {
		// TODO Auto-generated method stub
		livre.modifierTextSection(id, text);
	}

	@Override
	public void ajouterObjetSection(Integer idSection, Integer idObjet) {
		// TODO Auto-generated method stub
		livre.ajouterObjetSection(idSection, idObjet);
	}

	@Override
	public void supprimerObjetSection(Integer idSection, Integer idObjet)
			throws UnknownObjetException {
		// TODO Auto-generated method stub
		livre.supprimerObjetSection(idSection, idObjet);
	}

	@Override
	public String getTextSection(Integer idSection) {
		// TODO Auto-generated method stub
		return livre.getTextSection(idSection);
	}

	@Override
	public Collection<Integer> getListeObjetsSection(Integer idSection) {
		// TODO Auto-generated method stub
		return livre.getListeObjetsSection(idSection);
	}

	@Override
	public Integer creerEnchainement(Integer idA, Integer idB, String text) {
		// TODO Auto-generated method stub
		return creerEnchainement(idA, idB, text);
	}

	@Override
	public void modifierTextEnchainement(Integer id, String text) {
		// TODO Auto-generated method stub
		livre.modifierTextEnchainement(id, text);
	}

	@Override
	public void ajouterObjetEnchainement(Integer idEnchainement, Integer idObjet) {
		// TODO Auto-generated method stub
		livre.ajouterObjetEnchainement(idEnchainement, idObjet);
	}

	@Override
	public void setSourceEnchainement(Integer idEnchainement, Integer idSource) {
		// TODO Auto-generated method stub
		livre.setSourceEnchainement(idEnchainement, idSource);
	}

	@Override
	public void setDestinationEnchainement(Integer idEnchainement,
			Integer idDest) {
		// TODO Auto-generated method stub
		livre.setDestinationEnchainement(idEnchainement, idDest);
	}

	@Override
	public void supprimerObjetEnchainement(Integer idSection, Integer idObjet) {
		// TODO Auto-generated method stub
		livre.supprimerObjetEnchainement(idSection, idObjet);
	}

	@Override
	public Integer ajouterObjet(String nom) {
		// TODO Auto-generated method stub
		return objets.ajouterObjet(nom);
	}

	@Override
	public String getNomObjet(Integer id) {
		// TODO Auto-generated method stub
		return objets.getNomObjet(id);
	}

	@Override
	public void setNomObjet(Integer id, String nom) {
		// TODO Auto-generated method stub
		objets.setNomObjet(id, nom);
	}

	@Override
	public void supprimerObjet(Integer id) {
		// TODO Auto-generated method stub
		objets.supprimerObjet(id);
	}

	@Override
	public Collection<Integer> getListeObjets() {
		// TODO Auto-generated method stub
		return objets.getListeObjets();
	}

}
