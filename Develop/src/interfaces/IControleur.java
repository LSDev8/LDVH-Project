package interfaces;

import java.io.IOException;
import java.util.Collection;

import javax.naming.NamingException;

import exceptions.UninitializedLivreException;
import exceptions.UnknownObjetException;
public interface IControleur {

    // Livre
    public void creerLivre (String nom, String chemin) throws IOException, NamingException ;
    public void ouvrirLivre (String chemin) throws IOException ;
    public void sauvegarderLivre () throws IOException, UninitializedLivreException ;
    public void supprimerLivre () throws IOException, UninitializedLivreException;
    public void changerTitre(String nom) throws UninitializedLivreException;

    //Section
    public Collection<Integer> getListeSection() throws UninitializedLivreException;
    public Collection<Integer> getListeObjetsSection() throws UninitializedLivreException;
    public Integer ajouterSection(String text) throws UninitializedLivreException; 
    public Integer ajouterSectionAvecEnsemble(String text, Collection<Integer> ens) throws UninitializedLivreException;
    public void modifierTextSection(Integer id, String text) throws UninitializedLivreException;
    public void ajouterObjetSection(Integer idSection, Integer idObjet) throws UninitializedLivreException;
    public void supprimerObjetSection(Integer idSection, Integer idObjet) throws UnknownObjetException, UninitializedLivreException;
    public String getTextSection(Integer idSection) throws UninitializedLivreException;
    public Collection<Integer> getListeObjetsSection(Integer idSection) throws UninitializedLivreException;
    
    //Enchainement
    public Collection<Integer> getListeEnchainement() throws UninitializedLivreException;
    public Collection<Integer> getListeObjetsEnchainement() throws UninitializedLivreException;
    public Integer creerEnchainement(Integer idA, Integer idB, String text) throws UninitializedLivreException;
    public void modifierTextEnchainement(Integer id, String text) throws UninitializedLivreException;
    public void ajouterObjetEnchainement(Integer idEnchainement, Integer idObjet) throws UninitializedLivreException;
    public void setSourceEnchainement(Integer idEnchainement, Integer idSource) throws UninitializedLivreException;
    public void setDestinationEnchainement(Integer idEnchainement, Integer idDest) throws UninitializedLivreException;
    public Integer getSourceEnchainement(Integer idEnchainement) throws UninitializedLivreException;
    public Integer getDestinationEnchainement(Integer idEnchainement) throws UninitializedLivreException;
    public String getTexteEnchainement(Integer idEnchainement) throws UninitializedLivreException;
    public void supprimerObjetEnchainement(Integer idSection, Integer idObjet) throws UninitializedLivreException;

    // Objets
    public Collection<Integer> getListeObjets() throws UninitializedLivreException;
    public Integer ajouterObjet(String nom) throws UninitializedLivreException;
    public String getNomObjet(Integer id) throws UninitializedLivreException;
    public void setNomObjet(Integer id, String nom) throws UninitializedLivreException;
    public void supprimerObjet(Integer id) throws UninitializedLivreException;
}
