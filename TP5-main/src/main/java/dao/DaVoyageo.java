package dao;
import java.util.List;

import metier.entities.voyage;
public interface IvoyageDao {
public voyage save(voyage p);
public List<voyage> voyagesParMC(String mc);
public voyage getvoyage(Long id);
public voyage updatevoyage(voyage p);
public void deletevoyage(Long id);
}
