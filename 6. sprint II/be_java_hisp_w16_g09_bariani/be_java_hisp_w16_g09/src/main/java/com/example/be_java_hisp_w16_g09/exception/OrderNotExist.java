package com.example.be_java_hisp_w16_g09.exception;

public class OrderNotExist extends RuntimeException{
    public OrderNotExist() {
        super(String.format("Order not Exist"));
    }
}
