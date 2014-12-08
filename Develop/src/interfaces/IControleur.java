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
    public Collection<Integer> getListeObjetsSection();
    public Integer ajouterSection(String text); 
    public Integer ajouterSectionAvecEnsemble(String text, Collection<Integer> ens);
    public void modifierTextSection(Integer id, String text);
    public void ajouterObjetSection(Integer idSection, Integer idObjet);
    public void supprimerObjetSection(Integer idSection, Integer idObjet) throws UnknownObjetException;
    public String getTextSection(Integer idSection);
    public Collection<Integer> getListeObjetsSection(Integer idSection);
    
    //Enchainement
    public Collection<Integer> getListeEnchainement() throws UninitializedLivreException;
    public Collection<Integer> getListeObjetsEnchainement();
    public Integer creerEnchainement(Integer idA, Integer idB, String text);
    public void modifierTextEnchainement(Integer id, String text);
    public void ajouterObjetEnchainement(Integer idEnchainement, Integer idObjet);
    public void setSourceEnchainement(Integer idEnchainement, Integer idSource);
    public void setDestinationEnchainement(Integer idEnchainement, Integer idDest);
    public void getSourceEnchainement(Integer idEnchainement);
    public void getDestinationEnchainement(Integer idEnchainement);
    public void getTexteEnchainement(Integer idEnchainement);
    public void supprimerObjetEnchainement(Integer idSection, Integer idObjet);

    // Objets
    public Collection<Integer> getListeObjets();
    public Integer ajouterObjet(String nom);
    public String getNomObjet(Integer id);
    public void setNomObjet(Integer id, String nom);
    public void supprimerObjet(Integer id);
}
