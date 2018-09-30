package com.model;
// Generated 20 janv. 2018 04:43:44 by Hibernate Tools 5.2.6.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Produit generated by hbm2java
 */
@Entity
@Table(name = "produit", catalog = "onlineshop")
public class Produit implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idProduit;
	@Column(name = "idCategorie")
	private Long idcategorie;
	private String name;
	private Double price;
	private String description;
	private String images;
	private Long stock;
	// private Set<Commandedetails> commandedetailses = new
	// HashSet<Commandedetails>(0);

	public Produit() {
	}

	public Produit(Long idcategorie, String name, Double price, String images, Long stock, String descript) {
		this.idcategorie = idcategorie;
		this.name = name;
		this.price = price;
		this.images = images;
		this.description = descript;
		this.stock = stock;
	}

	public Produit(Long idcategorie, String name, Double price, String images, Long stock,
			Set<Commandedetails> commandedetailses) {
		this.idcategorie = idcategorie;
		this.name = name;
		this.price = price;
		this.images = images;
		this.stock = stock;
		// this.commandedetailses = commandedetailses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idProduit", unique = true, nullable = false)
	public Long getIdProduit() {
		return this.idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "idCategorie", nullable = false)
	public Long getIdCategorie() {
		return this.idcategorie;
	}

	public void setIdCategorie(Long idcategorie) {
		this.idcategorie = idcategorie;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", nullable = false, precision = 10, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "images", nullable = false, length = 45)
	public String getImages() {
		return this.images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	

	@Column(name = "stock", nullable = false)
	public Long getStock() {
		return this.stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}
	@Column(name = "description", nullable = true, length = 32)
		public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "produit") public
	 * Set<Commandedetails> getCommandedetailses() { return this.commandedetailses;
	 * }
	 * 
	 * public void setCommandedetailses(Set<Commandedetails> commandedetailses) {
	 * this.commandedetailses = commandedetailses; }
	 */

}
