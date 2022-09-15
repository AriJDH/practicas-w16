package com.example.joyeria.util;

import com.example.joyeria.dto.ResJewelDTO;
import com.example.joyeria.model.Jewel;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    public static List<ResJewelDTO> mapListResJewelDTO(List<Jewel> jewels) {
        return jewels
                .stream()
                .map(Mapper::mapResJewelDTO)
                .collect(Collectors.toList());
    }
    public static ResJewelDTO mapResJewelDTO(Jewel jewel) {
            return ResJewelDTO
                            .builder()
                            .id(jewel.getId())
                            .name(jewel.getName())
                            .material(jewel.getMaterial())
                            .weight(jewel.getWeight())
                            .particularity(jewel.getParticularity())
                            .hasStone(jewel.getHasStone())
                            .build();
    }
}
