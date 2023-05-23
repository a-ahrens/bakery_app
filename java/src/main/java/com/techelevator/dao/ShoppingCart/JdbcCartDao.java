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
    public ShoppingCart createGuestCart(String uuid) {
        String sql = "INSERT INTO shopping_cart (session_id) " +
                     "VALUES (?) RETURNING cart_id;";

        Integer cartId = jdbcTemplate.queryForObject(sql, Integer.class, uuid);

        System.out.println();

        return getCartByCartId(cartId);
    }

    @Override
    public ShoppingCart convertToRegisteredCart(int cartId, int customerId) {
        return null;
    }

    @Override
    public ShoppingCart getCartByCartId(int cartId){
        String sql = "SELECT cart_id, customer_id, created_on, session_id " +
                     "FROM shopping_cart " +
                     "WHERE cart_id = ?;";

        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, cartId);

        if (rs.next()){
            return mapRowToShoppingCart(rs);
        }

        return null;

    }

    @Override
    public ShoppingCart getRegisteredCart(int customerId) {
        return null;
    }

    @Override
    public CartItemDTO getCartItem(int cartId, int productId){
        String sql = "SELECT cart_id, product_id, quantity " +
                     "FROM cart_items " +
                     "WHERE cart_id = ? AND product_id = ?;";

        SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, cartId, productId);

        if(rs.next()){
            return mapRowToCartItemDTO(rs);
        }

        return null;
    }

    @Override
    public boolean addItemToCart(CartItemDTO newItem) {
        CartItemDTO itemCheck = getCartItem(newItem.getCartId(), newItem.getProductId());

        if(itemCheck != null) {
            newItem.setQuantity( newItem.getQuantity() + itemCheck.getQuantity() );
            return updateItemQuantity(newItem);
        }

        String sql = "INSERT INTO cart_items (cart_id, product_id, quantity) " +
                     "VALUES (?, ?, ?);";
        int rows = jdbcTemplate.update(sql, newItem.getCartId(), newItem.getProductId(), newItem.getQuantity());

        return rows == 1;
    }

    @Override
    public boolean removeItemFromCart(CartItemDTO cartItem) {
        String sql = "DELETE FROM cart_items WHERE cart_id = ? AND product_id = ?;";

        int rows = jdbcTemplate.update(sql, cartItem.getCartId(), cartItem.getProductId());

        return rows == 1;
    }

    @Override
    public boolean updateItemQuantity(CartItemDTO updateItem) {
        CartItemDTO itemCheck = getCartItem(updateItem.getCartId(), updateItem.getProductId());

        if(itemCheck.getQuantity() == updateItem.getQuantity()){
            return removeItemFromCart(updateItem);
        }

        String sql = "UPDATE cart_items SET cart_id = ?, product_id = ?, quantity = ?" +
                     "WHERE cart_id = ? AND product_id = ?; ";

        int rows = jdbcTemplate.update(sql, updateItem.getCartId(), updateItem.getProductId(), updateItem.getQuantity(), updateItem.getCartId(), updateItem.getProductId());

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

    private CartItemDTO mapRowToCartItemDTO(SqlRowSet rs){
        CartItemDTO cartItem = new CartItemDTO();
        cartItem.setCartId(rs.getInt("cart_id"));
        cartItem.setProductId(rs.getInt("product_id"));
        cartItem.setQuantity(rs.getInt("quantity"));

        return cartItem;
    }

    private ShoppingCart mapRowToShoppingCart(SqlRowSet rs){
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setCartId(rs.getInt("cart_id"));
        shoppingCart.setCustomerId(rs.getInt("customer_id"));
        shoppingCart.setCreatedDate((rs.getTimestamp("created_on")).toLocalDateTime());
        shoppingCart.setSessionId(rs.getString("session_id"));

        return shoppingCart;
    }
}
