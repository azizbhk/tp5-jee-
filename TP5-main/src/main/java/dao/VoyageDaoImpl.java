package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.voyage;
import util.JPAutil;
public class voyageDaoImpl implements IvoyageDao {
private EntityManager entityManager=JPAutil.getEntityManager("TP5_JEE");
@Override
public voyage save(voyage p) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.persist(p);
	tx.commit();
	return p;
	}
	@Override
	public List<voyage> voyagesParMC(String mc) {
	List<voyage> prods = entityManager.createQuery("select p from voyage p where p.nomvoyage like :mc").setParameter("mc", "%"+mc+"%").getResultList();
	 return prods;
	}
	@Override
	public voyage getvoyage(Long id) {
	 return entityManager.find(voyage.class, id);
	}
	@Override
	public voyage updatevoyage(voyage p) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.merge(p);
	tx.commit();
	return p;
	}
	@Override
	public void deletevoyage(Long id) {
	voyage voyage = entityManager.find(voyage.class, id);
	entityManager.getTransaction().begin();
	entityManager.remove(voyage);
	entityManager.getTransaction().commit();
	}
	}
