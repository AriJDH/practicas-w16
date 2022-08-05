package com.concesionaria.concensionaria.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceEntity {
    private Date date;
    private Integer kilometers;
    private StringBuffer descriptions;
}

