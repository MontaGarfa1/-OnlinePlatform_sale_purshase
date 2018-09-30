package com.presentation;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;

import com.model.Produit;
import com.services.ProduitServices;
import com.services.impl.ProduitServicesImpl;
import com.util.Test;

@ManagedBean(name = "produitBean")
@SessionScoped
public class ProduitBean {

	public static Logger log = Logger.getLogger(Test.class);

	private Long idProduit;
	private String idcategorie;
	private String name;
	private String price;
	private String description;
	private String images;
	private String stock;

	
	private List<Produit> listProduit;
	private ProduitServices productServices = new ProduitServicesImpl();
	
	Produit selectedProduit;
	
	Produit produit = new Produit();

	
	@PostConstruct
	public void initBean() {
		listProduit = productServices.findAll();
	}
	
	public void addProduit() {
		Produit p= new Produit();
		p.setIdCategorie(Long.valueOf(idcategorie));
		p.setIdProduit(idProduit);
		p.setImages(images);
		p.setName(name);
		p.setDescription(description);
		p.setStock(Long.valueOf(stock));
		p.setPrice(Double.valueOf(price));
		productServices.add(p);
	}
	public String getParam(String name) {
		FacesContext fc= FacesContext.getCurrentInstance();
		Map<String,String> params=fc.getExternalContext().getRequestParameterMap();
		
		return params.get(name);
		}

	public void editProduit() {
	Produit p= new Produit();
	log.info(idProduit);
	p.setIdProduit(idProduit);
	/*p.setIdCategorie(Long.valueOf(idcategorie));
	p.setName(name);
	p.setPrice(Double.valueOf(price));
	p.setStock(Long.valueOf(stock));
	p.setImages(images);
	log.info("Id: "+p.getIdProduit());
	log.info("Produit Updated");
	produit=(Produit) productServices.edite(p);*/
	
	log.info(p.getIdCategorie());
	log.info(getName());
	log.info(price);
	log.info(idcategorie);
	log.info(images);
	log.info(stock);
	}
	
	public String editPage() {
		produit = productServices.findById(Long.valueOf(getParam("id")));
		idProduit = Long.valueOf(getParam("id"));
		idcategorie= produit.getIdCategorie()+"";
		name= produit.getName();
		price= produit.getPrice()+"";
		images= produit.getImages();
		stock= produit.getStock()+"";
		description = produit.getDescription()+"";
		log.info("Id Product: "+idProduit);
		log.info(idcategorie);
		log.info(name);
		log.info(price);
		log.info(idcategorie);
		log.info(images);
		log.info(stock);
		log.info("To Edit Page");
		return "editPage";
	}
	public String addPage() {
		/*produit = productServices.findById(Long.valueOf(getParam("id")));
		idProduit = Long.valueOf(getParam("id"));
		idcategorie= produit.getIdCategorie()+"";
		name= produit.getName();
		price= produit.getPrice()+"";
		images= produit.getImages();
		stock= produit.getStock()+"";
		log.info("Id Product: "+idProduit);
		log.info(idcategorie);
		log.info(name);
		log.info(price);
		log.info(idcategorie);
		log.info(images);
		log.info(stock);
		log.info("To Edit Page");*/
		return "addPage";
	}
	public Long getIdProduit() {
		return idProduit;
	}

	public String getIdcategorie() {
		return idcategorie;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	
	
	public String getImages() {
		return images;
	}

	public String getStock() {
		return stock;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public void setIdcategorie(String idcategorie) {
		this.idcategorie = idcategorie;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
	public void setImages(String images) {
		this.images = images;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public List<Produit> getListProduit() {
		return listProduit;
	}
	public ProduitServices getProductServices() {
		return productServices;
	}
	public void setListProduit(List<Produit> listProduit) {
		this.listProduit = listProduit;
	}
	public void setProductServices(ProduitServices productServices) {
		this.productServices = productServices;
	}
	public Produit getSelectedProduit() {
		return selectedProduit;
	}
	public void setSelectedProduit(Produit selectedProduit) {
		this.selectedProduit = selectedProduit;
	}
	 public void onRowSelect(SelectEvent event) {
	        FacesMessage msg = new FacesMessage("Produit Selected", ((Produit) event.getObject()).getIdProduit()+"");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	 
}
