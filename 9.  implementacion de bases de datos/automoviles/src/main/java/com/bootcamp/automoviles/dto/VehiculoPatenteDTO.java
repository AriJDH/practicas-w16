package com.bootcamp.automoviles.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehiculoPatenteDTO {
    private Long id;
    private String patente;
}
