package com.dao;

import java.util.List;

import com.model.Categorie;

public interface CategorieDao  {
	public 	void add(Categorie e);
	
	public Object edite(Categorie e);
	
	public void delete(Long id);
	
	public List<Categorie> findAll();
	
	public Categorie findById(Long id);

}
