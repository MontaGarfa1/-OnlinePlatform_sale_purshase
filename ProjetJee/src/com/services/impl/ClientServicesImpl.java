package com.services.impl;

import java.util.List;

import com.dao.ClientDao;
import com.dao.impl.ClientDaoImpl;
import com.model.Client;
import com.services.ClientServices;

public class ClientServicesImpl  implements ClientServices{
	ClientDao dao = new ClientDaoImpl();

	@Override
	public void add(Client e) {
		dao.add(e);
		}

	@Override
	public Client edite(Client e) {
		return dao.edite(e);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public List<Client> findAll() {
		return dao.findAll();
	}

	@Override
	public Client findById(Long id) {
		return dao.findById(id);
	}
	@Override
	public Client findByUsername(String username){
		return dao.findByUsername(username);
	}


}
