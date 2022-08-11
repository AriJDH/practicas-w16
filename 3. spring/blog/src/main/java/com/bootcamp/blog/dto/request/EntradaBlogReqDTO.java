package com.bootcamp.blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlogReqDTO {
    @NotNull
    @Min(1)
    private Long id;
    @NotNull
    private String titulo;
    @NotNull
    private String autor;
    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaPublicacion;
}
