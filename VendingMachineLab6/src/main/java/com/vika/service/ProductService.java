package com.vika.service;

import com.vika.models.Location;
import com.vika.models.Product;
import com.vika.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() throws Exception {
        List<Product> reports = new LinkedList<>(productRepository.findAll());
        if (reports.isEmpty()) {
            return null;
        }
        return reports;
    }

    public Product findById(Integer id) throws Exception {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Product entity) throws Exception {
        if (entity != null) {
            productRepository.save(entity);
        }
    }

    @Transactional
    public void update(Product entity) throws Exception {
        productRepository.findById(entity.getId())
                .map(oldEntity -> {
                    oldEntity.setSize(entity.getSize());
                    oldEntity.setPrice(entity.getPrice());
                    oldEntity.setType(entity.getType());
                    oldEntity.setExpirationDate(entity.getExpirationDate());
                    oldEntity.setMenuId(entity.getMenuId());
                    oldEntity.setManufacturerId(entity.getManufacturerId());
                    return productRepository.save(oldEntity);
                })
                .orElseGet(() -> productRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
        }
    }


}
