package com.sprintflow.lesson22_homework_task2.repository;

import com.sprintflow.lesson22_homework_task2.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productList;

    public ProductRepository() {
        this.productList = new ArrayList<>();

        CategoryRepository categoryRepository = new CategoryRepository();
        productList.add(new Product("Mleko", 2.4, categoryRepository.getAll().get(0)));
        productList.add(new Product("Masło", 5, categoryRepository.getAll().get(0)));
        productList.add(new Product("Mydł0", 8, categoryRepository.getAll().get(1)));
        productList.add(new Product("Płyn do prania", 20, categoryRepository.getAll().get(1)));
        productList.add(new Product("Książka", 20, categoryRepository.getAll().get(2)));
        productList.add(new Product("Radio", 120, categoryRepository.getAll().get(2)));

    }
    public List<Product> getAll() {
        return productList;
    }
}
