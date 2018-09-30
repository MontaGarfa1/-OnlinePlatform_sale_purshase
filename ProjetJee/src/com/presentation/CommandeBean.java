package com.presentation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import com.model.Client;
import com.model.Commande;
import com.model.Commandedetails;
import com.services.CommandeServices;
import com.services.CommandedetailsServices;
import com.services.impl.CommandeServicesImpl;
import com.services.impl.CommandedetailsServicesImpl;
import com.util.Test;

@ManagedBean(name = "commandeBean")
@RequestScoped
public class CommandeBean {
	
	public static Logger log = Logger.getLogger(Test.class);

	
	private String idCommande;
	private String client;
	private String name;
	private String datecommande;
	private String price;

	private String total="0.0" ;
	
	@ManagedProperty(value = "#{clientBean}")
	 ClientBean bean ;
	
	Client user ;
	List<Commande> commande;
	List<Commande> commandeAll;

	Commande panier;
	@ManagedProperty(value = "#{commandeDBen}")
	CommandedetailsBean beanD ;
	List<Commandedetails> listDetails =new ArrayList<Commandedetails>() ;

	
	CommandeServices commandeServices= new CommandeServicesImpl(); 
	CommandedetailsServices details = new CommandedetailsServicesImpl();
	@PostConstruct
	public void initBean() {


		listDetails =beanD.getListCD();
		user = bean.getUser();
		commande =commandeServices.findByIdClient(user.getIdclient());
		commandeAll=commandeServices.findAll();
	}
	
	public void addCommand() {
		if (listDetails.size()>0)
		{Commande c = new Commande();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		c.setDatecommande(dtf.format(now));
		c.setPrice(Double.valueOf(getTotal()));
		c.setIdClient(user.getIdclient());
		commandeServices.add(c);

		
		for(int i=0;i<listDetails.size();i++) {
			listDetails.get(i).setIdCommande(c.getIdCommande());
			details.add(listDetails.get(i));
		}		

		
		log.info(dtf.format(now)); 
		log.info(""+c.getIdCommande());
		log.info("Order Submitted"+c.getIdCommande());
		listDetails.clear();
		}
		}
	public void cancelCommand() {
		if(listDetails.size()>0) {
		log.info("Order cancelled");
		listDetails.clear();		}
	}
	
	
	public String getIdCommande() {
		return idCommande;
	}
	public String getClient() {
		return client;
	}

	public String getName() {
		return name;
	}

	public String getDatecommande() {
		return datecommande;
	}

	public String getPrice() {
		return price;
	}

	public void setIdCommande(String idCommande) {
		this.idCommande = idCommande;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDatecommande(String datecommande) {
		this.datecommande = datecommande;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<Commande> getCommande() {
		return commande;
	}

	public void setCommande(List<Commande> commande) {
		this.commande = commande;
	}

	public ClientBean getBean() {
		return bean;
	}

	public void setBean(ClientBean bean) {
		this.bean = bean;
	}

	public Commande getPanier() {
		return panier;
	}

	public void setPanier(Commande panier) {
		this.panier = panier;
	}


	public Client getUser() {
		return user;
	}


	public CommandedetailsBean getBeanD() {
		return beanD;
	}


	public List<Commandedetails> getListDetails() {
		return listDetails;
	}


	public CommandeServices getCommandeServices() {
		return commandeServices;
	}


	public void setUser(Client user) {
		this.user = user;
	}


	public void setBeanD(CommandedetailsBean beanD) {
		this.beanD = beanD;
	}


	public void setListDetails(List<Commandedetails> listDetails) {
		this.listDetails = listDetails;
	}


	public void setCommandeServices(CommandeServices commandeServices) {
		this.commandeServices = commandeServices;
	}

	public String getTotal() {
		int i =0;
		Double total1=0.0;
		for (i=0;i<listDetails.size();i++)
			{total1 =total1+ listDetails.get(i).getPrice();
			log.info(""+listDetails.get(i).getPrice());}
		total = total1+"";
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<Commande> getCommandeAll() {
		return commandeAll;
	}

	public void setCommandeAll(List<Commande> commandeAll) {
		this.commandeAll = commandeAll;
	}
	 
	
	
	

	
	
}
