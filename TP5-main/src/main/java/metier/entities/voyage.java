package metier.entities;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity 
@Table(name = "voyageS")
public class voyage implements Serializable{
@Id
@Column (name="ID_voyage")
@GeneratedValue (strategy=GenerationType.IDENTITY) 
private Long idvoyage;
@Column (name="NOM_voyage")
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
}
