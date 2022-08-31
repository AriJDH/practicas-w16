package com.javaW16.joyeriaLasPerlas.dto.resDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class JoyaResDTO {
   
   Long id;
   Integer nroIdentificatorio;
   String nombre;
   String material;
   Double gramos;
   String particularidad;
   Boolean poseePiedra;
   Boolean ventas;

}
