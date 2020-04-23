package service;

import DAO.DAOImpl.MenuDaoImpl;
import DAO.DAOImpl.ProductDaoImpl;
import models.Menu;
import models.Product;

import java.util.List;

public class ProductService {

    public List<Product> findAllProduct() {
        return new ProductDaoImpl().findAll();
    }
    public Product findProductById(int id) {
        return new ProductDaoImpl().findById(id);
    }
    public void createProduct(Product product) {
        new ProductDaoImpl().create(product);
    }
    public void updateProduct(Product product) {
        new ProductDaoImpl().update(product);
    }
    public void deleteProduct(Product product) {
        new ProductDaoImpl().delete(product);
    }
}
