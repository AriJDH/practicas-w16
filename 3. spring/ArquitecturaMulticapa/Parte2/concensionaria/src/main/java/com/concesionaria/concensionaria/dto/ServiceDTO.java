package com.concesionaria.concensionaria.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {
    private Date date;
    private Integer kilometers;
    private StringBuffer descriptions;
}
