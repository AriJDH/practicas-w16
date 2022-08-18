package com.example.sports.util;

import com.example.sports.dto.response.PersonWithSportDTO;
import com.example.sports.dto.response.SportDTO;
import com.example.sports.dto.response.SportLevelDTO;
import com.example.sports.entity.IPerson;
import com.example.sports.entity.ISport;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Mapper {
    static public List<SportDTO> parseToSportDTO(List<ISport> sports) {
        return sports
                .stream()
                .map(sport -> SportDTO
                        .builder()
                        .name(sport.getName())
                        .level(sport.getLevel())
                        .build()
                )
                .collect(Collectors.toList());
    }

    static public SportLevelDTO parseSportLevelDTO(ISport sport) {
        return SportLevelDTO.builder().level(sport.getLevel()).build();
    }

    static public List<PersonWithSportDTO> parsePersonWithSportDTO(List<IPerson> sportsman, Map<Integer, ISport> sports) {
        return sportsman.stream().map(iPerson -> {
            return PersonWithSportDTO
                    .builder()
                    .name(iPerson.getName())
                    .lastName(iPerson.getLastName())
                    .sport(sports.get(iPerson.getSportId()).getName())
                    .build();
        }).collect(Collectors.toList());
    }
}
