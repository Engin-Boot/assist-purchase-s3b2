package com.example.purchase.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.purchase.entities.Product;
import com.example.purchase.exceptions.ProductAlreadyExistsException;
import com.example.purchase.exceptions.ProductDoesNotExistException;
import com.example.purchase.repositories.ProductRepository;

@RestController
public class AdminController 
{
	
	@Autowired 
	ProductRepository productrepository;
//	@Autowired
	//ProductRepository productrepository;
	@GetMapping("/purchase/admin/all")
	public ResponseEntity<List<Product>> getAllProducts()
	{return (new ResponseEntity (productrepository.findAll(),HttpStatus.OK));}

	@PostMapping(path="/purchase/admin/",produces = "application/json", consumes = "application/x-www-form-urlencoded")
	public ResponseEntity<String> addProduct( @RequestParam String name, @RequestParam int price,@RequestParam boolean isWireless, @RequestParam boolean isTouchscreen,@RequestParam boolean isInteroperable) throws ProductAlreadyExistsException
	{
		Product temp=new Product(productrepository.getNextId(),name,price,isWireless,isTouchscreen,isInteroperable);
		productrepository.save(temp);
		
		return new ResponseEntity("new product added to the db",HttpStatus.CREATED);
	}
	@DeleteMapping (path="/purchase/admin/",produces = "application/json", consumes = "application/x-www-form-urlencoded")
	public ResponseEntity<String> deleteProductWithGivenId(int id ) throws ProductDoesNotExistException
	{
		Optional<Product> p =productrepository.findById(id);
		if (p.isPresent())
		{
			this.productrepository.deleteById(id);
			return new ResponseEntity("product deleted",HttpStatus.OK);
			//p.get().setInteroperable(newisInteroperable);
			//this.saveValidProduct(p.get(), productrepository);
		}
		else
			throw new ProductDoesNotExistException("e cannot be dleted beacuse there is noproduct with given id");
		
	}
	@PutMapping (path="/purchase/admin/",produces = "application/json", consumes = "application/x-www-form-urlencoded")
	public ResponseEntity<String> updateProduct(@RequestParam int id,@RequestParam String name, @RequestParam int price,@RequestParam boolean isWireless, @RequestParam boolean isTouchscreen,@RequestParam boolean isInteroperable) throws ProductDoesNotExistException
	{
		Optional<Product> p =productrepository.findById(id);
		if (p.isPresent())
		{
			p.get().setName(name);
			p.get().setPrice(price);
			p.get().setTouchscreen(isTouchscreen);
			p.get().setInteroperable(isInteroperable);
			p.get().setWireless(isWireless);
			productrepository.save(p.get());
			return (new ResponseEntity("product updated",HttpStatus.OK));
			//p.get().setInteroperable(newisInteroperable);
			//this.saveValidProduct(p.get(), productrepository);
		}
		else
			throw new ProductDoesNotExistException(" cannot be updated because there is noproduct with given id");
		
		//return new ResponseEntity("given product updated",HttpStatus.OK);
	}
}
