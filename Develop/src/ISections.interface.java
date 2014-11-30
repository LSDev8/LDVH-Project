package sections;
import java.util.ArrayList;


public interface ISections {
	void setTexteSection (int id, String texte) ;
	String getTexteSection (int id) ;
	String [] listerSections () ;
	int creerSection () ;
	void supprimerSection (int id) ;
	void addObjets (int idSect, int idObj) ;
	void removeObjets (int id) ;
}
