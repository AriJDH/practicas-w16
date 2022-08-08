package com.ejemplo.covid.dto;

import com.ejemplo.covid.entity.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SintomaDTO {

    private List<Sintoma> sintoma;

}
