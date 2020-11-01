package com.example.purchase.repositories;
import java.util.List;
import com.example.purchase.entities.Product;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	@Query(value="select * from product where is_wireless=?1 ",nativeQuery=true)
	public List<Product> getProductsOfWirelessCategory(String value);
	@Query(value="select * from product where is_touchscreen=?1 ",nativeQuery=true)
	public List<Product> getProductsOfTouchscreenCategory(String value);
	@Query(value="select * from product where is_interoperable=?1 ",nativeQuery=true)
	public List<Product> getProductsOfInteroperableCategory(String value);
	@Query(value="select * from product where name=?1",nativeQuery=true)
	public List<Product> getProductsWithGivenName(String name);
}
