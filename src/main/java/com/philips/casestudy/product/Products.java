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
			public Products(int id, String category, String name, int price) {
				super();
				this.id = id;
				this.category = category;
				this.name = name;
				this.price = price;
			}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getCategory() {
				return category;
			}
			public void setCategory(String category) {
				this.category = category;
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
			@Override
			public String toString() {
				return "Products [id=" + id + ", category=" + category + ", name=" + name + ", price=" + price + "]";
			}
		 	
		 	

	}


