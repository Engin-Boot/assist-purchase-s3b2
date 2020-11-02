package com.example.purchase.services;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
//import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.purchase.entities.Product;
import com.example.purchase.repositories.ProductRepository;


@RunWith(MockitoJUnitRunner.class)
public class ProdServTest {
	@Mock
	ProductRepository prodrepository;
	@InjectMocks
	ProductService prodservice;
	@BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	@BeforeEach
	void setup(){
		prodservice.setdao(prodrepository);
	}
	@Test
	public void find_all_wireless_products()
	{
		Product pro=new Product();
		
		pro.setId(1001);
		pro.setName("X-ray");
		
		pro.setPrice("1000");
		
		pro.setIsWireless("Wireless");
		
		pro.setIsTouchscreen("touchscreen");
		
		pro.setIsInteroperable("Interoperable");
		//List<Product> products=new ArrayList<>();
		List<Product> product=new ArrayList<>();
		product.add(pro);
		//ProductService service=new ProductService();
		// ProductRepository repository=new ProductRepository();
		//ProductService service=new ProductService(repository);
	//	service.ProductService(repository);
		//Mockito.when(mockedFirstObject.getSecondObject()).thenReturn(setupMockedSecondObject());
		Mockito.when(prodrepository.getProductsOfWirelessCategory("Wireless")).thenReturn(product);
		List<Product> products=prodservice.getAllProductsOfWirelessCategory("Wireless");
		
		   assertNotNull(products);
		
	}
	@Test
	public void find_all_touchscreen_products()
	{
		Product pro1=new Product();
		
		pro1.setId(1001);
		pro1.setName("X-ray");
		
		pro1.setPrice("1000");
		
		pro1.setIsWireless("Wireless");
		
		pro1.setIsTouchscreen("touchscreen");
		
		pro1.setIsInteroperable("Interoperable");
		
		
      Product pro2=new Product();
		
		pro2.setId(1002);
		pro2.setName("trimer");
		
		pro2.setPrice("1500");
		
		pro2.setIsWireless("Wireless");
		
		pro2.setIsTouchscreen("nottouchscreen");
		
		pro2.setIsInteroperable("Interoperable");
	
Product pro3=new Product();
		
		pro3.setId(1003);
		pro3.setName("monitor11");
		
		pro3.setPrice("10000");
		
		pro3.setIsWireless("Wireless");
		
		pro3.setIsTouchscreen("touchscreen");
		
		pro1.setIsInteroperable("Interoperable");
		List<Product> products=new ArrayList<>();
		List<Product> product=new ArrayList<>();
		product.add(pro1);
		product.add(pro3);
		
		Mockito.when(prodrepository.getProductsOfTouchscreenCategory("touchscreen")).thenReturn(product);
		products=prodservice.getAllProductsOfTouchscreenCategory("touchscreen");
		assertNotNull(products);
		
	}
	@Test
	public void find_all_interoperable_products()
	{
		Product pro1=new Product();
		
		pro1.setId(1001);
		pro1.setName("X-ray");
		
		pro1.setPrice("1000");
		
		pro1.setIsWireless("Wireless");
		
		pro1.setIsTouchscreen("touchscreen");
		
		pro1.setIsInteroperable("Interoperable");
		
		
      Product pro2=new Product();
		
		pro2.setId(1002);
		pro2.setName("trimer");
		
		pro2.setPrice("1500");
		
		pro2.setIsWireless("Wireless");
		
		pro2.setIsTouchscreen("nottouchscreen");
		
		pro2.setIsInteroperable("Interoperable");
	
Product pro3=new Product();
		
		pro3.setId(1003);
		pro3.setName("monitor11");
		
		pro3.setPrice("10000");
		
		pro3.setIsWireless("Wireless");
		
		pro3.setIsTouchscreen("touchscreen");
		
		pro1.setIsInteroperable("Interoperable");
		List<Product> products=new ArrayList<>();
		List<Product> product=new ArrayList<>();
		product.add(pro1);
		product.add(pro2);
		product.add(pro3);
		
		Mockito.when(prodrepository.getProductsOfInteroperableCategory("Interoperable")).thenReturn(product);
		products=prodservice. getAllProductsOfInteroperable("Interoperable");
		assertNotNull(products);
		
	}
	@Test
	public void find_all_products_by_id()
	{
		Product pro1=new Product();
		
		pro1.setId(1001);
		pro1.setName("X-ray");
		
		pro1.setPrice("1000");
		
		pro1.setIsWireless("Wireless");
		
		pro1.setIsTouchscreen("touchscreen");
		
		pro1.setIsInteroperable("Interoperable");
		
		
      Product pro2=new Product();
		
		pro2.setId(1002);
		pro2.setName("trimer");
		
		pro2.setPrice("1500");
		
		pro2.setIsWireless("Wireless");
		
		pro2.setIsTouchscreen("nottouchscreen");
		
		pro2.setIsInteroperable("Interoperable");
	
Product pro3=new Product();
		
		pro3.setId(1003);
		pro3.setName("monitor11");
		
		pro3.setPrice("10000");
		
		pro3.setIsWireless("Wireless");
		
		pro3.setIsTouchscreen("touchscreen");
		
		pro1.setIsInteroperable("Interoperable");
		
		
		
		Mockito.when(prodrepository.findById(1001)).thenReturn(java.util.Optional.of(pro1));
		
		assertEquals(prodservice.getProductsWithGivenId(1001),java.util.Optional.of(pro1));
		
	}
  
  
}

