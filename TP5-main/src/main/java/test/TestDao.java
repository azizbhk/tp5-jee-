package test;
import java.util.List;

import dao.voyageDaoImpl;
import metier.entities.voyage;

public class TestDao {

	public static void main(String[] args) {
		voyageDaoImpl pdao= new voyageDaoImpl();
		voyage prod= pdao.save(new voyage("iphone 8 plus",2800));
		System.out.println(prod);
		List<voyage> prods =pdao.voyagesParMC("Dell");
		for (voyage p : prods)
		System.out.println(p);
		}
}
