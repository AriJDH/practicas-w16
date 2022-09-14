package com.meli.covid.service;

import com.meli.covid.dto.SymptomDto;

import java.util.List;

public interface ISymptomService {
    List<SymptomDto> findSymptom();

    SymptomDto findSymptomByName(String name);
}
