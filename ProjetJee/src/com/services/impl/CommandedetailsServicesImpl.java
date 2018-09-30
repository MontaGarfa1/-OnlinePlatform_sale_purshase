package com.services.impl;

import java.util.List;

import com.dao.CommandedetailsDao;
import com.dao.impl.CommandedetailsDaoImpl;
import com.model.Commandedetails;
import com.services.CommandedetailsServices;

public class CommandedetailsServicesImpl  implements CommandedetailsServices{
	CommandedetailsDao dao = new CommandedetailsDaoImpl();

	@Override
	public void add(Commandedetails e) {
		dao.add(e);
		}

	@Override
	public Object edite(Commandedetails e) {
		return dao.edite(e);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public List<Commandedetails> findAll() {
		return dao.findAll();
	}

	@Override
	public Commandedetails findById(Long id) {
		return dao.findById(id);
	}
	@Override
	public List<Commandedetails> findByIdCommande(Long idClient) {
		return dao.findByIdCommande(idClient);
	}

}
