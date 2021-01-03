package com.geekbrains.spring.lesson6.utils;

import com.geekbrains.spring.lesson6.entities.Category;
import com.geekbrains.spring.lesson6.entities.Customer;
import com.geekbrains.spring.lesson6.entities.Order;
import com.geekbrains.spring.lesson6.entities.Product;
import com.geekbrains.spring.lesson6.repositories.CategoryRepository;
import com.geekbrains.spring.lesson6.repositories.CustomerRepository;
import com.geekbrains.spring.lesson6.repositories.OrderRepository;
import com.geekbrains.spring.lesson6.repositories.ProductRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SampleData {

    private CustomerRepository customerRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;
    private CategoryRepository categoryRepository;

    public SampleData(CustomerRepository customerRepository, ProductRepository productRepository, OrderRepository orderRepository, CategoryRepository categoryRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    public void init() {
        Category category1 = new Category("fruit", "Fruit");
        Category category2 = new Category("vegetables", "Vegetables");
        Category category3 = new Category("berries", "Berries");

        Product product1 = new Product("Orange", 85.0, category1);
        Product product2 = new Product("Lemon", 70.0, category1);
        Product product3 = new Product("Pumpkin", 20.0, category2);
        Product product4 = new Product("Potatos", 30.0, category2);
        Product product5 = new Product("Apple", 75.0, category1);
        Product product6 = new Product("Onion", 15.0, category2);
        Product product7 = new Product("Cherry", 120.0, category3);
        Product product8 = new Product("Blueberry", 200.0, category3);

        Customer customer1 = new Customer("Alex");
        Customer customer2 = new Customer("Alena");

        Order order1 = new Order();
        order1.setTotalPrice(product1.getPrice());
        order1.setCustomer(customer1);

        order1.setCode("0001");

        Order order2 = new Order();
        order2.setTotalPrice(product2.getPrice());
        order2.setCustomer(customer2);

        order2.setCode("0002");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
        productRepository.save(product7);
        productRepository.save(product8);

        customerRepository.save(customer1);
        customerRepository.save(customer2);

        orderRepository.save(order1);
        orderRepository.save(order2);

    }
}
