package com.bootcamp.be_java_hisp_w16_g10_Lamela.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
    private Boolean hasPromo;
    private Double discount;
    private Post post;
}
