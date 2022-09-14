package com.meli.covid.repository;

import com.meli.covid.dto.SymptomDto;

import java.util.List;

public interface ISymptomRepository {
    List<SymptomDto> findSymptom();
    SymptomDto findSymptomByName(String name);
}
