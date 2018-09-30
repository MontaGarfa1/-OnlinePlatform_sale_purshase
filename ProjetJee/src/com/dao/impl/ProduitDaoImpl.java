package com.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.dao.ProduitDao;
import com.model.Produit;
import com.util.HibernateUtil;

public class ProduitDaoImpl  implements ProduitDao{
	Session session= HibernateUtil.openSession();

	@Override
	public void add(Produit e) {
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();		
	}

	@Override
	public Object edite(Produit e) {
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
	public List<Produit> findAll() {
		return session.createQuery("Select o from Produit o").list();
	}

	@Override
	public Produit findById(Long id) {
		return  session.get(Produit.class, id) ;
	}

}
