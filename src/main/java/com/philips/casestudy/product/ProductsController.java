package com.philips.casestudy.product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

@RestController
public class ProductsController
{
	@Autowired
	ProductsRepository produtsrepository;
	@GetMapping("/products")
	public List<Products> getAllProducts()
	{return produtsrepository.findAll();}
	@GetMapping("/products/sort/price")
	public List<Products> getAllProductsBySortingOnPrice()
	{return produtsrepository.findAll(Sort.by(Sort.Direction.ASC, "price"));}
	@GetMapping("/products/")
	@ResponseBody
	List<Products> getAllProductsWithGivenCategoryOrName(@RequestParam String category,@RequestParam String name)
	{return produtsrepository.findByCategoryOrName(category, name);}
	@GetMapping("/products/")
	@ResponseBody
	List<Products> getAllTouchScreenProductsbyCategory(@RequestParam String category,@RequestParam String name,@RequestParam String touchScreen)
	{return produtsrepository.findAllTouchScreenProductsbyCategory(category, name,touchScreen);}
	@GetMapping("/products/")
	@ResponseBody
	List<Products> getAllWirelessProductsbyCategory(@RequestParam String category,@RequestParam String name,@RequestParam String wireless)
	{return produtsrepository.findAllWirelessProductsbyCategory(category, name,wireless);}
}
