package com.example.practicajoyeria.service;

import com.example.practicajoyeria.dto.JewelryDTO;
import com.example.practicajoyeria.dto.JewelryResponseDTO;
import com.example.practicajoyeria.exception.JewelryNotFoundException;
import com.example.practicajoyeria.model.Jewelry;
import com.example.practicajoyeria.repository.IJewelryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelryService implements IJewelryService {

    IJewelryRepository jewelryRepository;
    ModelMapper modelMapper;

    @Autowired
    public JewelryService(IJewelryRepository jewelryRepository) {
        this.jewelryRepository = jewelryRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public Jewelry saveJewelry(Jewelry jewelry) {
        return jewelryRepository.save(jewelry);
    }

    @Override
    public JewelryResponseDTO saveJewelry(JewelryDTO jewelryDTO) {
        Jewelry jewelry = modelMapper.map(jewelryDTO, Jewelry.class);
        jewelry = jewelryRepository.save(jewelry);
        return new JewelryResponseDTO(
                jewelry.getId(),
                jewelry.getName(),
                jewelry.getMaterial(),
                jewelry.getWeight(),
                jewelry.isStone(),
                jewelry.isSellable());
    }


    @Override
    public JewelryResponseDTO findJewelryById(long id) throws JewelryNotFoundException {
        Jewelry jewelry = jewelryRepository.findById(id).orElseThrow(() -> new JewelryNotFoundException("Test 1"));
        return modelMapper.map(jewelry, JewelryResponseDTO.class);
    }

    @Override
    public List<Jewelry> findAllJewelry() {
        return jewelryRepository.findAll();
    }

    @Override
    public void deleteJewelryById(long id) {
        jewelryRepository.deleteById(id);
    }

    @Override
    public Jewelry updateJewelryById(Jewelry jewelry) throws JewelryNotFoundException {
        Jewelry jewelryToUpdate = jewelryRepository.findById(jewelry.getId()).orElseThrow(() -> new JewelryNotFoundException("Jewelry to be updated could not be found."));
        jewelryToUpdate.setName(jewelry.getName());
        jewelryToUpdate.setWeight(jewelry.getWeight());
        jewelryToUpdate.setMaterial(jewelry.getMaterial());
        jewelryToUpdate.setStone(jewelry.isStone());
        jewelryToUpdate.setSellable(jewelryToUpdate.isSellable());
        saveJewelry(jewelryToUpdate);
        return jewelryToUpdate;
    }
}
