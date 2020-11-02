package com.example.purchase.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

//import com.example.purchase.dto.ProductDTO;
import com.example.purchase.entities.Product;
import com.example.purchase.repositories.ProductRepository;
@Service
public class ProductService {
	//@Autowired
<<<<<<< HEAD
	private  ProductRepository productrepository;
	@Autowired
	public ProductService(ProductRepository productrepository) {
		super();
		this.productrepository = productrepository;
	}
	public void setdao(ProductRepository productrepository)
	{this.productrepository=productrepository;}
=======
	private final ProductRepository productrepository;
	public void setdao(ProductRepository productrepository)
    {
        this.productrepository = productrepository;
    }
	/*@Autowired
	public ProductService(ProductRepository productrepository) {
		super();
		this.productrepository = productrepository;
	}*/
	
>>>>>>> 94beab7bf1455894a9496090484b311e979756f5
	
	
	public Optional <Product> getProductsWithGivenId (int id)
	{return this.productrepository.findById(id);}
	//@GetMapping("/purchase/client/category/isWireless")
	public List<Product> getAllProductsOfWirelessCategory( String value)
	{
		List<Product> p=this.productrepository.findAll();
		if(value!=null) p.retainAll(this.productrepository.getProductsOfWirelessCategory(value));
		return p ;
	}
	//@GetMapping("/purchase/client/category/isTouchscreen")
	public List<Product> getAllProductsOfTouchscreenCategory(@RequestParam (required=false)String value)
	{
		List<Product> p=this.productrepository.findAll();
		//List<Product> p=this.getAllProducts().getBody();
		if(value!=null) p.retainAll(this.productrepository.getProductsOfTouchscreenCategory(value));
		return p ;
	}
	//@GetMapping("/purchase/client/category/isInteroperable")
	public List<Product> getAllProductsOfInteroperable(@RequestParam (required=false)String value)
	{
		List<Product> p=this.productrepository.findAll();
//		List<Product> p=this.getAllProducts().getBody();
		if(value!=null) p.retainAll(this.productrepository.getProductsOfInteroperableCategory(value));
		return p ;
		}
	public List<Product> getProductsWithGivenId(@RequestParam (required=false)Integer id)
	{
		List<Product> p=this.productrepository.findAll();
//		List<Product> p=this.getAllProducts().getBody();
		List<Product> q=new ArrayList<Product>();
		
		if(id!=null) {q.add(this.productrepository.findById(id).get());p.retainAll(q);}
		return p ;
		}
	
}
