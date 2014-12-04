package interfaces;

import java.io.IOException;
import java.util.Collection;

import exceptions.UnknownObjetException;
public interface ILivre {
    public void creerLivre (String nom, String chemin) ;
    public void ouvrirLivre (String chemin) throws IOException ;
    public void sauvegarderLivre () throws IOException ;
    public void supprimerLivre () ;
    public void changerTitre(String nom);
    
    public Collection<Integer> getListeSection();
    public Collection<Integer> getListeEnchainement();
    public Collection<Integer> getListeObjetsEnchainement();
    public Collection<Integer> getListeObjetsSection();

    //Section

    //Ret l'id de la section
    public Integer ajouterSection(String text); 
    public Integer ajouterSectionAvecEnsemble(String text, Collection<Integer> ens);
    public void modifierTextSection(Integer id, String text);
    public void ajouterObjetSection(Integer idSection, Integer idObjet);
    public void supprimerObjetSection(Integer idSection, Integer idObjet) throws UnknownObjetException;
    
    public String getTextSection(Integer idSection);
    public Collection<Integer> getListeObjetsSection(Integer idSection);
    
    //Enchainement
    
    //Ret l'id du nouvel enchainement de A vers B
    //Les objets d'un enchainemet sont ses conditions
    public Integer creerEnchainement(Integer idA, Integer idB, String text);
    public void modifierTextEnchainement(Integer id, String text);
    public void ajouterObjetEnchainement(Integer idEnchainement, Integer idObjet);
    public void setSourceEnchainement(Integer idEnchainement, Integer idSource);
    public void setDestinationEnchainement(Integer idEnchainement, Integer idDest);
    public void supprimerObjetEnchainement(Integer idSection, Integer idObjet);

    
   
}
