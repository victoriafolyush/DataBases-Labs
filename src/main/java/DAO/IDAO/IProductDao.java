package DAO.IDAO;


import models.Product;

import java.util.List;

public interface IProductDao {
    Product findById (int id);
    List<Product> findAll ();
    void create (Product product);
    void update (Product product);
    void delete (Product product);
}
