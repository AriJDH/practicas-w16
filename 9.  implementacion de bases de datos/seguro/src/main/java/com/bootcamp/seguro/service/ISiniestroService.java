package com.bootcamp.seguro.service;

import com.bootcamp.seguro.dto.SiniestroDto;

import java.util.List;

public interface ISiniestroService {
    SiniestroDto findById(Long id);

    List<SiniestroDto> findAll(SiniestroDto filter);

    SiniestroDto save(SiniestroDto modelDto);

    SiniestroDto update(Long id, SiniestroDto modelDto);

    void delete(Long id);
}
