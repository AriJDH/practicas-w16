package com.example.covid19.util;

import com.example.covid19.dto.response.FindRiskPersonDTO;
import com.example.covid19.dto.response.SympthompByNameDTO;
import com.example.covid19.dto.response.SymthompDTO;
import com.example.covid19.entity.IPerson;
import com.example.covid19.entity.ISympthomp;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    public static List<SymthompDTO> parseSymthompDTO(List<ISympthomp> symthomps) {
        return symthomps
                .stream()
                .map(sympthomp -> SymthompDTO
                    .builder()
                        .code(sympthomp.getCode())
                        .levelSeverity(sympthomp.getLevelSeverity())
                        .name(sympthomp.getName())
                        .build()
                )
                .collect(Collectors.toList());
    }
    public static SympthompByNameDTO parseSympthompByNameDTO(ISympthomp sympthomp) {
        return SympthompByNameDTO
                .builder()
                .levelSeverity(sympthomp.getLevelSeverity())
                .build();
    }
    public static List<FindRiskPersonDTO> parseFindRiskPersonDTO(List<IPerson> people) {
        return people.stream().map(person -> FindRiskPersonDTO
                .builder()
                .name(person.getName())
                .lastName(person.getLastName())
                .build())
                .collect(Collectors.toList()
                );
    }
}
