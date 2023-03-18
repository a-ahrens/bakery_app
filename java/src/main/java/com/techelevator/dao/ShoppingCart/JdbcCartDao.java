package com.techelevator.dao.ShoppingCart;

import com.techelevator.model.cart.CartItem;
import com.techelevator.model.cart.ShoppingCart;
import com.techelevator.model.products.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.RowSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCartDao implements CartDao{

    JdbcTemplate jdbcTemplate;

    public JdbcCartDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ShoppingCart loginShoppingCart(int customerId) {
        return null;
    }

    @Override
    public ShoppingCart guestLoginShoppingCart(int cartId, int customerId) {
        return null;
    }

    @Override
    public boolean addItemToCart(int cartId, Product product, int quantity) {
        String sql = "INSERT INTO cart_items (cart_id, product_id, quantity, price) " +
                     "VALUES (?, ?, ?, ?);";
        int rows = jdbcTemplate.update(sql, cartId, product.getId(), quantity, product.getPrice() * quantity);

        return rows == 1;
    }

    @Override
    public boolean removeItemFromCart(int cartId, Product product) {
        String sql = "DELETE FROM cart_items WHERE cart_id = ? AND product_id = ?;";

        int rows = jdbcTemplate.update(sql, cartId, product.getId());

        return rows == 1;
    }

    @Override
    public List<CartItem> viewShoppingCart(int cartId) {
        List<CartItem> cartItems = new ArrayList<>();

        String sql = "SELECT * FROM cart_items " +
                     "WHERE cart_id = ?;";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, cartId);

        while(rs.next()){
            cartItems.add(mapRowToCartItem(rs));
        }

        return cartItems;
    }

    @Override
    public List<CartItem> emptyShoppingCart(int cartId) {
        return null;
    }

    private CartItem mapRowToCartItem(SqlRowSet rs){
        CartItem cartItem = new CartItem();

        cartItem.setLineItem(rs.getInt("line_item"));
        cartItem.setCartId(rs.getInt("cart_id"));
        cartItem.setProductId(rs.getInt("product_id"));
        cartItem.setQuantity(rs.getInt("quantity"));
        cartItem.setPrice(rs.getDouble("price"));

        return cartItem;
    }
}
