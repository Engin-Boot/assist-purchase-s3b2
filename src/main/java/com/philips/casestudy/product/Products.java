	package com.philips.casestudy.product;
	import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	@Entity
	public class Products
	{
		 @GeneratedValue(strategy = GenerationType.AUTO)
		 @Id
		    private int id;
		 	private String category;
		 	private String name;
		 	private int price;
		 	public Products() {}
		 	
		 	

	}


