package com.example.purchase.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.purchase.dto.ProductDTO;
import com.example.purchase.entities.Product;
import com.example.purchase.exceptions.ProductDoesNotExistException;
import com.example.purchase.repositories.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository productrepository;
	
	public ProductService(ProductRepository productrepository) {
		super();
		this.productrepository = productrepository;
	}
	public ProductDTO getProductDTO(int id,String name,int price,boolean isWireless,boolean isTouchscreen,boolean isInteroperable )
	{
		ProductDTO productdto=new ProductDTO();
		productdto.setId(id);
		productdto.setInteroperable(isInteroperable);
		productdto.setName(name);
		productdto.setPrice(price);
		productdto.setWireless(isWireless);
		return productdto;
	}
	public Product getproductFromProductDTO(ProductDTO productdto)
	{
		Product product = new Product();
		product.setId(productdto.getId());
		product.setInteroperable(productdto.isInteroperable());
		product.setName(productdto.getName());
		product.setPrice(productdto.getPrice());
		product.setInteroperable(productdto.isInteroperable());
		return product;
	}
	public void saveValidProduct  (Product product) 
	{this.productrepository.save(product);}
	public void alterPrice(int id,int newPrice) throws ProductDoesNotExistException
	{
		//Optional<Product> p =productrepository.findById(id);
		Optional<Product> p =this.getProductsWithGivenId( id);
		if (p.isPresent())
		{
			p.get().setPrice(newPrice);
			this.saveValidProduct(p.get());
		}
		else
			throw new ProductDoesNotExistException("price cannot be altered beacuse there is noproduct with given id");
	}
	public void alterName(int id,String newName) throws ProductDoesNotExistException
	{
		//Optional<Product> p =productrepository.findById(id);
		Optional<Product> p =this.getProductsWithGivenId(id);
		if (p.isPresent())
		{
			p.get().setName(newName);
			this.saveValidProduct(p.get());
		}
		else
			throw new ProductDoesNotExistException("name cannot be altered beacuse there is noproduct with given id");
	}
	public void alterisWireless(int id,boolean newisWireless) throws ProductDoesNotExistException
	{
		//Optional<Product> p =productrepository.findById(id);
		Optional<Product> p =this.getProductsWithGivenId(id);
		if (p.isPresent())
		{
			p.get().setWireless(newisWireless);
			this.saveValidProduct(p.get());
		}
		else
			throw new ProductDoesNotExistException("Wireless cannot be altered beacuse there is noproduct with given id");
	}
	public void alterisInteroperable(int id,boolean newisInteroperable) throws ProductDoesNotExistException
	{
		//Optional<Product> p =this.getProductsWithGivenId(productrepository, id);
		Optional<Product> p =this.getProductsWithGivenId( id);
		if (p.isPresent())
		{
			p.get().setInteroperable(newisInteroperable);
			this.saveValidProduct(p.get());
		}
		else
			throw new ProductDoesNotExistException("isInteroperable cannot be altered beacuse there is noproduct with given id");
	}
	public Optional <Product> getProductsWithGivenId (int id)
	{return this.productrepository.findById(id);}
	
	
	
}
