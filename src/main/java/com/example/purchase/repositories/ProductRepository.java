package com.example.purchase.repositories;
import java.util.List;
import com.example.purchase.entities.Product;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	@Query(value="SELECT auto_increment+1 from  information_schema.tables where table_name=\"product\" ; ",nativeQuery=true)
	public int getNextId ();
	@Query(value="select * from product where ?1=?2 ",nativeQuery=true)
	public List<Product> getProductsOfGivenCategory(String category,boolean value);
	@Query(value="select * from product where name=?1",nativeQuery=true)
	public List<Product> getProductsWithGivenName(String name);
}
