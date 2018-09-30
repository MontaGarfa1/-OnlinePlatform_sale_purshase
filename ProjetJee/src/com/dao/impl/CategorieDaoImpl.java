package com.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.dao.CategorieDao;
import com.model.Categorie;
import com.util.HibernateUtil;

public class CategorieDaoImpl  implements CategorieDao{
	Session session= HibernateUtil.openSession();

	@Override
	public void add(Categorie e) {
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();		
	}

	@Override
	public Object edite(Categorie e) {
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
	public List<Categorie> findAll() {
		return session.createQuery("Select o from Categorie o").list();
	}

	@Override
	public Categorie findById(Long id) {
		return  session.get(Categorie.class, id) ;
	}

}
