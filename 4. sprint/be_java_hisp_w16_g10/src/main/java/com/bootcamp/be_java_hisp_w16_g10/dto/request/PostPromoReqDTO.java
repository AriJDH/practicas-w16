package com.bootcamp.be_java_hisp_w16_g10.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoReqDTO extends PostReqDTO{
    private boolean hasPromo;
    private double discount;

}
