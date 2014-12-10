package controleur;

import java.io.IOException;
import java.util.Collection;

import javax.naming.NamingException;

import livre.Livre;
import exceptions.UninitializedLivreException;
import exceptions.UnknownObjetException;
import interfaces.ComposantFactory;
import interfaces.IControleur;
import interfaces.ILivre;
import interfaces.IObjets;

public class Controleur implements IControleur {
	// Dans le cas où on appelle une méthode sur un livre qui n'est pas créé
	// on lance l'exception UninitializedLivreException
	private ILivre livre = null;
	private IObjets objets;

	public Controleur() {
		livre = null;
		objets = null;
	}

	@Override
	public void creerLivre(String nom, String chemin) throws IOException,
			NamingException {
		livre = ComposantFactory.createLivre(nom, chemin);
		objets = ComposantFactory.createObjets();
	}

	@Override
	public void ouvrirLivre(String chemin) throws IOException {
		livre = ComposantFactory.createLivre(chemin);
		objets = ComposantFactory.createObjets();

		// Retrouver les objets du livre ?
		throw new IOException();
	}

	@Override
	public void sauvegarderLivre() throws IOException,
			UninitializedLivreException {
		this.getLivre().sauvegarderLivre();
	}

	@Override
	public void supprimerLivre() throws UninitializedLivreException {
		this.getLivre().supprimerLivre();
	}

	@Override
	public void changerTitre(String nom) throws UninitializedLivreException {
		this.getLivre().setTitre(nom);
	}

	@Override
	public Collection<Integer> getListeSection()
			throws UninitializedLivreException {
		return this.getLivre().getListeSection();
	}

	@Override
	public Collection<Integer> getListeEnchainement()
			throws UninitializedLivreException {
		return this.getLivre().getListeEnchainement();
	}

	@Override
	public Collection<Integer> getListeObjetsEnchainement()
			throws UninitializedLivreException {
		return this.getLivre().getListeObjetsEnchainement();
	}

	@Override
	public Collection<Integer> getListeObjetsSection()
			throws UninitializedLivreException {
		return this.getLivre().getListeObjetsSection();
	}

	@Override
	public Integer ajouterSection(String text)
			throws UninitializedLivreException {
		return this.getLivre().ajouterSection(text);
	}

	@Override
	public Integer ajouterSectionAvecEnsemble(String text,
			Collection<Integer> ens) throws UninitializedLivreException {
		return this.getLivre().ajouterSectionAvecEnsembleObjets(text, ens);
	}

	@Override
	public void modifierTextSection(Integer id, String text)
			throws UninitializedLivreException {
		this.getLivre().modifierTextSection(id, text);
	}

	@Override
	public void ajouterObjetSection(Integer idSection, Integer idObjet)
			throws UninitializedLivreException {
		this.getLivre().ajouterObjetSection(idSection, idObjet);
	}

	@Override
	public void supprimerObjetSection(Integer idSection, Integer idObjet)
			throws UnknownObjetException, UninitializedLivreException {
		this.getLivre().supprimerObjetSection(idSection, idObjet);
	}

	@Override
	public String getTextSection(Integer idSection)
			throws UninitializedLivreException {
		return this.getLivre().getTextSection(idSection);
	}

	@Override
	public Collection<Integer> getListeObjetsSection(Integer idSection)
			throws UninitializedLivreException {
		return this.getLivre().getListeObjetsSection(idSection);
	}

	@Override
	public Integer creerEnchainement(Integer idA, Integer idB, String text)
			throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		return creerEnchainement(idA, idB, text);
	}

	@Override
	public void modifierTextEnchainement(Integer id, String text)
			throws UninitializedLivreException {
		this.getLivre().modifierTextEnchainement(id, text);
	}

	@Override
	public void ajouterObjetEnchainement(Integer idEnchainement, Integer idObjet)
			throws UninitializedLivreException {
		this.getLivre().ajouterObjetEnchainement(idEnchainement, idObjet);
	}

	@Override
	public void setSourceEnchainement(Integer idEnchainement, Integer idSource)
			throws UninitializedLivreException {
		this.getLivre().setSourceEnchainement(idEnchainement, idSource);
	}

	@Override
	public void setDestinationEnchainement(Integer idEnchainement,
			Integer idDest) throws UninitializedLivreException {
		this.getLivre().setDestinationEnchainement(idEnchainement, idDest);
	}

	@Override
	public void supprimerObjetEnchainement(Integer idSection, Integer idObjet)
			throws UninitializedLivreException {
		this.getLivre().supprimerObjetEnchainement(idSection, idObjet);
	}

	@Override
	public Integer ajouterObjet(String nom) throws UninitializedLivreException {
		return this.getObjets().ajouterObjet(nom);
	}

	@Override
	public String getNomObjet(Integer id) throws UninitializedLivreException {
		return this.getObjets().getNomObjet(id);
	}

	@Override
	public void setNomObjet(Integer id, String nom)
			throws UninitializedLivreException {
		this.getObjets().setNomObjet(id, nom);
	}

	@Override
	public void supprimerObjet(Integer id) throws UninitializedLivreException {
		this.getObjets().supprimerObjet(id);
	}

	@Override
	public Collection<Integer> getListeObjets()
			throws UninitializedLivreException {
		return this.getObjets().getListeObjets();
	}

	@Override
	public Integer getSourceEnchainement(Integer idEnchainement)
			throws UninitializedLivreException {
		return this.getLivre().getIdSourceEnchainement(idEnchainement);
	}

	@Override
	public Integer getDestinationEnchainement(Integer idEnchainement)
			throws UninitializedLivreException {
		return this.getLivre().getIdDestEnchainement(idEnchainement);
	}

	@Override
	public String getTexteEnchainement(Integer idEnchainement)
			throws UninitializedLivreException {
		return this.getLivre().getTextEnchainement(idEnchainement);
	}
	
	private Livre getLivre() throws UninitializedLivreException {
		if(this.livre==null)
			throw new UninitializedLivreException("Livre non init");
		return (Livre)this.livre;
	}
	
	private IObjets getObjets() throws UninitializedLivreException {
		if(this.livre==null)
			throw new UninitializedLivreException("Livre non init");
		return this.objets;
	}

}
