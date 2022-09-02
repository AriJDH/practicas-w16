package com.example.hql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SiniestroIdDTO {
    private int id;
    private Date date;
    private double perdida_economica;
    private int vehiculo;
}