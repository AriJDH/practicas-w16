package com.example.be_java_hisp_w16_g09_Nicoletta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPromoResponseDTO {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}
