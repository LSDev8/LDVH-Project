package ihm.text;

import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

import javax.naming.NamingException;

import exceptions.UninitializedLivreException;
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

	public static void main(String[] args) {
		LDVHIHM ihm = new LDVHIHM();
		ihm.waitCommandes();
	}

	public LDVHIHM() {
		ctrl = ComposantFactory.createControleur();
		scanner = new Scanner(System.in);
	}

	private void waitCommandes() {
		String cmd;
		Boolean quit = false;

		listerCommandes();

		do {
			System.out.print("\n\n\n>>> ");
			cmd = scanner.nextLine();
			if (cmd.matches("^listerCommandes( .*)?$"))
				listerCommandes();
			else if (cmd.matches("^creerLivre( .*)?$"))
				creerLivre();
			else if (cmd.matches("^ouvrirLivre( .*)?$"))
				ouvrirLivre();
			else if (cmd.matches("^sauvegarderLivre( .*)?$"))
				sauvegarderLivre();
			else if (cmd.matches("^supprimerLivre( .*)?$"))
				supprimerLivre();
			else if (cmd.matches("^changerTitreLivre( .*)?$"))
				changerTitreLivre();
			else if (cmd.matches("^afficherListeSections( .*)?$"))
				afficherListeSections();
			else if (cmd.matches("^afficherSection( .*)?$"))
				afficherSection();
			else if (cmd.matches("^afficherListeEnchainements( .*)?$"))
				afficherListeEnchainements();
			else if (cmd.matches("^afficherListeObjetsEnchainement( .*)?$"))
				afficherListeObjetsEnchainement();
			else if (cmd.matches("^afficherListeObjetsSection( .*)?$"))
				afficherListeObjetsSection();
			else if (cmd.matches("^creerSection( .*)?$"))
				creerSection();
			else if (cmd.matches("^modifierTexteSection( .*)?$"))
				modifierTexteSection();
			else if (cmd.matches("^ajouterObjetSection( .*)?$"))
				ajouterObjetSection();
			else if (cmd.matches("^supprimerObjetSection( .*)?$"))
				supprimerObjetSection();
			else if (cmd.matches("^afficherTexteSection( .*)?$"))
				afficherTexteSection();
			else if (cmd.matches("^creerEnchainement( .*)?$"))
				creerEnchainement();
			else if (cmd.matches("^afficherTexteEnchainement( .*)?$"))
				afficherTexteEnchainement();
			else if (cmd.matches("^modifierTexteEnchainement( .*)?$"))
				modifierTexteEnchainement();
			else if (cmd.matches("^ajouterObjetEnchainement( .*)?$"))
				ajouterObjetEnchainement();
			else if (cmd.matches("^afficherSourceEnchainement( .*)?$"))
				afficherSourceEnchainement();
			else if (cmd.matches("^afficherDestinationEnchainement( .*)?$"))
				afficherDestinationEnchainement();
			else if (cmd.matches("^setSourceEnchainement( .*)?$"))
				setSourceEnchainement();
			else if (cmd.matches("^setDestinationEnchainement( .*)?$"))
				setDestinationEnchainement();
			else if (cmd.matches("^supprimerObjetEnchainement( .*)?$"))
				supprimerObjetEnchainement();
			else if (cmd.matches("^creerObjet( .*)?$"))
				creerObjet();
			else if (cmd.matches("^afficherNomObjet( .*)?$"))
				afficherNomObjet();
			else if (cmd.matches("^setNomObjet( .*)?$"))
				setNomObjet();
			else if (cmd.matches("^supprimerObjet( .*)?$"))
				supprimerObjet();
			else if (cmd.matches("afficherListeObjets( .*)?$"))
				afficherListeObjets();
			else if (cmd.matches("analyserGraphe( .*)?$"))
				analyserGraphe();
			else if (cmd.matches("^quit( .*)?$"))
				quit = true;
			else
				System.out.println("Erreur commande inconnue");
		} while (!quit);

	}

	private void listerCommandes() {
		System.out
				.println("-- Commandes Système\nlisterCommandes\nquit\n\n-- Gestion livre sur le disque\ncreerLivre nom chemin\nouvrirLivre chemin\nsauvegarderLivre\nsupprimerLivre\n\n-- Gestion du contenu du livre\nchangerTitreLivre titre\nanalyserGraphe\n\n-- Gestion des sections\ncreerSection texte\ncreerSectionAvecEnsemble texte idObj1 idObj2 ...\nmodifierTexteSection idSection texte\najouterObjetSection idSection idObjet\nafficherListeSections\nafficherSection id\nafficherTexteSection idSection\nafficherListeObjetsSection idSection\nsupprimerObjetSection idSection idObjet\n\n-- Gestion des enchainements\ncreerEnchainement idSectionSrc idSectionDst texte\nsetSourceEnchainement idEnchainement idSection\nsetDestinationEnchainement idEnchainement idSection\nmodifierTexteEnchainement idEnchainement texte\najouterObjetEnchainement idEnchainement idObjet\nafficherListeEnchainements\nafficherListeObjetsEnchainement idEnchainement\nafficherTexteEnchainement idEnchainement\nafficherSourceEnchainement idEnchainement\nafficherDestinationEnchainement idEnchainement\nsupprimerObjetEnchainement idEnchainement idObjet\n\n-- Gestion des objets\ncreerObjet nom\nafficherNomObjet idObjet\nsetNomObjet idObjet nom\nsupprimerObjet idObjet\n");
	}

	private void creerLivre() {
		String nom, chemin;
		System.out.print("nom : ");
		nom = scanner.nextLine();
		System.out.print("chemin : ");
		chemin = scanner.nextLine();

		try {
			ctrl.creerLivre(nom, chemin);
		} catch (IOException e) {
			System.out.println("Erreur : écriture sur le disque impossible");
		} catch (NamingException e) {
			System.out.println("Erreur : nom invalide");
		}
		System.out.println("-----");
	}

	private void ouvrirLivre() {
		String chemin;
		System.out.print("Chemin : ");
		chemin = scanner.nextLine();
		try {
			ctrl.ouvrirLivre(chemin);
		} catch (IOException e) {
			System.out.println("Erreur : écriture sur le disque impossible");
		}
		System.out.println("-----");
	}

	private void sauvegarderLivre() {
		try {
			ctrl.sauvegarderLivre();
		} catch (IOException e) {
			System.out.println("Erreur : écriture sur le disque impossible");
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void supprimerLivre() {
		try {
			ctrl.supprimerLivre();
		} catch (IOException e) {
			System.out.println("Erreur : écriture sur le disque impossible");
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void changerTitreLivre() {
		String titre;
		System.out.print("Titre : ");
		titre = scanner.nextLine();
		try {
			ctrl.changerTitre(titre);
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void creerSection() {
		String texte;
		System.out.print("texte : ");
		texte = scanner.nextLine();

		try {
			System.out.println(" ==> " + ctrl.ajouterSection(texte));
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void modifierTexteSection() {
		String idSection, text;
		System.out.print("idSection : ");
		idSection = scanner.nextLine();
		System.out.print("texte : ");
		text = scanner.nextLine();

		try {
			ctrl.modifierTextSection(Integer.parseInt(idSection), text);
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void ajouterObjetSection() {
		String idSection, idObjet;
		System.out.print("idSection : ");
		idSection = scanner.nextLine();
		System.out.print("idObjet : ");
		idObjet = scanner.nextLine();

		try {
			ctrl.ajouterObjetSection(Integer.parseInt(idSection),
					Integer.parseInt(idObjet));
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void supprimerObjetSection() {
		String idSection, idObjet;
		System.out.print("idSection : ");
		idSection = scanner.nextLine();
		System.out.print("idObjet : ");
		idObjet = scanner.nextLine();

		try {
			ctrl.supprimerObjetSection(Integer.parseInt(idSection),
					Integer.parseInt(idObjet));
		} catch (UnknownObjetException e) {
			System.out.println("UnknownObjetException");
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void afficherTexteSection() {
		String idSection;
		System.out.print("idSection : ");
		idSection = scanner.nextLine();

		try {
			System.out
					.println(ctrl.getTextSection(Integer.parseInt(idSection)));
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void afficherSection() {
		String id;
		System.out.print("id : ");
		id = scanner.nextLine();

		afficherSection(Integer.parseInt(id));
		System.out.println("-----");
	}

	private void afficherSection(Integer idSection) {
		Collection<Integer> idObjets;
		Collection<Integer> idEnchainements;

		try {
			idObjets = ctrl.getListeObjetsSection(idSection);
			idEnchainements = ctrl.getListeEnchainement();
			System.out.println("Id : " + idSection);
			System.out.println("Texte : " + ctrl.getTextSection(idSection));
			System.out.println("Objets : ");
			for (Integer idObjet : idObjets) {
				System.out.println(" - " + ctrl.getNomObjet(idObjet));
			}
			System.out.println("Enchainements : ");
			for (Integer idEnchainement : idEnchainements) {
				if (ctrl.getSourceEnchainement(idEnchainement) == idSection)
					System.out.println(" - "
							+ ctrl.getTexteEnchainement(idEnchainement));
			}

		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
	}

	private void afficherListeSections() {
		Collection<Integer> idSections;
		try {
			idSections = ctrl.getListeSection();

			// Note : Limiter l'affichage du texte des enchainements ??
			for (Integer idSection : idSections) {
				afficherSection(idSection);
			}
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");

	}

	private void afficherListeObjetsSection() {
		String idSection;
		System.out.print("idSection : ");
		idSection = scanner.nextLine();

		try {
			Collection<Integer> retour = ctrl.getListeObjetsSection(Integer
					.parseInt(idSection));
			for (Integer idObjet : retour) {
				System.out.println(" - " + ctrl.getNomObjet(idObjet));
			}
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void afficherListeEnchainements() {
		try {
			Collection<Integer> retour = ctrl.getListeEnchainement();
			for (Integer idE : retour) {
				System.out.println(idE + " : " + ctrl.getTexteEnchainement(idE));
			}
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void afficherListeObjetsEnchainement() {
		String idEnchainement;
		System.out.print("idEnchainement : ");
		idEnchainement = scanner.nextLine();

		try {
			Collection<Integer> retour = ctrl
					.getListeObjetsEnchainement(Integer
							.parseInt(idEnchainement));
			for (Integer idObjet : retour) {
				System.out.println(" - " + ctrl.getNomObjet(idObjet));
			}
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void creerEnchainement() {
		String idSectionSrc, idSectionDst, texte;
		System.out.print("idSectionSrc : ");
		idSectionSrc = scanner.nextLine();
		System.out.print("idSectionDst : ");
		idSectionDst = scanner.nextLine();
		System.out.print("texte : ");
		texte = scanner.nextLine();

		try {
			System.out.println(" ==> "
					+ ctrl.creerEnchainement(Integer.parseInt(idSectionSrc),
							Integer.parseInt(idSectionDst), texte));
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void modifierTexteEnchainement() {
		String idEnchainement, texte;
		System.out.print("idEnchainement : ");
		idEnchainement = scanner.nextLine();
		System.out.print("texte : ");
		texte = scanner.nextLine();

		try {
			ctrl.modifierTextEnchainement(Integer.parseInt(idEnchainement),
					texte);
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void ajouterObjetEnchainement() {
		String idEnchainement, idObjet;
		System.out.print("idEnchainement : ");
		idEnchainement = scanner.nextLine();
		System.out.print("idObjet : ");
		idObjet = scanner.nextLine();

		try {
			ctrl.ajouterObjetEnchainement(Integer.parseInt(idEnchainement),
					Integer.parseInt(idObjet));
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void setSourceEnchainement() {
		String idEnchainement, idSection;
		System.out.print("idEnchainement : ");
		idEnchainement = scanner.nextLine();
		System.out.print("idSection : ");
		idSection = scanner.nextLine();

		try {
			ctrl.setSourceEnchainement(Integer.parseInt(idEnchainement),
					Integer.parseInt(idSection));
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void setDestinationEnchainement() {
		String idEnchainement, idSection;
		System.out.print("idEnchainement : ");
		idEnchainement = scanner.nextLine();
		System.out.print("idSection : ");
		idSection = scanner.nextLine();

		try {
			ctrl.setDestinationEnchainement(Integer.parseInt(idEnchainement),
					Integer.parseInt(idSection));
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void afficherSourceEnchainement() {
		String idEnchainement;
		System.out.print("idEnchainement : ");
		idEnchainement = scanner.nextLine();

		try {
			afficherSection(ctrl.getSourceEnchainement(Integer
					.parseInt(idEnchainement)));
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void afficherDestinationEnchainement() {
		String idEnchainement;
		System.out.print("idEnchainement : ");
		idEnchainement = scanner.nextLine();

		try {
			afficherSection(ctrl.getDestinationEnchainement(Integer
					.parseInt(idEnchainement)));
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void afficherTexteEnchainement() {
		String idEnchainement;
		System.out.print("idEnchainement : ");
		idEnchainement = scanner.nextLine();

		try {
			System.out.println(ctrl.getTexteEnchainement(Integer
					.parseInt(idEnchainement)) + "\n");
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void supprimerObjetEnchainement() {
		String idEnchainement, idObjet;
		System.out.print("idEnchainement : ");
		idEnchainement = scanner.nextLine();
		System.out.print("idObjet : ");
		idObjet = scanner.nextLine();

		try {
			ctrl.supprimerObjetEnchainement(Integer.parseInt(idEnchainement),
					Integer.parseInt(idObjet));
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void afficherListeObjets() {
		try {
			Collection<Integer> retour = ctrl.getListeObjets();
			for (Integer idObjet : retour) {
				System.out.println(" - " + idObjet + " : " + ctrl.getNomObjet(idObjet));
			}
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void creerObjet() {
		String nom;
		System.out.print("nom : ");
		nom = scanner.nextLine();

		try {
			System.out.println(" ==> " + ctrl.ajouterObjet(nom));
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void afficherNomObjet() {
		String idObjet;
		System.out.print("idObjet : ");
		idObjet = scanner.nextLine();

		try {
			System.out.println(" - "
					+ ctrl.getNomObjet(Integer.parseInt(idObjet)));
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void setNomObjet() {
		String idObjet, nom;
		System.out.print("idObjet : ");
		idObjet = scanner.nextLine();
		System.out.print("nom : ");
		nom = scanner.nextLine();

		try {
			ctrl.setNomObjet(Integer.parseInt(idObjet), nom);
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void supprimerObjet() {
		String idObjet;
		System.out.print("idObjet : ");
		idObjet = scanner.nextLine();

		try {
			ctrl.supprimerObjet(Integer.parseInt(idObjet));
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

	private void analyserGraphe() {
		try {
			Collection<Integer> retour = ctrl.analyserGraphe();
			for (Integer idSection : retour) {
				System.out.println("Section " + idSection + " innateignable");
			}
		} catch (UninitializedLivreException e) {
			System.out.println("Erreur : aucun livre ouvert");
		}
		System.out.println("-----");
	}

}
