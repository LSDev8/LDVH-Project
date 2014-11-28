import java.util.ArrayList;
import java.util.Collection;

public interface IObjets extends Collection<IObjet>{
	public Integer creationObjet(String nom);

	public String getNomObjet(Integer id);

	public void setNomObjet(Integer id, String nom);

	public void supprimerObjet(Integer id);

	public ArrayList<IObjet> getObjets();
	
}
