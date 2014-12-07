package text;

import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

import exceptions.UnknownObjetException;
import interfaces.ComposantFactory;
import interfaces.IControleur;

// Notes pour la modification :

// Penser à maintenir à jour le lien entre le nom de la commande à
// parser, son nom dans la fonction listerCommandes, le nom de la
// méthode appelée et le nom de la méthode définie




// Optimisations : Ajouter des variables d'états pour controler la
//   cohérence des commandes (par exemple vérifier qu'un livre est
//   ouvert avant d'ajouter une section)

// Optimisations : Vérifier un minimum les paramètres envoyés aux
// méthodes

// Optimisations : Ajouter des méthodes pour afficher un objet, une
// section, un enchainement

public class LDVHIHM {
    private IControleur ctrl;
    private Scanner scanner;
	
    public static void main() {
	LDVHIHM ihm = new LDVHIHM();
	ihm.waitCommandes();
    }
	
    public LDVHIHM() {
	ctrl = ComposantFactory.createControleur();
	scanner = new Scanner(System.in);
    }

    private void waitCommandes() {
	string cmd;
	bool quit = false;

	listerCommandes("");

	do {
	    cmd = sc.nextLine();
	    if(cmd.matches("^listerCommandes( .*)?$"))
		listerCommandes(cmd);
	    else if(cmd.matches("^creerLivre( .*)?$"))
		creerLivre(cmd);
	    else if(cmd.matches("^ouvrirLivre( .*)?$"))
		ouvrirLivre(cmd);
	    else if(cmd.matches("^sauvegarderLivre( .*)?$"))
		sauvegarderLivre(cmd);
	    else if(cmd.matches("^supprimerLivre( .*)?$"))
		supprimerLivre(cmd);
	    else if(cmd.matches("^changerTitre( .*)?$"))
		changerTitre(cmd);
	    else if(cmd.matches("^afficherListeSection( .*)?$"))
		afficherListeSection(cmd);
	    else if(cmd.matches("^afficherSection( .*)?$"))
		afficherSection(cmd);
	    else if(cmd.matches("^getListeEnchainement( .*)?$"))
		getListeEnchainement(cmd);
	    else if(cmd.matches("^getListeObjetsEnchainement( .*)?$"))
		getListeObjetsEnchainement(cmd);
	    else if(cmd.matches("^getListeObjetsSection( .*)?$"))
		getListeObjetsSection(cmd);
	    else if(cmd.matches("^ajouterSection( .*)?$"))
		ajouterSection(cmd);
	    else if(cmd.matches("^ajouterSectionAvecEnsemble( .*)?$"))
		ajouterSectionAvecEnsemble(cmd);
	    else if(cmd.matches("^modifierTextSection( .*)?$"))
		modifierTextSection(cmd);
	    else if(cmd.matches("^ajouterObjetSection( .*)?$"))
		ajouterObjetSection(cmd);
	    else if(cmd.matches("^supprimerObjetSection( .*)?$"))
		supprimerObjetSection(cmd);
	    else if(cmd.matches("^getTextSection( .*)?$"))
		getTextSection(cmd);
	    else if(cmd.matches("^getListeObjetsSection( .*)?$"))
		getListeObjetsSection(cmd);
	    else if(cmd.matches("^creerEnchainement( .*)?$"))
		creerEnchainement(cmd);
	    else if(cmd.matches("^modifierTextEnchainement( .*)?$"))
		modifierTextEnchainement(cmd);
	    else if(cmd.matches("^ajouterObjetEnchainement( .*)?$"))
		ajouterObjetEnchainement(cmd);
	    else if(cmd.matches("^setSourceEnchainement( .*)?$"))
		setSourceEnchainement(cmd);
	    else if(cmd.matches("^setDestinationEnchainement( .*)?$"))
		setDestinationEnchainement(cmd);
	    else if(cmd.matches("^supprimerObjetEnchainement( .*)?$"))
		supprimerObjetEnchainement(cmd);
	    else if(cmd.matches("^ajouterObjet( .*)?$"))
		ajouterObjet(cmd);
	    else if(cmd.matches("^getNomObjet( .*)?$"))
		getNomObjet(cmd);
	    else if(cmd.matches("^setNomObjet( .*)?$"))
		setNomObjet(cmd);
	    else if(cmd.matches("^supprimerObjet( .*)?$"))
		supprimerObjet(cmd);
	    else if(cmd.matches("^getListeObjets( .*)?$"))
		getListeObjets(cmd);
	    else if(cmd.matches("^quit( .*)?$"))
		quit = true;
	    else 
		System.out.println("Erreur commande inconnue");
	} while(!quit);
	
    }

    // private void listerCommandes(String cmd) {
    // 	System.out.println("liste des commandes !!");
    // }

    private void creerLivre(String cmd) {
	String args = cmd.split(" +");
	ctrl.creerLivre(args[1], args[2]);
    }

    private void ouvrirLivre(String cmd) {
	String args = cmd.split(" +");
	try {
	    ctrl.ouvrirLivre(args[1]);
	} catch (IOException e) {
	    System.out.println("Erreur lors de l'execution");
	}
    }

    private void sauvegarderLivre(String cmd) {
	String args = cmd.split(" +");
	try {
	    ctrl.sauvegarderLivre();
	} catch (IOException e) {
	    System.out.println("Erreur lors de l'execution");
	}
    }

    private void supprimerLivre(String cmd) {
	String args = cmd.split(" +");
	ctrl.supprimerLivre();
    }

    private void changerTitre(String cmd) {
	String args = cmd.split(" +");
	ctrl.changerTitre(args[1]);
    }

    private void afficherSection(String cmd) {
	String args = cmd.split(" +");
	afficherSection(Integer.parseInt(args[1]));
    }

    private void afficherSection(Integer id) {
	Collection<Integer> idObjets;
	Collection<Integer> idEnchainements;

	idObjets = ctrl.getListeObjetsSection(idSection);
	idObjets = ctrl.getListeEnchainement();
	System.out.println("Id : " + idSection);
	System.out.println("Texte : " + ctrl.getTextSection(idSection));
	System.out.println("Objets : ");
	for(Integer idObjet : idObjets) {
	    System.out.println(" - " + ctrl.getNomObjet(idObjet));
	}
	System.out.println("Enchainements : ");
	for(Integer idEnchainement : idEnchainements) {
	    if(ctrl.getSourceEnchainement(idEnchainement) == idSection)
		System.out.println(idEnchainement + " : " + 
				   ctrl.getTexteEnchainement(idEnchainement));
	}
    }

    private void afficherListeSection(String cmd) {
	Collection<Integer> idSections = ctrl.getListeSection();

	// Note : Limiter l'affichage du texte des enchainements ??
	for(Integer idSection : idSections) {
	    afficherSection(idSection);
	}


    }

    private void getListeEnchainement(String cmd) {
	String args = cmd.split(" +");
	Collection<Integer> retour = ctrl.getListeEnchainement();
    }

    private void getListeObjetsEnchainement(String cmd) {
	String args = cmd.split(" +");
	Collection<Integer> retour = ctrl.getListeObjetsEnchainement();
    }

    private void getListeObjetsSection(String cmd) {
	String args = cmd.split(" +");
	Collection<Integer> retour = ctrl.getListeObjetsSection();
    }

    private void ajouterSection(String cmd) {
	String args = cmd.split(" +");
	Integer retour = ctrl.ajouterSection(args[1]);
    }

    private void ajouterSectionAvecEnsemble(String cmd) {
	String args = cmd.split(" +");
	Integer retour = ctrl.ajouterSectionAvecEnsemble(args[1], args[2]);
    }

    private void modifierTextSection(String cmd) {
	String args = cmd.split(" +");
	ctrl.modifierTextSection(args[1], args[2]);
    }

    private void ajouterObjetSection(String cmd) {
	String args = cmd.split(" +");
	ctrl.ajouterObjetSection(args[1], args[2]);
    }

    private void supprimerObjetSection(String cmd) {
	String args = cmd.split(" +");
	try {
	    ctrl.supprimerObjetSection(args[1], args[2]);
	} catch (UnknownObjetException e) {
	    System.out.println("Erreur lors de l'execution");
	}
    }

    private void getTextSection(String cmd) {
	String args = cmd.split(" +");
	String retour = ctrl.getTextSection(args[1]);
    }

    private void getListeObjetsSection(String cmd) {
	String args = cmd.split(" +");
	Collection<Integer> retour = ctrl.getListeObjetsSection(args[1]);
    }

    private void creerEnchainement(String cmd) {
	String args = cmd.split(" +");
	Integer retour = ctrl.creerEnchainement(args[1], args[2], args[3]);
    }

    private void modifierTextEnchainement(String cmd) {
	String args = cmd.split(" +");
	ctrl.modifierTextEnchainement(args[1], args[2]);
    }

    private void ajouterObjetEnchainement(String cmd) {
	String args = cmd.split(" +");
	ctrl.ajouterObjetEnchainement(args[1], args[2]);
    }

    private void setSourceEnchainement(String cmd) {
	String args = cmd.split(" +");
	ctrl.setSourceEnchainement(args[1], args[2]);
    }

    private void setDestinationEnchainement(String cmd) {
	String args = cmd.split(" +");
	ctrl.setDestinationEnchainement(args[1], args[2]);
    }

    private void supprimerObjetEnchainement(String cmd) {
	String args = cmd.split(" +");
	ctrl.supprimerObjetEnchainement(args[1], args[2]);
    }

    private void ajouterObjet(String cmd) {
	String args = cmd.split(" +");
	Integer retour = ctrl.ajouterObjet(args[1]);
    }

    private void getNomObjet(String cmd) {
	String args = cmd.split(" +");
	String retour = ctrl.getNomObjet(args[1]);
    }

    private void setNomObjet(String cmd) {
	String args = cmd.split(" +");
	ctrl.setNomObjet(args[1], args[2]);
    }

    private void supprimerObjet(String cmd) {
	String args = cmd.split(" +");
	ctrl.supprimerObjet(args[1]);
    }

    private void getListeObjets(String cmd) {
	String args = cmd.split(" +");
	Collection<Integer> retour = ctrl.getListeObjets();
    }

    
}
