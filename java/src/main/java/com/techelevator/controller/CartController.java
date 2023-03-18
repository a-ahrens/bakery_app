package com.techelevator.controller;

import com.techelevator.dao.ShoppingCart.CartDao;
import com.techelevator.model.cart.CartItem;
import com.techelevator.model.cart.ShoppingCart;
import com.techelevator.model.products.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CartController {

    private CartDao cartDao;

    public CartController(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    //check if cart exists, return existing cart. If not then create new cart

    //update cart from guest to user account

    //add item to cart
    @RequestMapping (value = "/cart/add", method = RequestMethod.POST)
    public CartItem addItemToCart(@RequestBody CartItem cartItem){
        //TODO rewrite cart dao pattern for add items to cart. Needs to accept a CartItem object
        return null;
    }

    //remove item from cart


    //get list of cart items
        //postman example: createdDate is not needed here. Leave null for now
        //         {
        //             "cartId" : 3,
        //             "customerId" : 3,
        //             "createdDate" : null
        //         }
    @RequestMapping (value = "/cart", method = RequestMethod.GET)
    public List<CartItem> viewCart(@RequestBody ShoppingCart shoppingCart){
        return cartDao.viewShoppingCart(shoppingCart.getCartId());
    }


    //empty existing cart





}
