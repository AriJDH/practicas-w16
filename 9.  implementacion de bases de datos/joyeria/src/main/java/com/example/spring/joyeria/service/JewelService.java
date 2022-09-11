package com.example.spring.joyeria.service;

import com.example.spring.joyeria.entity.Jewel;
import com.example.spring.joyeria.repository.IJewelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JewelService implements IJewelService{

    @Autowired
    private IJewelRepository iJewelRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Jewel> getJewelry() {
        return iJewelRepository.findAll();
    }

    @Override
    @Transactional()
    public void saveJewel(Jewel jewel) {
        iJewelRepository.save(jewel);
    }

    @Override
    @Transactional()
    public void deleteJewel(long id) {
        iJewelRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Jewel findJewel(long id) {
        return iJewelRepository.findById(id).orElse(null);
    }
}
