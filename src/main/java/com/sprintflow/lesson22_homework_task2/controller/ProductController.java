package com.sprintflow.lesson22_homework_task2.controller;

import com.sprintflow.lesson22_homework_task2.model.Product;
import com.sprintflow.lesson22_homework_task2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {
    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/showProducts")
    @ResponseBody
    //public List<Product> showProducts(@RequestParam(name = "category", required = false) String category) {
    public String showProducts(@RequestParam(name = "category", required = false) String category) {

        List<Product> products = productRepository.getAll();
        List<Product> productList;

        if (category == null) {
            productList = products;
        } else {
            productList = products.stream()
                    .filter(product -> product.getCategory().getName().equals(category))
                    .collect(Collectors.toList());
        }

        double totalPrice = 0;

        for (Product product : productList) {
            totalPrice += product.getPrice();
        }
        String list="";
        for (Product product : productList) {
            list += product + "<br/>";
        }

        String listAndPrice = list + "<br/><br/> Suma cen:" + totalPrice;



        return listAndPrice;
    }
}
