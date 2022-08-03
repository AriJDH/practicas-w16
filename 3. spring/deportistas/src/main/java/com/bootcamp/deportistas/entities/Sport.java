package com.bootcamp.deportistas.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sport {
    private String name;
    private String level;
}
