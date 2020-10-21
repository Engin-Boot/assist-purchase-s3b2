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
	
	@Query(value="SELECT * FROM products WHERE category=?1 OR name=?2 ",nativeQuery=true)
	List<Products> f(String category,String name);
	@Query(value="SELECT * FROM products WHERE category=?1 OR name=?2 ",nativeQuery=true)
	List<Products> findByCategoryOrName(String category,String name);
}
