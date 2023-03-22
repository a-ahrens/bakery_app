package com.techelevator.dao.ShoppingCart;

import com.techelevator.model.cart.CartItemDTO;
import com.techelevator.model.cart.CartItemDetail;
import com.techelevator.model.cart.ShoppingCart;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

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
    public boolean addItemToCart(CartItemDTO cartItem) {
        String sql = "INSERT INTO cart_items (cart_id, product_id, quantity) " +
                     "VALUES (?, ?, ?);";
        int rows = jdbcTemplate.update(sql, cartItem.getCartId(), cartItem.getProductId(), cartItem.getQuantity());

        return rows == 1;
    }

    @Override
    public boolean removeItemFromCart(CartItemDTO cartItem) {
        String sql = "DELETE FROM cart_items WHERE cart_id = ? AND product_id = ?;";

        int rows = jdbcTemplate.update(sql, cartItem.getCartId(), cartItem.getProductId());

        return rows == 1;
    }

    @Override
    public boolean updateItemQuantity(CartItemDTO cartItem) {
        String sql = "UPDATE cart_items SET cart_id = ?, product_id = ?, quantity = ?" +
                     "WHERE cart_id = ? AND product_id = ?; ";

        int rows = jdbcTemplate.update(sql, cartItem.getCartId(), cartItem.getProductId(), cartItem.getQuantity(), cartItem.getCartId(), cartItem.getProductId());

        return rows == 1;
    }

    @Override
    public List<CartItemDetail> viewShoppingCart(int cartId) {
        List<CartItemDetail> cartItems = new ArrayList<>();

        String sql = "SELECT products.product_id, products.product_name, products.price, cart_items.quantity, products.image_url " +
                     "FROM cart_items " +
                     "JOIN products ON products.product_id = cart_items.product_id " +
                     "WHERE cart_id = ?;";
        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, cartId);

        while(rs.next()){
            cartItems.add(mapRowToCartItemDetail(rs));
        }

        return cartItems;
    }

    @Override
    public List<CartItemDetail> emptyShoppingCart(ShoppingCart cart) {
        String sql = "DELETE FROM cart_items " +
                "WHERE cart_id = ?";

        int rows = jdbcTemplate.update(sql, cart.getCartId());

        return viewShoppingCart(cart.getCartId());
    }

    private CartItemDetail mapRowToCartItemDetail(SqlRowSet rs){
        CartItemDetail cartItem = new CartItemDetail();

        cartItem.setProductId(rs.getInt("product_id"));
        cartItem.setProductName(rs.getString("product_name"));
        cartItem.setPrice(rs.getDouble("price"));
        cartItem.setQuantity(rs.getInt("quantity"));
        cartItem.setImageURL(rs.getString("image_url"));

        return cartItem;
    }
}
