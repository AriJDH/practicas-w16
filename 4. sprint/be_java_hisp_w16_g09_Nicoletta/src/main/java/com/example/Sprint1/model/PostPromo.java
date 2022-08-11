package com.example.Sprint1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPromo extends Post{
    private boolean has_promo;
    private double discount;
}
