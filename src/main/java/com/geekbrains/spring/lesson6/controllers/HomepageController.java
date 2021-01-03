package com.geekbrains.spring.lesson6.controllers;

import com.geekbrains.spring.lesson6.services.CategoryService;
import com.geekbrains.spring.lesson6.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomepageController {

    private CategoryService categoryService;
    private ProductService productService;

    public HomepageController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping
    public String main(
            @RequestParam(name = "p", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "s", required = false, defaultValue = "6") Integer size,
            Model model,
            Principal principal
    ){
        page = page > 0 ? page - 1 : page;
        model.addAttribute("products", productService.findAll(null, page, size));
        model.addAttribute("categories", categoryService.findAll());
        return "products";
    }
}
