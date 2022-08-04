package com.example.ejercicio1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

//@Data
@Getter
@Setter
@AllArgsConstructor
public class EdadDTO {
    private int edadDto;
}
