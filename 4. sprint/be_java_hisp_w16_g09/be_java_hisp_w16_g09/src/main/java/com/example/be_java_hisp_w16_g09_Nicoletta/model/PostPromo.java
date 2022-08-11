package com.example.be_java_hisp_w16_g09_Nicoletta.model;

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
