package com.presentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.primefaces.component.datatable.DataTable;

import com.model.Commande;
import com.model.Commandedetails;
import com.model.Produit;
import com.util.Test;

@ManagedBean(name = "commandeDBean")
@SessionScoped
public class CommandedetailsBean {
	
	public static Logger log = Logger.getLogger(Test.class);
	
	private String idCommandeD;
	private String idcommande;
	private String idproduit;
	private String quantite;
	private String name;
	private String price;
	List<Commandedetails> listCD =new ArrayList<Commandedetails>() ;
	private int quant=0;
	private String[] quantites;;
	HashMap<Long, String> map = new HashMap<>();
	@ManagedProperty(value = "#{produitBean}")
	ProduitBean produitBean;
	List<Produit> produitList;
	
	@PostConstruct
	public void init(){
	//	produitList = produitBean.getListProduit();
//		quantites = new String[produitList.size()];
	//	log.info(""+quantites.length);*/
		//quantites[1]="0" ;
		quantites = new String[100];

	}
	public String getParam(String name) {
		FacesContext fc= FacesContext.getCurrentInstance();
		Map<String,String> params=fc.getExternalContext().getRequestParameterMap();
		
		return params.get(name);
		}
	
	public void addProduit(ActionEvent e) {
	
		log.info("id product: "+getParam("id"));
		//log.info("name product: "+getParam("name"));
		log.info("price product: "+getParam("price"));
		//log.info("Quantite :"+getIndex());
		Commandedetails cD = new Commandedetails();
		cD.setIdProduit(Long.valueOf(getParam("id")));
		cD.setQuantite(quantites[Integer.valueOf(getParam("id"))]+"");
		cD.setPrice(Double.valueOf(quantites[Integer.valueOf(getParam("id"))])*Double.valueOf(getParam("price")));
		cD.setName(getParam("name"));
		/*for(int i=0 ;listCD.size()<i;i++){
			if (listCD.get(i).getIdProduit() ==  Long.valueOf(getParam("id"))){
				int j;
				j=Integer.valueOf(listCD.get(i).getQuantite())+Integer.valueOf(quantites[Integer.valueOf(getParam("id"))]);
				listCD.get(i).setQuantite(Integer.valueOf(quantite)+"");
			break;
			}*/
			
		
		listCD.add(cD);
		log.info("Array List: "+cD.getQuantite());

		
	}

	public String getIdCommandeD() {
		return idCommandeD;
	}

	public String getIdcommande() {
		return idcommande;
	}

	public String getIdproduit() {
		return idproduit;
	}

	public String getQuantite() {
		return quantite;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public void setIdCommandeD(String idCommandeD) {
		this.idCommandeD = idCommandeD;
	}

	public void setIdcommande(String idcommande) {
		this.idcommande = idcommande;
	}

	public void setIdproduit(String idproduit) {
		this.idproduit = idproduit;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public List<Commandedetails> getListCD() {
		return listCD;
	}

	public void setListCD(List<Commandedetails> listCD) {
		this.listCD = listCD;
	}

	public HashMap<Long, String> getMap() {
		return map;
	}

	public void setMap(HashMap<Long, String> map) {
		this.map = map;
	}
	public ProduitBean getProduitBean() {
		return produitBean;
	}
	public void setProduitBean(ProduitBean produitBean) {
		this.produitBean = produitBean;
	}
	public List<Produit> getProduitList() {
		return produitList;
	}
	public void setProduitList(List<Produit> produitList) {
		this.produitList = produitList;
	}
	public String[] getQuantites() {
		return quantites;
	}
	public void setQuantites(String[] quantites) {
		this.quantites = quantites;
	}
	
	
	
	

}
