package com.bootcamp.SocialMeli2_gonzalez.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionApiDto {
    private String title;
    private String message;


}
