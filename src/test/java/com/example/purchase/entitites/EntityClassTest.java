package com.example.purchase.entitites;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.example.purchase.entities.Product;

public class EntityClassTest {

	@Test
	public void check_Product()
	{
		Product pro=new Product();
		pro.setId(1001);
		pro.setName("X-ray");
		assertEquals(pro.getName(),"X-ray");
		pro.setPrice("1000");
		assertEquals(pro.getPrice(),"1000");
		pro.setIsWireless("Wireless");
		assertEquals(pro.getIsWireless(),"Wireless");
		pro.setIsTouchscreen("touchscreen");
		assertEquals(pro.getIsTouchscreen(),"touchscreen");
		pro.setIsInteroperable("Interoperable");
		assertEquals(pro.getIsInteroperable(),"Interoperable");
		List<Product> products=new ArrayList<>();
		products.add(pro);
		assertEquals(1,products.size());
	}
}