package com.trm.winecellar.model;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Wine {
	private int id;
	private String name;
	private Integer vintage;
	private Region region;
	private BigDecimal price;
	private Varietal varietal;
	private int quantity;
	private String description;
	private LocalDate purchaseDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVintage() {
		return vintage;
	}
	public void setVintage(Integer vintage) {
		this.vintage = vintage;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Varietal getVarietal() {
		return varietal;
	}
	public void setVarietal(Varietal varietal) {
		this.varietal = varietal;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	

}
