package com.example.purchase.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.purchase.entities.Product;
import com.example.purchase.repositories.ProductRepository;
import com.example.purchase.services.ProductService;

@RestController
@CrossOrigin(origins="*")

public class ClientController {
@Autowired
ProductRepository productrepository;
@Autowired
ProductService productservice;
@CrossOrigin(origins="*")

@GetMapping("/purchase/client")
public ResponseEntity<List<Product>> getProducts(@RequestParam(required=false) Integer id,@RequestParam(required=false) String wireless,@RequestParam(required=false) String touchscreen,@RequestParam(required=false) String interoperable)
{
	//System.out.println(Arrays.toString(p.toArray()));
	List <Product> p=productrepository.findAll();
	p.retainAll(this.productservice.getAllProductsOfInteroperable(interoperable));
	p.retainAll(this.productservice.getAllProductsOfTouchscreenCategory(touchscreen));
	p.retainAll(this.productservice.getAllProductsOfWirelessCategory(wireless));
	return (new ResponseEntity (p,HttpStatus.OK));
	}

}
