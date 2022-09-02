package com.example.hql.service;

import com.example.hql.dto.SiniestroDTO;
import com.example.hql.dto.SiniestroIdDTO;
import com.example.hql.dto.VehiculoDTO;

import java.util.List;

public interface ServiceSiniestro {
    String add(SiniestroDTO siniestroDTO);
    SiniestroIdDTO getById(int id);
    List<SiniestroIdDTO> getAll();

}
