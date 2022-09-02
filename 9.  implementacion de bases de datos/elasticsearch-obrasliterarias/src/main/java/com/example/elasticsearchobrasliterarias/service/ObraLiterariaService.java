package com.example.elasticsearchobrasliterarias.service;

import com.example.elasticsearchobrasliterarias.model.ObraLiteraria;
import com.example.elasticsearchobrasliterarias.repository.IObraLiterariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaService implements IObraLiterariaService {
    @Autowired
    private IObraLiterariaRepository obraLiterariaRepository;

    @Override
    public ObraLiteraria create(ObraLiteraria obraLiteraria) {
        return this.obraLiterariaRepository.save(obraLiteraria);
    }

    public Iterable<ObraLiteraria> getAll() {
        return this.obraLiterariaRepository.findAll();
    }
}
