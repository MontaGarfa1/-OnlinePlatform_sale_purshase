package com.services.impl;

import java.util.List;

import com.dao.CommandeDao;
import com.dao.impl.CommandeDaoImpl;
import com.model.Commande;
import com.services.CommandeServices;

public class CommandeServicesImpl  implements CommandeServices{
	CommandeDao dao = new CommandeDaoImpl();

	@Override
	public void add(Commande e) {
		dao.add(e);
		}

	@Override
	public Object edite(Commande e) {
		return dao.edite(e);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public List<Commande> findAll() {
		return dao.findAll();
	}

	@Override
	public Commande findById(Long id) {
		return dao.findById(id);
	}
	@Override
	public List<Commande> findByIdClient(Long idClient) {
		return dao.findByIdClient(idClient);
	}
	
	

}
