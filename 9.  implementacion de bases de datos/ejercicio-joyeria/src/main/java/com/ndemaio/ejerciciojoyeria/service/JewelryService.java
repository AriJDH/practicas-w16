package com.ndemaio.ejerciciojoyeria.service;

import com.ndemaio.ejerciciojoyeria.model.Jewelry;
import com.ndemaio.ejerciciojoyeria.repository.JewelryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class JewelryService {

    @Autowired
    private JewelryRepository jewelryRepository;


    public Jewelry create(Jewelry aJewelry) {
        jewelryRepository.save(aJewelry);
        return aJewelry;
    }

    public List<Jewelry> getAll() {
        return jewelryRepository.findAll().stream().filter(Jewelry::getCanBeSold).collect(Collectors.toList());
    }

    public void removeJewelryById(int anId) {
        Jewelry jewelryToDelete = jewelryRepository.findById(anId).get();
        jewelryToDelete.setCanBeSold(false);
        jewelryRepository.save(jewelryToDelete);
    }

    public Jewelry update(int id, Jewelry updatedJewelry) {
        updatedJewelry.setIdentifierNumber(id);
        jewelryRepository.save(updatedJewelry);
        return updatedJewelry;
    }
}
