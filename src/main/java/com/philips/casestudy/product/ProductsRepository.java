package com.philips.casestudy.product;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer> 
{
	@Query(value="SELECT * FROM products WHERE category=?1 OR name=?2 ",nativeQuery=true)
	List<Products> findByCategoryOrName(String category,String name);
	
	@Query(value="SELECT * FROM products WHERE category=?1 OR name=?2 AND touchScreen=?3 ",nativeQuery=true)
	List<Products> findAllTouchScreenProductsbyCategory(String category,String name,String touchScreen);
	@Query(value="SELECT * FROM products WHERE category=?1 OR name=?2 AND wireless=?3 ",nativeQuery=true)
	List<Products> findByCategoryOrName(String category,String name,String wireless);
}
