package com.services.impl;

import java.util.List;

import com.dao.ProduitDao;
import com.dao.impl.ProduitDaoImpl;
import com.model.Produit;
import com.services.ProduitServices;

public class ProduitServicesImpl  implements ProduitServices{
	ProduitDao dao = new ProduitDaoImpl();

	@Override
	public void add(Produit e) {
		dao.add(e);
		}

	@Override
	public Object edite(Produit e) {
		return dao.edite(e);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public List<Produit> findAll() {
		return dao.findAll();
	}

	@Override
	public Produit findById(Long id) {
		return dao.findById(id);
	}


}
