package com.coop.model.dto;

import java.io.Serializable;

public class ProductoSintetico implements Serializable {

	private static final long serialVersionUID = 7240338664780599669L;
	
	
	public ProductoSintetico(long id, String producto, String rubro, double precio) {
		super();
		this.id = id;
		this.producto = producto;
		this.rubro = rubro;
		this.precio = precio;
	}
	private long id;
	private String producto;
	private String rubro;
	private double precio;
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getRubro() {
		return rubro;
	}
	public void setRubro(String rubro) {
		this.rubro = rubro;
	}
}
