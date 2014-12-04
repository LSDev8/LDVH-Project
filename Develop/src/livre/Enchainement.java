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
	}

	public Collection<Integer> getObjets() {
		return null;
	}
	
	public Integer getID(){
		return id;
	}
	
	public void setText(String s){
		text = s;
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
}
