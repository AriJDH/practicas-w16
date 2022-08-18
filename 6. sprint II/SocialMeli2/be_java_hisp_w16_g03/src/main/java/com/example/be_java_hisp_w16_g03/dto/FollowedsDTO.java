package com.example.be_java_hisp_w16_g03.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class FollowedsDTO {

    @NotNull(message = "El id no puede estar vacío")
    @Positive(message = "El id debe ser mayor a 0")
    private Integer userId;

    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    private String userName;

    private List<@Valid UserDTO> followed;

    public FollowedsDTO() {
        this.followed = new ArrayList<>();
    }
}
