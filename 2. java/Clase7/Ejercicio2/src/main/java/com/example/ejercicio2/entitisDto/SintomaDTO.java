package com.example.ejercicio2.entitisDto;

import com.example.ejercicio2.entities.Sintomas;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SintomaDTO {
   private Sintomas sintoma;
}
