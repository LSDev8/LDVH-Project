package livre;

import java.util.ArrayList;
import java.util.Collection;


public class Enchainement {
	private Integer id;
	private String text;
	private Section source, dest;
	private ArrayList<Integer> objetsID;
	
	public Enchainement(Integer id, Section S, Section D, String text){
		this.id = id;
		source = S;
		dest = D;
		this.text = text;
		this.objetsID = new ArrayList<>();
	}

	public Collection<Integer> getObjets() {
		return this.objetsID;
	}
	
	//Nécessaire pour respecter l'unicité des IDs malgré les 
	//suppressions.
	public void setID(Integer id){
		this.id = id;
	}
	
	public Integer getID(){
		return id;
	}
	
	public void setText(String s){
		text = s;
	}
	
	public String getText(){
		return text;
	}
	
	public void addObjet(Integer id){
		objetsID.add(id);
	}
	
	public void delObjet(Integer id){
		objetsID.remove(id);
	}
	
	public void setSource(Section S){
		source = S;
	}
	public void setDestination(Section D){
		dest = D;
	}

	public Section getSource() {
		return source;
	}

	public Section getDest() {
		return dest;
	}
}
