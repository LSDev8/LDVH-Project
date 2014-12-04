import java.io.FileNotFoundException;
import java.io.IOException;

public interface ILivre {
    public void creerLivre (String nom, String chemin) ;
    public void ouvrirChemin (String chemin) throws IOException ;
    public void sauvegarderLivre () throws IOException ;
    public void supprimerLivre () ;
    public ISections getSections () ;
    public IEnchainements getEnchainements () ;
    public IObjets getObjets () ;
}
