package com.trm.winecellar.model;

import java.math.BigDecimal;

import java.sql.Date;



public class Wine {
	private Integer id;
	private String name;
	private Region region;
	private Varietal varietal;
	private Integer quantity;
	private Integer vintage;
	private BigDecimal price;
	private String notes;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Varietal getVarietal() {
		return varietal;
	}
	public void setVarietal(Varietal varietal) {
		this.varietal = varietal;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getVintage() {
		return vintage;
	}
	public void setVintage(Integer vintage) {
		this.vintage = vintage;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	

}
