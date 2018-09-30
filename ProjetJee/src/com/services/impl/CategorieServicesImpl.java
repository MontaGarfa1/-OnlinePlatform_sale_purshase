package com.services.impl;

import java.util.List;

import com.dao.CategorieDao;
import com.dao.impl.CategorieDaoImpl;
import com.model.Categorie;
import com.services.CategorieServices;

public class CategorieServicesImpl  implements CategorieServices{
	CategorieDao dao = new CategorieDaoImpl();

	@Override
	public void add(Categorie e) {
		dao.add(e);
		}

	@Override
	public Object edite(Categorie e) {
		return dao.edite(e);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	public List<Categorie> findAll() {
		return dao.findAll();
	}

	@Override
	public Categorie findById(Long id) {
		return dao.findById(id);
	}

}
