package livre;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import sections.ISections;



public class Sections implements ISections {
	private static final int NB_MAX_SECTIONS = 100 ; /* Nombre maximum de sections pouvant être créées. */
	private String sections [] ;                     /* Tableau de String servant à représenter le contenu textuel des sections */
	private ArrayList <Integer> objets [] ;          /* Tableau de liste d'entiers servant à représenter les objets contenus dans les sections */
	
	
	/**
	 * Constructeur pour un ensemble de sections.
	 * S'occupe d'initialiser les structures nécessaires.
	 */
	public Sections () {
		int i ;
		
		this.sections = new String [NB_MAX_SECTIONS] ;
		for (i = 0 ; i < NB_MAX_SECTIONS ; i ++)
			this.sections [i] = null ;
		
		this.objets = new ArrayList [NB_MAX_SECTIONS] ;
		for (i = 0 ; i < NB_MAX_SECTIONS ; i ++)
			this.objets [i] = null ;
	}
	
	
	/**
	 * Permet de vérifier si une section est valide.
	 * @param id l'identifiant de la section à tester.
	 * @throws InvalidParameterException si la section n'existe pas.
	 */
	private void verifierSection (int id) {
		if (id < 0 || id >= NB_MAX_SECTIONS || this.sections [id] == null)
			throw new InvalidParameterException ("L'identifiant de section est incorrect.") ;
	}
	
	
	/**
	 * Permet de mettre-à-jour le texte d'une section.
	 * @param id l'identifiant de la section à modifier.
	 * @parem texte le nouveau texte de la section.
	 */
	public void setTexteSection (int id, String texte) {
		this.verifierSection (id) ;
		this.sections [id] = texte ;
	}

	
	/**
	 * Permet de récupérer le texte d'une section.
	 * @param id l'identifiant de la section à récupérer.
	 * @return le texte de la section d'identifiant id.
	 */
	public String getTexteSection (int id) {
		this.verifierSection (id) ;
		return this.sections [id] ;
	}


	/**
	 * Permet de récupérer la liste des sections.
	 * @return l'ensemble des sections.
	 */
	public String [] listerSections () {
		return this.sections ;
	}


	/**
	 * Permet de créer une nouvelle section.
	 * Ajoute une nouvelle section au jeu ayant pour texte une chaîne vide.
	 * @throws InvalidParameterException si il n'y a plus de place pour créer une nouvelle section.
	 * @return l'identifiant de la section fraîchement créée.
	 */
	public int creerSection () {
		int i ;
		
		for (i = 0 ; i < NB_MAX_SECTIONS ; i ++)
			if (this.sections [i] == null)
				break ;
		
		if (i == NB_MAX_SECTIONS)
			throw new InvalidParameterException ("Nombre maximum de section atteint.") ;
		
		this.sections [i] = "" ;
		this.objets [i] = new ArrayList <Integer> () ;
		
		return i ;			
	}

	
	/**
	 * Permet de supprimer une section.
	 * @param id identifiant de la section à supprimer.
	 */
	public void supprimerSection (int id) {
		this.verifierSection (id) ;
		this.sections [id] = null ;
		this.objets [id] = null ;
	}

	
	/**
	 * Permet d'ajouter un objet à une section.
	 * @param idSect identifiant de la section.
	 * @param idObj identifiant de l'objet.
	 */
	public void addObjets (int idSect, int idObj) {
		this.verifierSection (idSect) ;
		this.objets [idSect].add (idObj) ;
	}

	
	/**
	 * Permet de supprimer l'ensemble des objets d'une section.
	 * @param id l'identifiant de la section dont il faut supprimer les objets.
	 */
	public void removeObjets (int id) {
		this.verifierSection (id) ;
		this.objets [id] = new ArrayList <Integer> () ;
	}
}
