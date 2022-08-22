package com.meli.be_java_hisp_w16_g5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
/**
 * Entidad con la estructura de un User
 */

 @Data
public class User {

    @NotNull(message = "El Id del usuario No debe estar vacío")
    @Min(value = 1, message = "El id del usuario debe ser mayor a cero")
    private  Integer  userId;

    @Size(max=15, message = "El nombre del usuario debe tener 15 caracteres como máximo")
    private String userName;

    private List<@Valid Post> posts;
    private List<@Valid User> followers;//los que me siguen
    private List<@Valid User> following;//los que sigo
}
