package com.meli.covid.service;

import com.meli.covid.dto.SymptomDto;
import com.meli.covid.repository.ISymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomService implements ISymptomService {

    @Autowired
    ISymptomRepository symptomRepository;

    @Override
    public List<SymptomDto> findSymptom() {
        return symptomRepository.findSymptom();
    }

    @Override
    public SymptomDto findSymptomByName(String name) {
        return symptomRepository.findSymptomByName(name);
    }
}
