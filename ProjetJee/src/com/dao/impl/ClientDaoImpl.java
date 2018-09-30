package com.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.dao.ClientDao;
import com.model.Client;
import com.util.HibernateUtil;

public class ClientDaoImpl  implements ClientDao{
	Session session= HibernateUtil.openSession();

	@Override
	public void add(Client e) {
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();		
	}

	@Override
	public Client edite(Client e) {
		session.beginTransaction();
		Client p =  (Client) session.merge(e);
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
	public List<Client> findAll() {
		return session.createQuery("Select o from Client o").list();
	}

	@Override
	public Client findById(Long id) {
		return  session.get(Client.class, id) ;
	}
	@Override
	public Client findByUsername(String username) {
		return  (Client) session.createQuery("Select o from Client o where username='"+username+"' ").uniqueResult() ;
	}

}
