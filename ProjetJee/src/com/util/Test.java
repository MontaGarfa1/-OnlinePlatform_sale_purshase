package com.util;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.dao.ClientDao;
import com.dao.ProduitDao;
import com.dao.impl.ClientDaoImpl;
import com.dao.impl.ProduitDaoImpl;
import com.model.Client;
import com.model.Commande;
import com.model.Produit;
import com.services.ClientServices;
import com.services.CommandeServices;
import com.services.ProduitServices;
import com.services.impl.ClientServicesImpl;
import com.services.impl.CommandeServicesImpl;
import com.services.impl.ProduitServicesImpl;


public class Test {
	
	static Session session= HibernateUtil.openSession();
	public static Logger log = Logger.getLogger(Test.class);
	public static void main(String[] args) {

		
		//session.createQuery("select o from Client o").list();

		/*CommandeServices p = new CommandeServicesImpl();
		List<Commande> list ;
		list = p.findAll();
		for(int i = 0;i<list.size();i++) {
			log.info("Produit Name :"+list.get(i).getName());
		}
	*/
	/*	ProduitDao dao = new ProduitDaoImpl();
		Produit c = new Produit();
		c.setIdCategorie((long) 1);
		c.setIdProduit((long) 3);
		c.setImages("Montassar");
		c.setName("Samsung");
		c.setPrice((double) 11);
		c.setStock((long) 10);
		dao.add(c);
		ClientServices p = new ClientServicesImpl();
		Client c = p.findByUsername("2");
		log.info("Client Name :"+c.getFirstName());
		System.out.println("ooooooooooooooooooooooo");
		log.info("Montaoooooooooooooo");
		*/
		CommandeServices c= new CommandeServicesImpl();
		List<Commande> listC ;
		listC = c.findByIdClient((long) 5);
		for(int i = 0;i<listC.size();i++) {
			log.info("Commande Name :"+listC.get(i).getIdClient());
		}
		
	}

}
