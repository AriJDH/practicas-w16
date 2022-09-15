package com.example.qatesters.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReqPostTestCaseDTO {
    @NotBlank(message = "El campo no puede estar vacio.")
    @Size(max = 100, message = "La longitud no puede superar los 40 caracteres.")
    private String description;
}
