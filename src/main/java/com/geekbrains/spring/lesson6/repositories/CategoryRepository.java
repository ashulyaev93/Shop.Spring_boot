package com.geekbrains.spring.lesson6.repositories;

import com.geekbrains.spring.lesson6.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findCategoriesByCode(String code);
}
