public interface ILivre {
    void creerLivre (String nom, String chemin) ;
    void ouvrirChemin (String chemin) ;
    void sauvegarderLivre () ;
    void supprimerLivre () ;
    ISections getSections () ;
    IEnchainements getEnchainements () ;
    IOBjets getObjets () ;
}