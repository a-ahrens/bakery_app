package com.techelevator.dao.ShoppingCart;

import com.techelevator.model.cart.CartItemDTO;
import com.techelevator.model.cart.CartItemDetail;
import com.techelevator.model.cart.ShoppingCart;

import java.util.List;

public interface CartDao {

    //check if cart exists, return existing cart. If not then create new cart
    ShoppingCart loginShoppingCart(int customerId);

    //update active cart from guest to user account when they log in
    ShoppingCart guestLoginShoppingCart(int cartId, int customerId);

    //add item to cart
    boolean addItemToCart(CartItemDTO cartItem);

    //remove item from cart
    boolean removeItemFromCart(CartItemDTO cartItem);

    //Adjust quantity of cart item
    boolean updateItemQuantity(CartItemDTO cartItem);

    //get list of cart items
    List<CartItemDetail> viewShoppingCart(int cartId);

    //empty existing cart
    List<CartItemDetail> emptyShoppingCart(int cartId);



}
