package com.vika.controllers;

import com.vika.models.Menu;
import com.vika.models.Product;
import com.vika.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vending_machine_db")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/product")
    public List<Product> findAll() throws Exception {
        return productService.findAll();
    }
    @GetMapping("/product/{id}")
    public Product findById(@PathVariable Integer id) throws Exception {
        return productService.findById(id);
    }

    @PostMapping("/product")
    public void create(@RequestBody Product entity) throws Exception {
        productService.create(entity);
    }

    @PutMapping("/product/{id}")
    public void update(@PathVariable Integer id, @RequestBody Product entity) throws Exception {
        entity.setId(id);
        productService.update(entity);
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        productService.delete(id);
    }
}