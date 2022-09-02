package com.example.hql.dto;

import com.example.hql.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SiniestroDTO {
    private Date date;
    private double perdida_economica;
    private int vehiculo;
}