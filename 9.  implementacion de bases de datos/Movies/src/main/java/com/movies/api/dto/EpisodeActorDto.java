package com.movies.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeActorDto {

    private ActorDto actorDto;
    private List<EpisodeDto> episodeDtoList;
}
