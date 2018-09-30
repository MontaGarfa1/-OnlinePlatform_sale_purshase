package com.presentation;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.primefaces.event.FlowEvent;

import com.model.Client;
import com.model.Commande;
import com.model.Commandedetails;
import com.services.ClientServices;
import com.services.CommandeServices;
import com.services.CommandedetailsServices;
import com.services.impl.ClientServicesImpl;
import com.services.impl.CommandeServicesImpl;
import com.services.impl.CommandedetailsServicesImpl;
import com.util.Test;

@ManagedBean(name = "clientBean")
@SessionScoped
public class ClientBean {

	public static Logger log = Logger.getLogger(Test.class);

	
	private String idclient;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private String adress;
	private String city;
	private String state;
	private String postalcode;
	private String country;
	private String phone;

	List <Client> clientList = new ArrayList<Client>();
	ClientServices clientServices = new ClientServicesImpl();
	CommandeServices commandeServices = new CommandeServicesImpl();
	CommandedetailsServices commandeDServices = new CommandedetailsServicesImpl();
	List <Commande> commandeList = new ArrayList<Commande>();
	List <Commandedetails> commandeDList = new ArrayList<Commandedetails>();

	Client user = new Client();
	private boolean skip;
	
	
	@PostConstruct
	public void initBean() {
		clientList = clientServices.findAll();
	}

	public void save() {
		Client test = new Client();
		test=clientServices.findByUsername(username);
		if(test == null) {
			FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getFirstName() +"  " +user.getLastName());
			FacesContext.getCurrentInstance().addMessage(null, msg);
			log.info("Client successfully added ");
			log.info("Firstname:  "+user.getFirstName()+"");
			log.info("Lastname:  "+user.getLastName()+"");
			
			Client p = new Client();
			p.setFirstName(firstName);
			p.setLastName(lastName);
			p.setUsername(username);
			p.setAdress(adress);
			p.setCity(city);
			p.setPostalcode(postalcode);
			p.setCountry(country);
			p.setEmail(email);
			p.setPhone(phone);
			
			//add to database
			clientServices.add(p);
			firstName="";
			lastName="";
			email="";
			username="";
			password="";
			adress="";
			city="";
			state="";
			postalcode="";
			country="";
			phone="";
		}
		else{
			//if(user.getUsername().equals(username)) {
			FacesMessage msg = new FacesMessage("Echec", "Username :" + user.getUsername()+" already exist.");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			log.info("Echec ... Username :" + user.getUsername()+" already exist.");

			
		}
		
	}
	public void updateAccount(ActionEvent event) {
		Client p = new Client();
		p.setIdclient(user.getIdclient());
		p.setFirstName(user.getFirstName());
		p.setLastName(user.getLastName());
		p.setUsername(user.getUsername());
		p.setPassword(user.getPassword());
		p.setAdress(user.getAdress());
		p.setCity(user.getCity());
		p.setPostalcode(user.getPostalcode());
		p.setCountry(user.getCountry());
		p.setEmail(user.getEmail());
		p.setPhone("26241509");
		log.info("City : "+ city);
		log.info("Country : " + country);
		user = clientServices.edite(p);
	
		log.info("Profile Updated");

	}

	public void delete() {
		{if(getParam("idclient")!=null)
			log.info("Client Deleted: "+getParam("idClient"));
		commandeList = commandeServices.findByIdClient(Long.valueOf(getParam("idclient")));
		for(int i=0;i<commandeList.size();i++)
		{
			commandeDList= commandeDServices.findByIdCommande(commandeList.get(i).getIdCommande());
			for(int j=0;j<commandeDList.size();i++)
			{
				commandeDServices.delete(commandeDList.get(j).getIdCommandeD());
			}
			commandeServices.delete(commandeList.get(i).getIdCommande());
		}
		clientServices.delete(Long.valueOf(getParam("idclient")));
		clientList = clientServices.findAll();
		}
		
		
	}
	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}
	
	public String connecter() {
		user = clientServices.findByUsername(username);
		if (user!=null&&user.getPassword().equals(password))
			{  
			username ="";
			password="";
			return "success";
		}
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Utilisateur invalide ou mot de passe incorrecte ! "));
		return"fail";
	}

	public String getIdclient() {
		return idclient;
	}
	
	public String getParam(String name) {
		FacesContext fc= FacesContext.getCurrentInstance();
		Map<String,String> params=fc.getExternalContext().getRequestParameterMap();
		
		return params.get(name);
		}

	public String getFirstName() {
		return firstName;
	}


	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAdress() {
		return adress;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public String getCountry() {
		return country;
	}

	public String getPhone() {
		return phone;
	}

	public void setIdclient(String idclient) {
		this.idclient = idclient;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Client getUser() {
		return user;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setUser(Client user) {
		this.user = user;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}
	
	
}
