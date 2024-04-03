package metier.entities;

import java.io.Serializable;

public class voyage implements Serializable{
	private Long idvoyage;
	private String nomvoyage;
	private double prix;
	
	public voyage() {
		super();
	}
	public voyage(String nomvoyage, double prix) {
		super();
		this.nomvoyage = nomvoyage;
		this.prix = prix;
	}
	public Long getIdvoyage() {
		return idvoyage;
	}
	public void setIdvoyage(Long idvoyage) {
		this.idvoyage = idvoyage;
	}
	public String getNomvoyage() {
		return nomvoyage;
	}
	public void setNomvoyage(String nomvoyage) {
		this.nomvoyage = nomvoyage;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "voyage [idvoyage=" + idvoyage + ", nomvoyage=" + nomvoyage + ", prix=" + prix + "]";
	}
	
	
	
}

