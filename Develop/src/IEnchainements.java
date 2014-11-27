public interface IEnchainements{
	public Integer creationEnchainement(Integer idSectSec, Integer idSectDest);
	public void setTextEnchainement(Integer id, String text);
	public void supprimerEnchainement(Integer id);
	public void addObjet(Integer id);
	public void removeObjet(Integer id);
}
