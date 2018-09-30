package com.dao;

import java.util.List;

import com.model.Produit;

public interface ProduitDao {
public 	void add(Produit e);
	
	public Object edite(Produit e);
	
	public void delete(Long id);
	
	public List<Produit> findAll();
	
	public Produit findById(Long id);
}
