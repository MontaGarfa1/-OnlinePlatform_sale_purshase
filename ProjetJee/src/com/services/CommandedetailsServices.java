package com.services;

import java.util.List;

import com.model.Commandedetails;

public interface CommandedetailsServices  {
public 	void add(Commandedetails e);
	
	public Object edite(Commandedetails e);
	
	public void delete(Long id);
	
	public List<Commandedetails> findAll();
	
	public Commandedetails findById(Long id);

	public List<Commandedetails> findByIdCommande(Long idClient);

}
