package com.example.covid19.service;

import com.example.covid19.dto.request.SymthompReqDTO;
import com.example.covid19.dto.response.SympthompByNameDTO;
import com.example.covid19.dto.response.SymthompDTO;
import com.example.covid19.entity.ISympthomp;
import com.example.covid19.entity.Symthomp;
import com.example.covid19.repository.IRepository;
import com.example.covid19.repository.ISympthompRepository;
import com.example.covid19.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SympthompService {

    @Autowired
    ISympthompRepository sympthompIRepository;
    public void add(SymthompReqDTO symthomp) {
        this.sympthompIRepository.add(new Symthomp(symthomp.getCode(), symthomp.getName(), symthomp.getLevelSeverity()));
    }
    public List<SymthompDTO> findAll() {
        return Mapper.parseSymthompDTO(this.sympthompIRepository.findAll());
    }
    public SympthompByNameDTO findByName(String name) {
        ISympthomp sympthomp = this.sympthompIRepository.findByName(name);
        return Mapper.parseSympthompByNameDTO(sympthomp);
    }
}
