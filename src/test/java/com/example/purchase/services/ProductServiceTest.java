package com.example.purchase.services;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.purchase.entities.Product;
import com.example.purchase.repositories.ProductRepository;



@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest
{
	@Mock
	private ProductRepository productrepository;
	ProductService productService;
	@Before
	public void setUp()
	{
		productService=new ProductService(productrepository);
	}
	@Test
	public void getAllProductsGivenWireless ()
	{
		Product p=new Product();
		p.setId(1);
		p.setIsWireless("true");
		Product q=new Product();
		q.setIsWireless("true");
		q.setId(2);
		List<Product> l=new ArrayList<Product>();
		l.add(p);l.add(q);
		when(productrepository.findAll()).thenReturn(l);
		when(productrepository.getProductsOfWirelessCategory("true")).thenReturn(l);
		Assert.assertEquals(productService.getAllProductsOfWirelessCategory("true"), l);
		//(productService.getProductsWithGivenId(id)., actual);
	}
	@Test
	public void getAllProductsGivenTouch ()
	{
		Product p=new Product();
		p.setId(1);
		p.setIsTouchscreen("true");
		Product q=new Product();
		q.setIsTouchscreen("true");
		q.setId(2);
		List<Product> l=new ArrayList<Product>();
		l.add(p);l.add(q);
		when(productrepository.findAll()).thenReturn(l);
		when(productrepository.getProductsOfTouchscreenCategory("true")).thenReturn(l);
		Assert.assertEquals(productService.getAllProductsOfTouchscreenCategory("true"), l);
		//(productService.getProductsWithGivenId(id)., actual);
	}
	@Test
	public void getAllProductsGivenInteroperable ()
	{
		Product p=new Product();
		p.setId(1);
		p.setIsInteroperable("true");
		Product q=new Product();
		q.setIsInteroperable("true");
		q.setId(2);
		List<Product> l=new ArrayList<Product>();
		l.add(p);l.add(q);
		when(productrepository.findAll()).thenReturn(l);
		when(productrepository.getProductsOfInteroperableCategory("true")).thenReturn(l);
		Assert.assertEquals(productService.getAllProductsOfInteroperable("true"), l);
		//(productService.getProductsWithGivenId(id)., actual);
	}
	
	
	
	
}