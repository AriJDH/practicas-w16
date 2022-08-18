package com.example.covid19.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FindRiskPersonDTO {
    private String name;
    private String lastName;
}
