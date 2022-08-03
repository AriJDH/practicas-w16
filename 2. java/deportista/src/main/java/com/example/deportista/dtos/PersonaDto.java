package com.example.deportista.dtos;

import com.example.deportista.entities.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto  implements Serializable {

private Persona persona;

}
