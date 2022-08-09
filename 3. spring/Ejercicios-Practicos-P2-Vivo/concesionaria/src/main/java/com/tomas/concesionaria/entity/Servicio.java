package com.tomas.concesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Servicio {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Long kilometers;
    private String descriptions;

}
