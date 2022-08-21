package com.bootcamp.be_java_hisp_w16_g7.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataTypeExceptionDTO {

    private String title;
    private HttpStatus status;
    private HashMap<String, List<String>> errors = new HashMap<>();
}
