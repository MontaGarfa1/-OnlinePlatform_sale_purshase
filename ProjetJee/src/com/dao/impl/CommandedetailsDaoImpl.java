package com.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.dao.CommandedetailsDao;
import com.model.Commande;
import com.model.Commandedetails;
import com.util.HibernateUtil;

public class CommandedetailsDaoImpl  implements CommandedetailsDao{
	Session session= HibernateUtil.openSession();

	@Override
	public void add(Commandedetails e) {
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();		
	}

	@Override
	public Object edite(Commandedetails e) {
		session.beginTransaction();
		Object p = (Object) session.merge(e);
		session.getTransaction().commit();
		return p;
	}

	@Override
	public void delete(Long id) {
		session.beginTransaction();
		Object p= findById(id);
		session.delete(p);
		session.getTransaction().commit();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commandedetails> findAll() {
		return session.createQuery("Select o from Commandedetails o").list();
	}

	@Override
	public Commandedetails findById(Long id) {
		return  session.get(Commandedetails.class, id) ;
	}
	
	@Override
	public List<Commandedetails> findByIdCommande(Long idClient) {
		return session.createQuery("Select o from Commandedetails o where idCommande='"+idClient+"'").list();
	}
}
