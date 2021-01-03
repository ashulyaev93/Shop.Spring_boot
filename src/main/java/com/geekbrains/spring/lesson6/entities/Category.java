package com.geekbrains.spring.lesson6.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Size(min=3, max=20, message="Title must have 3-20 characters")
    @Column(name = "code")
    private String code;

    @NotEmpty
    @Size(min=3, max=20, message="Title must have 3-20 characters")
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> productsByCategory = new ArrayList<>();

    public Category() {

    }

    public Category(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductsByCategory() {
        return productsByCategory;
    }
    public void setProductsByCategory(List<Product> productsByCategory) {
        this.productsByCategory = productsByCategory;
    }
}
