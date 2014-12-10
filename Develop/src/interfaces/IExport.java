package interfaces;


public interface IExport {
    public void exportToText(String chemin);
    public void exportToHTML(String chemin);
    public void exportToXml(String chemin);
    public void importFromXml(String chemin);
}
