package interfaces;

import java.io.IOException;
import java.util.Collection;

import javax.naming.NamingException;

import exceptions.UnknownObjetException;
public interface ILivre {
    public void sauvegarderLivre () throws IOException ;
    public void supprimerLivre () ;
    public void setTitre(String nom);
    public String getTitre();
    public Collection<Integer> analyserGraphe();
    
    public Collection<Integer> getListeSection();
    public Collection<Integer> getListeEnchainement();
    public Collection<Integer> getListeObjetsTousEnchainements();
    public Collection<Integer> getListeObjetsToutesSections();

    //Section

    //Ret l'id de la section
    public Integer ajouterSection(String text); 
    public Integer ajouterSectionAvecEnsembleObjets(String text, Collection<Integer> ens);
    public void modifierTextSection(Integer id, String text);
    public void ajouterObjetSection(Integer idSection, Integer idObjet);
    public void supprimerObjetSection(Integer idSection, Integer idObjet) throws UnknownObjetException;
    public void supprimerSection(Integer id);
    public String getTextSection(Integer idSection);
    public Collection<Integer> getListeObjetsSection(Integer idSection);
    
    //Enchainement
    
    //Ret l'id du nouvel enchainement de A vers B
    //Les objets d'un enchainemet sont ses conditions
    public Integer creerEnchainement(Integer idA, Integer idB, String text);
    public void supprimerEnchainement(Integer id);    
    public void modifierTextEnchainement(Integer id, String text);
    public String getTextEnchainement(Integer id);
    public void ajouterObjetEnchainement(Integer idEnchainement, Integer idObjet);
    public void setSourceEnchainement(Integer idEnchainement, Integer idSource);
    public void setDestinationEnchainement(Integer idEnchainement, Integer idDest);
    public void supprimerObjetEnchainement(Integer idSection, Integer idObjet);
    public Integer getIdSourceEnchainement(Integer enchId);
    public Integer getIdDestEnchainement(Integer enchId);
    public Collection<Integer> getListeObjetsEnch(Integer id);

    
   
}
