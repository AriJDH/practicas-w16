package com.bootcamp.SocialMeli2.dto.response;

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
