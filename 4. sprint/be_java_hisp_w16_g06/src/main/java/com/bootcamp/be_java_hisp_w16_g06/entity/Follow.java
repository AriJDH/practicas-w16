package com.bootcamp.be_java_hisp_w16_g06.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Follow {
    @JsonProperty("user_id")
    private int id;
    @JsonProperty("user_name")
    private String name;
}
