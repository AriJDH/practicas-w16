package com.example.springcovid19.entityDTO;

import com.example.springcovid19.entity.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SintomaDTO {
   private Sintoma sintoma;
}
