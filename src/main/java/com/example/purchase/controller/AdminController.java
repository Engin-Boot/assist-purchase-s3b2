package com.example.purchase.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.purchase.entities.Product;
import com.example.purchase.exceptions.ProductAlreadyExistsException;
import com.example.purchase.exceptions.ProductDoesNotExistException;
import com.example.purchase.repositories.ProductRepository;
import com.example.purchase.services.ProductService;
//import com.example.springboot.demo.Book;

@CrossOrigin(origins="*")

@RestController
public class AdminController 
{
	
	@Autowired
	ProductRepository productrepository;
	@Autowired
	ProductService productservice;//=new ProductService(this.productrepository);
//	@Autowired
	//ProductRepository productrepository;
	@CrossOrigin(origins="*")

	@GetMapping("/purchase/admin")
	public ResponseEntity<List<Product>> getProducts(@RequestParam(required=false) Integer id,@RequestParam(required=false)String wireless,@RequestParam(required=false) String touchscreen,@RequestParam(required=false) String interoperable)
	{
		//System.out.println(Arrays.toString(p.toArray()));
		List <Product> p=this.productrepository.findAll();
		p.retainAll(this.productservice.getAllProductsOfInteroperable(interoperable));
		p.retainAll(this.productservice.getAllProductsOfTouchscreenCategory(touchscreen));
		p.retainAll(this.productservice.getAllProductsOfWirelessCategory(wireless));
		p.retainAll(this.productservice.getProductsWithGivenId(id));
		return (new ResponseEntity (p,HttpStatus.OK));
		}
	@CrossOrigin(origins="*")

	@GetMapping("/purchase")
	public ResponseEntity<List<Product>> getProducts() throws Exception
	{
		//System.out.println(Arrays.toString(p.toArray()));
		List <Product> p=this.productrepository.findAll();
		
		return (new ResponseEntity (p,HttpStatus.OK));
		}
	@CrossOrigin(origins="*")
	@GetMapping("/purchase/admin/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Product product = productrepository.findById(id).get();
		return ResponseEntity.ok(product);
	}
	@CrossOrigin(origins="*")
	@PostMapping(path="/purchase/admin",produces = "application/json", consumes = "application/json")
	public Product addProduct( @RequestBody Product tempProduct) throws ProductAlreadyExistsException
	{
		Product product=new Product(tempProduct.getName(),tempProduct.getPrice(),tempProduct.getIsWireless(),tempProduct.getIsTouchscreen(),tempProduct.getIsInteroperable());
		productrepository.save(product);
		return product;
		//return new ResponseEntity("new product added to the db",HttpStatus.CREATED);
	}
	//@DeleteMapping("/purchase/admin/{id}")
	@CrossOrigin(origins="*")
	
	@DeleteMapping (path="/purchase/admin/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProductWithGivenId(@PathVariable int id ) throws ProductDoesNotExistException
	{
		Product p=productrepository.findById(id).get();
		if (1==1)
		{
			this.productrepository.delete(p);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
			//return new ResponseEntity("product deleted",HttpStatus.OK);
			//p.get().setInteroperable(newisInteroperable);
			//this.saveValidProduct(p.get(), productrepository);
		}
		else
			throw new ProductDoesNotExistException("e cannot be dleted beacuse there is noproduct with given id");
		
	}
	@CrossOrigin(origins="*")
	@PutMapping (path="/purchase/admin",produces = "application/json", consumes = "application/json")
	public void updateProduct(@RequestBody Product tempProduct) throws ProductDoesNotExistException
	{
		Product p =productrepository.findById(tempProduct.getId()).get();
		if (1==1)
		{
			p.setName(tempProduct.getName());
			p.setPrice(tempProduct.getPrice());
			p.setIsTouchscreen(tempProduct.getIsTouchscreen());
			p.setIsInteroperable(tempProduct.getIsInteroperable());
			p.setIsWireless(tempProduct.getIsWireless());
			productrepository.save(p);
			//return (new ResponseEntity("product updated",HttpStatus.OK));
			//p.get().setInteroperable(newisInteroperable);
			//this.saveValidProduct(p.get(), productrepository);
		}
		else
			throw new ProductDoesNotExistException(" cannot be updated because there is noproduct with given id");
		
		//return new ResponseEntity("given product updated",HttpStatus.OK);
	}
}
