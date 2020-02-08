package com.kyaw.onlineshop.repository;

import com.kyaw.onlineshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // By following the naming rule
    List<Product> findByCategoryId(int id);

    // Custom query to get result
    @Query("select p " +
            "from Product p " +
            "where " +
            "p.category.id = :id")
    List<Product> findProductWithCategoryId(@Param("id") int id);

}
