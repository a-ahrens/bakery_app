package com.techelevator.dao.ShoppingCart;

import com.techelevator.model.cart.CartItem;
import com.techelevator.model.cart.ShoppingCart;
import com.techelevator.model.products.Product;

import java.util.List;

public interface CartDao {

    //check if cart exists, return existing cart. If not then create new cart
    ShoppingCart loginShoppingCart(int customerId);

    //update active cart from guest to user account when they log in
    ShoppingCart guestLoginShoppingCart(int cartId, int customerId);

    //add item to cart
    boolean addItemToCart(int cartId, Product product, int quantity);

    //remove item from cart
    boolean removeItemFromCart(int cartId, Product product);

    //get list of cart items
    List<CartItem> viewShoppingCart(int cartId);

    //empty existing cart
    List<CartItem> emptyShoppingCart(int cartId);



}
