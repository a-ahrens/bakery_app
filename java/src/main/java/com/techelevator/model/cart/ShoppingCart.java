package com.techelevator.model.cart;

import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.LocalDateTime;

public class ShoppingCart {

    private int cartId;
    private int customerId;
    private LocalDateTime createdDate;
    private String sessionId;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getSessionId(){
        return sessionId;
    }

    public void setSessionId(String uuid) {
        this.sessionId = uuid;
    }
}
