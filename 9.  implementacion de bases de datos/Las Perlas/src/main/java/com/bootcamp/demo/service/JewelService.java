package com.bootcamp.demo.service;

import com.bootcamp.demo.model.Jewel;
import com.bootcamp.demo.repository.JewelRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class JewelService implements IJewelService {

    private final JewelRepository jewelRepo;

    public JewelService(JewelRepository jewelRepo) {
        this.jewelRepo = jewelRepo;
    }

    @Override
    @Transactional (readOnly = true)
    public List<Jewel> getJewels() {
        List<Jewel> jewelList = jewelRepo.findAll();
        return jewelList;
    }

    @Override
    @Transactional
    public void saveJewel(Jewel jew) {
        jewelRepo.save(jew);
    }

    @Override
    @Transactional
    public void deleteJewel(long id) {
        jewelRepo.deleteById(id);
    }

    @Override
    @Transactional (readOnly = true)
    public Jewel findJewel(long id) {
        Jewel jew = jewelRepo.findById(id).orElse(null);
        return jew;
    }
}
