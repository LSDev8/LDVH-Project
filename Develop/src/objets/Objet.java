package objets;

public class Objet {

	private String nom;
	private Integer id;

	public Objet() {
		this.nom = "";
		this.id = null;
	}

	public Objet(Integer id, String nom) {
		this.nom = nom;
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public Integer getId() {
		return id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
