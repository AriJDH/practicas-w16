package com.bootcamp.be_java_hisp_w16_g7_espitia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {

    @JsonProperty("user_id")
    private int id;
    @JsonProperty("user_name")
    private String name;
}
