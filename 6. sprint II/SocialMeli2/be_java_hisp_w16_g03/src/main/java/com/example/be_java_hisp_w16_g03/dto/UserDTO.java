package com.example.be_java_hisp_w16_g03.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDTO {

    @NotNull(message = "El id no puede estar vacío")
    @Positive(message = "El id debe ser mayor a 0")
    private Integer userId;

    @Size(max = 15, message = "El nombre de usuario debe contener maximo 15 caracteres")
    private String userName;

}
