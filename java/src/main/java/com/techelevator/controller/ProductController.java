package com.techelevator.controller;

import com.techelevator.dao.products.JdbcProductDao;
import com.techelevator.dao.products.ProductDao;
import com.techelevator.model.products.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

public class ProductController {

    private ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    //all products
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        return productDao.getAllProducts();
    }

    //product by id
    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int productId){
        return productDao.getProductById(productId);
    }


}
