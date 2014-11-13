public interface ILivre {
    public void creerLivre (String nom, String chemin) ;
    public void ouvrirChemin (String chemin) ;
    public void sauvegarderLivre () ;
    public void supprimerLivre () ;
    public ISections getSections () ;
    public IEnchainements getEnchainements () ;
    public IOBjets getObjets () ;
}
