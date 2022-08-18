package com.example.covid19.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonReqDTO {
    private String name;
    private String lastName;
    private Integer age;
}
