package com.example.joyeria.service;

import com.example.joyeria.dto.ReqJewelDTO;
import com.example.joyeria.dto.ReqUpdateJewelDTO;
import com.example.joyeria.dto.ResJewelDTO;
import com.example.joyeria.model.Jewel;

import java.util.List;

public interface IJewelService {
    ResJewelDTO addJewel(ReqJewelDTO reqJewelDTO);
    List<ResJewelDTO> getAll();
    void delete(Long id);
    ResJewelDTO update(ReqUpdateJewelDTO reqUpdateJewelDTO, Long id);
}
