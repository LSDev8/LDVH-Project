package sections;
import java.security.InvalidParameterException;
import java.util.ArrayList;


public class Sections implements ISections {
	private static final int NB_MAX_SECTIONS = 100 ; /* Nombre maximum de section pouvant être créées. */
	private String sections [] ;                     /* Tableau de String servant à représenter le contenu textuel des sections */
	
	
	/**
	 * Constructeur pour un ensemble de sections.
	 * S'occupe d'initialiser les structures nécessaires.
	 */
	public Sections () {
		int i ;
		
		this.sections = new String [NB_MAX_SECTIONS] ;
		for (i = 0 ; i < NB_MAX_SECTIONS ; i ++)
			sections [i] = null ;
	}
	
	
	/**
	 * Permet de mettre à jour le texte d'une section.
	 * @param id l'identifiant de la section à modifier.
	 * @parem texte nouveau texte de la section à modifier.
	 * @throws InvalidParameterException si l'identifiant de la section est incorrecte.
	 */
	public void setTexteSection (int id, String texte) {
		if (id < 0 || id >= NB_MAX_SECTIONS || this.sections [id] == null)
			throw new InvalidParameterException ("L'identifiant de section est incorrecte.") ;
		
		this.sections [id] = texte ;
	}

	
	/**
	 * Permet de récupérer le texte d'une section.
	 * @param id l'identifiant de la section à récupérer.
	 * @throws InvalidParameterException si l'identifiant de la section est incorrecte.
	 * @return le texte de la section d'identifiant id.
	 */
	public String getTexteSection (int id) {
		if (id < 0 || id >= NB_MAX_SECTIONS || this.sections [id] == null)
			throw new InvalidParameterException ("L'identifiant de section est incorrecte.") ;
		
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
		
		sections [i] = "" ;
		return i ;			
	}

	
	/**
	 * Permet de suppriomer une section.
	 * @param id identifiant de la section à supprimer.
	 * @throws InvalidParameterException si l'identifiant de la section est incorrecte.
	 */
	public void supprimerSection (int id) {
		if (id < 0 || id >= NB_MAX_SECTIONS || this.sections [id] == null)
			throw new InvalidParameterException ("L'identifiant de section est incorrecte.") ;
		
		this.sections [id] = null ;
	}


	public void addObjets (int idSect, int idObj) {
		/* À faire */
	}


	public void removeObjets (int id) {	
		/* À faire */
	}
}
