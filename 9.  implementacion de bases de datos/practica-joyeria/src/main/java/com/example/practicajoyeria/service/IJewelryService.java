package com.example.practicajoyeria.service;

import com.example.practicajoyeria.dto.JewelryDTO;
import com.example.practicajoyeria.dto.JewelryResponseDTO;
import com.example.practicajoyeria.exception.JewelryNotFoundException;
import com.example.practicajoyeria.model.Jewelry;

import java.util.List;

public interface IJewelryService {
    Jewelry saveJewelry(Jewelry jewelry);
    JewelryResponseDTO saveJewelry(JewelryDTO jewelryDTO);
    JewelryResponseDTO findJewelryById(long id) throws JewelryNotFoundException;
    List<Jewelry> findAllJewelry();
    void deleteJewelryById(long id);
    Jewelry updateJewelryById(Jewelry jewelry) throws JewelryNotFoundException;
}
