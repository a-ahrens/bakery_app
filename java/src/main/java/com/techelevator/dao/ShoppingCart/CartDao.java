package com.techelevator.dao.ShoppingCart;

import com.techelevator.model.cart.CartItemDTO;
import com.techelevator.model.cart.CartItemDetail;
import com.techelevator.model.cart.ShoppingCart;

import java.util.List;

public interface CartDao {

    //create shopping cart for guest user
    ShoppingCart createGuestCart(String uuid);

    //convert guest cart to registered cart
    ShoppingCart convertToRegisteredCart(int cartId, int customerId);

    //get cart by cart id
    ShoppingCart getCartByCartId(int cartId);

    //get shopping cart for registered user
    ShoppingCart getRegisteredCart(int customerId);

    //get item from cart
    CartItemDTO getCartItem(int cartId, int productId);

    //add item to cart
    boolean addItemToCart(CartItemDTO cartItem);

    //remove item from cart
    boolean removeItemFromCart(CartItemDTO cartItem);

    //Adjust quantity of cart item
    boolean updateItemQuantity(CartItemDTO cartItem);

    //get list of cart items
    List<CartItemDetail> viewShoppingCart(int cartId);

    //empty existing cart
    List<CartItemDetail> emptyShoppingCart(ShoppingCart cart);



}
