package com.model;
// Generated 20 janv. 2018 04:43:44 by Hibernate Tools 5.2.6.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Client generated by hbm2java
 */
@Entity
@Table(name = "client", catalog = "onlineshop")
public class Client implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idclient;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private String adress;
	private String city;
	private String postalcode;
	private String country;
	private String phone;
	//private Set<Commande> commandes = new HashSet<Commande>(0);

	public Client() {
	}

	public Client(Long idclient, String firstName, String lastName, String email, String username, String password,
			String adress, String city, String postalcode, String country, String phone) {
		this.idclient = idclient;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.adress = adress;
		this.city = city;
		this.postalcode = postalcode;
		this.country = country;
		this.phone = phone;
	}

	/*public Client(Long idclient, String firstName, String lastName, String email, String username, String password,
			String adress, String city,String postalcode, String country, String phone,
			Set<Commande> commandes) {
		this.idclient = idclient;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.adress = adress;
		this.city = city;
		this.postalcode = postalcode;
		this.country = country;
		this.phone = phone;
		this.commandes = commandes;
	}*/

	@Id
	@GeneratedValue(strategy = IDENTITY)


	@Column(name = "idclient", unique = true, nullable = false)
	public Long getIdclient() {
		return this.idclient;
	}

	public void setIdclient(Long idclient) {
		this.idclient = idclient;
	}

	@Column(name = "firstName", nullable = false, length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName", nullable = false, length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email", nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "username", nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "adress", nullable = false, length = 100)
	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Column(name = "city", nullable = false, length = 45)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}



	@Column(name = "postalcode", nullable = false, length = 10)
	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	@Column(name = "country", nullable = false, length = 45)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "phone", nullable = false, length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

/*	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}*/

}
