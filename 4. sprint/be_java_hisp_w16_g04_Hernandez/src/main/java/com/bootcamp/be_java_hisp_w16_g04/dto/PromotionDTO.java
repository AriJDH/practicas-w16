package com.bootcamp.be_java_hisp_w16_g04.dto;

import com.bootcamp.be_java_hisp_w16_g04.model.Promotion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionDTO {
    private Integer userId;
    private String userName;
    private List<Promotion> posts;
}
