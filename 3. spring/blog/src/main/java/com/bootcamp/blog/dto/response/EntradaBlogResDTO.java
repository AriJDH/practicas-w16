package com.bootcamp.blog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlogResDTO {
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
}
