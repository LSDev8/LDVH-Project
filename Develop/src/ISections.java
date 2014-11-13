public interface ISections{
    public Integer creerSection();
    public Integer setTexteSection (Integer id, String texte);
    public String getTexteSection (Integer id);
    public void supprimerSection (Integer id);
    public void addObjets(Integer idSect, Integer idObj);
    public void removeObjets(Integer id);
    public String[] listerSections();
}
