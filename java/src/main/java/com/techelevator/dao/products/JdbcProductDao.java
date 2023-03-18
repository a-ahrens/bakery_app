package com.techelevator.dao.products;

import com.techelevator.model.products.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class JdbcProductDao implements ProductDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcProductDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        String sql = "SELECT * FROM products";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            allProducts.add(mapRowToProduct(results));
        }
        return allProducts;
    }

    @Override
    public Product getProductById(int productId) {
        Product product = new Product();
        String sql = "SELECT * FROM products WHERE product_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, productId);
        if (result.next()){
            product = mapRowToProduct(result);
        }
        return product;
    }

    public List<Product> getProductsByType(String productType){
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE product_type = ?;";

        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, productType);
        while (rs.next()){
            products.add(mapRowToProduct(rs));
        }

        return products;
    }



    private Product mapRowToProduct(SqlRowSet rs){
        Product product = new Product();
        product.setId(rs.getInt("product_id"));
        product.setProductType(rs.getString("product_type"));
        product.setProductName(rs.getString("product_name"));
        product.setDescription(rs.getString("description"));
        product.setPrice(rs.getDouble("price"));
        product.setImageUrl(rs.getString("image_url"));
        product.setKeywords(rs.getString("keywords"));
        product.setDiscountCode(rs.getString("discount_code"));

        return product;

        }
    }

