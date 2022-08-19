package com.example.be_java_hisp_w16_g09_Nicoletta.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MessageDto {
    String message;
    HashMap<String, List<String>> ErrorFields;
    public MessageDto(String message) {
        this.message = message;
    }
}

