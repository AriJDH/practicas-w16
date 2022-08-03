package com.myapp.deportista.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sport {
    private String name;
    private String level;
}
