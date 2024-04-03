package com.nadhem.test;

import com.nadhem.dao.ClientDao;
import com.nadhem.entities.Client;

public class ClientTest {
	public static void main(String[] args) {
		//créer un objet client
		Client c = new Client();
		c.setNom("Bel Hadj Nadhem");
		c.setVille("Nabeul");
		
		Client c1 = new Client();
		c1.setNom("Bel Hadj yassine");
		c1.setVille("Tunis");
		
		0
		//ajouter l'objet client à la BD
		ClientDao cltDao = new ClientDao();
		cltDao.ajouter(c);
		cltDao.ajouter(c1);
		
		
		System.out.println("Appel de la méthode listerTous");
		for (Client cl : cltDao.listerTous())
			System.out.println(cl.getCode()+" "+cl.getNom());
		
		
		System.out.println("Appel de la méthode listerParNom");
		for (Client cl : cltDao.listerParNom("nadh"))
			System.out.println(cl.getCode()+" "+cl.getNom());
		
		//tester les autres méthodes de la classe ClientDao
	}
}