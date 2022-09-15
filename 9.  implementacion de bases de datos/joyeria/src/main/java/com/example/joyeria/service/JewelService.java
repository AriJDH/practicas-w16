package com.example.joyeria.service;

import com.example.joyeria.dto.ReqJewelDTO;
import com.example.joyeria.dto.ReqUpdateJewelDTO;
import com.example.joyeria.dto.ResJewelDTO;
import com.example.joyeria.model.Jewel;
import com.example.joyeria.repository.IJewelRepository;
import com.example.joyeria.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelService implements IJewelService {
    private IJewelRepository jewelRepository;
    JewelService(IJewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
    }

    @Override
    public ResJewelDTO addJewel(ReqJewelDTO reqJewelDTO) {
        Jewel jewel = new Jewel();
        jewel.setName(reqJewelDTO.getName());
        jewel.setMaterial(reqJewelDTO.getMaterial());
        jewel.setWeight(reqJewelDTO.getWeight());
        jewel.setParticularity(reqJewelDTO.getParticularity());
        jewel.setHasStone(reqJewelDTO.getHasStone());
        this.jewelRepository.save(jewel);
        return Mapper.mapResJewelDTO(jewel);
    }

    @Override
    public List<ResJewelDTO> getAll() {
        return Mapper.mapListResJewelDTO(this.jewelRepository.findAllByIsSold(false));
    }

    @Override
    public void delete(Long id) {
        this.jewelRepository.delete(this.jewelRepository.getReferenceById(id));
    }

    @Override
    public ResJewelDTO update(ReqUpdateJewelDTO reqUpdateJewelDTO, Long id) {
        System.out.println(reqUpdateJewelDTO);
        Jewel jewel = this.jewelRepository.getReferenceById(id);
        if(reqUpdateJewelDTO.getName() != null) {
            jewel.setName(reqUpdateJewelDTO.getName());
        }
        if(reqUpdateJewelDTO.getMaterial() != null) {
            jewel.setMaterial(reqUpdateJewelDTO.getMaterial());
        }
        if(reqUpdateJewelDTO.getWeight() != null) {
            jewel.setWeight(reqUpdateJewelDTO.getWeight());
        }
        if(reqUpdateJewelDTO.getParticularity() != null) {
            jewel.setParticularity(reqUpdateJewelDTO.getParticularity());
        }
        if(reqUpdateJewelDTO.getHasStone() != null) {
            jewel.setHasStone(reqUpdateJewelDTO.getHasStone());
        }
        if(reqUpdateJewelDTO.getIsSold() != null) {
            jewel.setIsSold(reqUpdateJewelDTO.getIsSold());
        }
        this.jewelRepository.save(jewel);
        return Mapper.mapResJewelDTO(jewel);
    }
}
