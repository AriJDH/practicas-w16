package com.bootcamp.blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlogReqDTO {
    private Long id;
    private String titulo;
    private String autor;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaPublicacion;
}
