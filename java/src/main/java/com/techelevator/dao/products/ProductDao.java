package com.techelevator.dao.products;

import com.techelevator.model.products.Product;

import java.util.List;

public interface ProductDao {

    //methods we need to get products

    List<Product> getAllProducts();

    Product getProductById(int productId);

    List<Product> getProductsByType(String productType);
}
