package com.geekbrains.spring.lesson6.repositories;

import com.geekbrains.spring.lesson6.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.code = :code")
    Page<Product> findProductByCategoryCode(@Param("code") String code, Pageable pageable);
}
