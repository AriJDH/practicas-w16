package com.example.deportitas.dto;

import com.example.deportitas.entities.Deporte;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeporteDto implements Serializable {

    //private String deportes;
    private Map<String, String> deportesLista;
    private List<String> deporte;
    private List<String> nivel;


}
