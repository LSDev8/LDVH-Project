package controleur;

import java.io.IOException;
import java.util.Collection;

import javax.naming.NamingException;

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
		livre = ComposantFactory.createLivre();
		objets = ComposantFactory.createObjets();
	}

	@Override
	public void creerLivre(String nom, String chemin) throws IOException,
			NamingException {
		// TODO Auto-generated method stub
		livre.creerLivre(nom, chemin);
	}

	@Override
	public void ouvrirLivre(String chemin) throws IOException {
		// TODO Auto-generated method stub
		livre.ouvrirLivre(chemin);
	}

	@Override
	public void sauvegarderLivre() throws IOException,
			UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		livre.sauvegarderLivre();
	}

	@Override
	public void supprimerLivre() throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		livre.supprimerLivre();
	}

	@Override
	public void changerTitre(String nom) throws UninitializedLivreException {
		// TODO Auto-generated method stub
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		livre.setTitre(nom);
	}

	@Override
	public Collection<Integer> getListeSection()
			throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		return livre.getListeSection();
	}

	@Override
	public Collection<Integer> getListeEnchainement()
			throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		return livre.getListeEnchainement();
	}

	@Override
	public Collection<Integer> getListeObjetsEnchainement()
			throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		return livre.getListeObjetsEnchainement();
	}

	@Override
	public Collection<Integer> getListeObjetsSection()
			throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		return livre.getListeObjetsSection();
	}

	@Override
	public Integer ajouterSection(String text)
			throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		return livre.ajouterSection(text);
	}

	@Override
	public Integer ajouterSectionAvecEnsemble(String text,
			Collection<Integer> ens) throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		return livre.ajouterSectionAvecEnsemble(text, ens);
	}

	@Override
	public void modifierTextSection(Integer id, String text)
			throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		livre.modifierTextSection(id, text);
	}

	@Override
	public void ajouterObjetSection(Integer idSection, Integer idObjet)
			throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		livre.ajouterObjetSection(idSection, idObjet);
	}

	@Override
	public void supprimerObjetSection(Integer idSection, Integer idObjet)
			throws UnknownObjetException, UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		livre.supprimerObjetSection(idSection, idObjet);
	}

	@Override
	public String getTextSection(Integer idSection)
			throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		return livre.getTextSection(idSection);
	}

	@Override
	public Collection<Integer> getListeObjetsSection(Integer idSection)
			throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		return livre.getListeObjetsSection(idSection);
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
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		livre.modifierTextEnchainement(id, text);
	}

	@Override
	public void ajouterObjetEnchainement(Integer idEnchainement, Integer idObjet)
			throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		livre.ajouterObjetEnchainement(idEnchainement, idObjet);
	}

	@Override
	public void setSourceEnchainement(Integer idEnchainement, Integer idSource)
			throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		livre.setSourceEnchainement(idEnchainement, idSource);
	}

	@Override
	public void setDestinationEnchainement(Integer idEnchainement,
			Integer idDest) throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		livre.setDestinationEnchainement(idEnchainement, idDest);
	}

	@Override
	public void supprimerObjetEnchainement(Integer idSection, Integer idObjet)
			throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		livre.supprimerObjetEnchainement(idSection, idObjet);
	}

	@Override
	public Integer ajouterObjet(String nom) throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		return objets.ajouterObjet(nom);
	}

	@Override
	public String getNomObjet(Integer id) throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		return objets.getNomObjet(id);
	}

	@Override
	public void setNomObjet(Integer id, String nom)
			throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		objets.setNomObjet(id, nom);
	}

	@Override
	public void supprimerObjet(Integer id) throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		objets.supprimerObjet(id);
	}

	@Override
	public Collection<Integer> getListeObjets()
			throws UninitializedLivreException {
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		return objets.getListeObjets();
	}

	@Override
	public Integer getSourceEnchainement(Integer idEnchainement)
			throws UninitializedLivreException {
		// TODO Module de remplacement de méthode auto-généré
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		return livre.getIdSourceEnchainement(idEnchainement);
	}

	@Override
	public Integer getDestinationEnchainement(Integer idEnchainement)
			throws UninitializedLivreException {
		// TODO Module de remplacement de méthode auto-généré
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		return livre.getIdDestEnchainement(idEnchainement);
	}

	@Override
	public String getTexteEnchainement(Integer idEnchainement)
			throws UninitializedLivreException {
		// TODO Module de remplacement de méthode auto-généré
		if (livre == null)
			throw new UninitializedLivreException("Livre non init");
		// TODO Auto-generated method stub
		return livre.getTextEnchainement(idEnchainement);
	}

}
