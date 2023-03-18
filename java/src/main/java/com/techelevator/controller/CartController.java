package com.techelevator.controller;

import com.techelevator.dao.ShoppingCart.CartDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class CartController {

    private CartDao cartdao;

    public CartController(CartDao cartdao) {
        this.cartdao = cartdao;
    }

    //add item to cart

    //remove item from cart

    //get list of cart items

    //empty existing cart

    //create new cart


}
