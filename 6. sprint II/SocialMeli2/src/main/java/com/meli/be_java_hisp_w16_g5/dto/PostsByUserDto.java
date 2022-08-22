package com.meli.be_java_hisp_w16_g5.dto;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
/**
 * Clase, estructura para post por usuario
 */
public class PostsByUserDto {
    private Integer userId;
    private List<PostDto> posts;
}
