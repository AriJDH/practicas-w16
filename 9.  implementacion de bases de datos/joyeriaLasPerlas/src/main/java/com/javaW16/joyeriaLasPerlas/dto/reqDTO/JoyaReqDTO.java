package com.javaW16.joyeriaLasPerlas.dto.reqDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class JoyaReqDTO {
   
   Integer nroIdentificatorio;
   String nombre;
   String material;
   Double gramos;
   String particularidad;
   Boolean poseePiedra;
   Boolean ventas;

}
