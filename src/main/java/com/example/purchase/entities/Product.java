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
	private int price;
	private boolean isWireless ;
	private boolean isTouchscreen ;
	private boolean isInteroperable ;
	public Product(int id, String name, int price, boolean isWireless, boolean isTouchscreen,
			boolean isInteroperable) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.isWireless = isWireless;
		this.isTouchscreen = isTouchscreen;
		this.isInteroperable = isInteroperable;
	}
	public Product( String name, int price, boolean isWireless, boolean isTouchscreen,
			boolean isInteroperable) {
		super();
		
		this.name = name;
		this.price = price;
		this.isWireless = isWireless;
		this.isTouchscreen = isTouchscreen;
		this.isInteroperable = isInteroperable;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isWireless() {
		return isWireless;
	}
	public void setWireless(boolean isWireless) {
		this.isWireless = isWireless;
	}
	public boolean isTouchscreen() {
		return isTouchscreen;
	}
	public void setTouchscreen(boolean isTouchscreen) {
		this.isTouchscreen = isTouchscreen;
	}
	public boolean isInteroperable() {
		return isInteroperable;
	}
	public void setInteroperable(boolean isInteroperable) {
		this.isInteroperable = isInteroperable;
	}
	
}
