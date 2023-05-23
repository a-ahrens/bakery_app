package com.techelevator.controller;

import com.techelevator.dao.ShoppingCart.CartDao;
import com.techelevator.model.cart.CartItemDTO;
import com.techelevator.model.cart.CartItemDetail;
import com.techelevator.model.cart.ShoppingCart;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CartController {

    private CartDao cartDao;

    public CartController(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    //create new shopping cart for guest
    @RequestMapping (value = "/cart/guest", method = RequestMethod.POST)
    public ShoppingCart createNewGuestCart(@RequestBody ShoppingCart cart){
        return cartDao.createGuestCart(cart.getSessionId());
    }

    //get cart info by cart id
    @RequestMapping (value = "/cart", method = RequestMethod.GET)
    public ShoppingCart getCartByCartId(@RequestBody ShoppingCart cart){
        return cartDao.getCartByCartId(cart.getCartId());
    }


    //add item to cart
        /*Example:
            {
                "cartId" : 3,
                "productId" : 3,
                "quantity" : 2
            }
         */
    @RequestMapping (value = "/cart/items", method = RequestMethod.POST)
    public boolean addItemToCart(@RequestBody CartItemDTO cartItem){
        return cartDao.addItemToCart(cartItem);
    }

    //remove item from cart
        /*Example:
            {
                "cartId" : 3,
                "productId" : 3,
            }
        */
    @RequestMapping (value = "/cart/items", method = RequestMethod.DELETE)
    public boolean removeItemFromCart(@RequestBody CartItemDTO cartItem){
        return cartDao.removeItemFromCart(cartItem);
    }

    //update item quantity in cart
        /*Example:
            {
                "cartId" : 3,
                "productId" : 3,
                "quantity" : 2
            }
         */
    @RequestMapping (value = "/cart/items", method = RequestMethod.PUT)
    public boolean updateItemQuantityInCart(@RequestBody CartItemDTO cartItem){
        return cartDao.updateItemQuantity(cartItem);
    }

    //get list of cart items
        //postman example: createdDate is not needed here. Leave null for now
        //         {
        //             "cartId" : 3,
        //             "customerId" : 3,
        //             "createdDate" : null
        //         }
    @RequestMapping (value = "/cart/items", method = RequestMethod.GET)
    public List<CartItemDetail> viewCart(@RequestBody ShoppingCart shoppingCart){
        return cartDao.viewShoppingCart(shoppingCart.getCartId());
    }


    //empty existing cart
        /*Example:
            {
                "cartId" : 3
            }
         */
    @RequestMapping(value = "/cart/empty", method = RequestMethod.DELETE)
    public List<CartItemDetail> emptyCart(@RequestBody ShoppingCart cart){
        //TODO Complete clear cart methods under JdbcCartDao. Modify to accept a Shopping Cart object.


        return cartDao.emptyShoppingCart(cart);
    }




}
