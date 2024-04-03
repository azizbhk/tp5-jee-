package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.voyage;

public class voyageModele {
	private String motCle;
	List<voyage> voyages = new ArrayList<>();
	
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<voyage> getvoyages() {
		return voyages;
	}
	public void setvoyages(List<voyage> voyages) {
		this.voyages = voyages;
	}
	
	

}
