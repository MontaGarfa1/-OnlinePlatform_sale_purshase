package com.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.model.Categorie;
import com.services.CategorieServices;
import com.services.impl.CategorieServicesImpl;
import com.util.Test;


@ManagedBean(name = "categorieBean")
@RequestScoped
public class CategorieBean {
	private String idCategorie;
	private String name;
	private List<Categorie> listCat = new ArrayList<Categorie>();
	
	public static Logger log = Logger.getLogger(Test.class);

	
	private CategorieServices services = new CategorieServicesImpl(); 
	
	@PostConstruct
	public void initBean() {
		listCat = services.findAll();
		log.info("categorie size: "+listCat.size());
	}
	
	public String getIdCategorie() {
		return idCategorie;
	}

	public String getName() {
		return name;
	}

	public void setIdCategorie(String idCategorie) {
		this.idCategorie = idCategorie;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategorieServices getServices() {
		return services;
	}

	public void setServices(CategorieServices services) {
		this.services = services;
	}

	public List<Categorie> getListCat() {
		return listCat;
	}

	public void setListCat(List<Categorie> listCat) {
		this.listCat = listCat;
	}
	
	
}
