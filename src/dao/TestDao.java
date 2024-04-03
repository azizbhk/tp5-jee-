package dao;

import java.util.List;

import metier.entities.voyage;

public class TestDao {

	public static void main(String[] args) {
		voyageDaoImpl pdao= new voyageDaoImpl();
		voyage prod= pdao.getvoyage(2L);
		System.out.println(prod);
		prod.setNomvoyage("toto");
		pdao.updatevoyage(prod);
		System.out.println("after update " +prod);
		
		
	}

}
