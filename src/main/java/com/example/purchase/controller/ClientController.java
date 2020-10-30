package com.example.purchase.controller;
import java.util.List;
import com.example.purchase.exceptions.*;
import com.example.purchase.entities.Product;
import com.example.purchase.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
@Autowired
ProductRepository productrepository;
@GetMapping("/purchase/client/all")
public ResponseEntity<List<Product>> getAllProducts()
{return (new ResponseEntity (productrepository.findAll(),HttpStatus.OK));}

@GetMapping("/purchase/client/category/isWireless")
public ResponseEntity<List<Product>> getProductsOfWirelessCategory(@RequestParam boolean value)
{
return( new ResponseEntity(productrepository.getProductsOfWirelessCategory(value),HttpStatus.OK));
}
@GetMapping("/purchase/client/category/isTouchscreen")
public ResponseEntity<List<Product>> getAllProductsOfTouchscreenCategory(@RequestParam boolean value)
{
return( new ResponseEntity(productrepository.getProductsOfTouchscreenCategory(value),HttpStatus.OK));
}
@GetMapping("/purchase/client/category/isInteroperable")
public ResponseEntity<List<Product>> getAllProductsOfInteroperable(@RequestParam boolean value)
{
return( new ResponseEntity(productrepository.getProductsOfInteroperableCategory(value),HttpStatus.OK));
}
@GetMapping("/purchase/client/name")
public ResponseEntity <List<Product>> getProductWithTheGivenName(@RequestParam String name) throws ProductDoesNotExistException
{
	List<Product> temp = productrepository.getProductsWithGivenName(name);
	if(!temp.isEmpty())
	return new ResponseEntity(temp,HttpStatus.OK);
	else
		throw new ProductDoesNotExistException("no products with the given name");
}
}
