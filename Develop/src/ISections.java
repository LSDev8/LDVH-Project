public interface ISections{
    public Integer creerSection();
    public Integer setTexteSection (Integer id, String texte);
    public String getTexteSection (Integer id);
    public void supprimerSection (Integer id);
    public void addObjet(Integer idSect, Integer idObj);
    public void removeObjet(Integer id) throws UnknownObjetException;
    public String[] listerSections();
}
