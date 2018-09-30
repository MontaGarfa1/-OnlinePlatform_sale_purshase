package com.dao;

import java.util.List;

import com.model.Commande;

public interface CommandeDao {
public 	void add(Commande e);
	
	public Object edite(Commande e);
	
	public void delete(Long id);
	
	public List<Commande> findAll();
	
	public Commande findById(Long id);
	
	public List<Commande> findByIdClient(Long idClient);

}
