public class Objet implements IObjet {

	private String nom;
	private Integer id;

	public Objet() {
		this.nom = null;
		this.id = null;
	}

	public Objet(Integer id, String nom) {
		this.nom = nom;
		this.id = id;
	}

	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

}
