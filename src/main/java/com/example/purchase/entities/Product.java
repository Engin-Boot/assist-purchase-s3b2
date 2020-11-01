package com.example.purchase.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String name;
	private String price;
	private String isWireless ;
	private String isTouchscreen ;
	private String isInteroperable ;
	public Product(int id, String name, String price, String isWireless, String isTouchscreen, String isInteroperable) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.isWireless = isWireless;
		this.isTouchscreen = isTouchscreen;
		this.isInteroperable = isInteroperable;
	}
	public Product( String name, String price, String isWireless, String isTouchscreen, String isInteroperable) {
		super();
		
		this.name = name;
		this.price = price;
		this.isWireless = isWireless;
		this.isTouchscreen = isTouchscreen;
		this.isInteroperable = isInteroperable;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", isWireless=" + isWireless
				+ ", isTouchscreen=" + isTouchscreen + ", isInteroperable=" + isInteroperable + "]";
	}
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getIsWireless() {
		return isWireless;
	}
	public void setIsWireless(String isWireless) {
		this.isWireless = isWireless;
	}
	public String getIsTouchscreen() {
		return isTouchscreen;
	}
	public void setIsTouchscreen(String isTouchscreen) {
		this.isTouchscreen = isTouchscreen;
	}
	public String getIsInteroperable() {
		return isInteroperable;
	}
	public void setIsInteroperable(String isInteroperable) {
		this.isInteroperable = isInteroperable;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}
