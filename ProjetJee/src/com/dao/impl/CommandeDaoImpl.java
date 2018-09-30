package com.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.dao.CommandeDao;
import com.model.Commande;
import com.util.HibernateUtil;

public class CommandeDaoImpl  implements CommandeDao{
	Session session= HibernateUtil.openSession();

	@Override
	public void add(Commande e) {
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();		
	}

	@Override
	public Object edite(Commande e) {
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
	public List<Commande> findAll() {
		return session.createQuery("Select o from Commande o").list();
	}

	@Override
	public Commande findById(Long id) {
		return  session.get(Commande.class, id) ;
	}
	
	@Override
	public List<Commande> findByIdClient(Long idClient) {
		return session.createQuery("Select o from Commande o where idClient='"+idClient+"'").list();
	}


}
