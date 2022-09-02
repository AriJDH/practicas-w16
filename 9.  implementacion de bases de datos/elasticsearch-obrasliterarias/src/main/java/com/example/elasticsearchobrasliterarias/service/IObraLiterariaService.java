package com.example.elasticsearchobrasliterarias.service;

import com.example.elasticsearchobrasliterarias.model.ObraLiteraria;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IObraLiterariaService {
    ObraLiteraria create(ObraLiteraria obraLiteraria);
    Iterable<ObraLiteraria> getAll();
}
