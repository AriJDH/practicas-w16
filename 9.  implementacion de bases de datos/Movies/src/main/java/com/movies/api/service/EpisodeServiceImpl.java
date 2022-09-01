package com.movies.api.service;

import com.movies.api.dto.ActorDto;
import com.movies.api.dto.EpisodeActorDto;
import com.movies.api.dto.EpisodeDto;
import com.movies.api.model.Actor;
import com.movies.api.repository.IActorRepository;
import com.movies.api.repository.IEpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeServiceImpl implements IEpisodeService{

    @Autowired
    private IEpisodeRepository episodeRepository;

    @Autowired
    private IActorRepository actorRepository;

    @Override
    public EpisodeActorDto getEpisodesOfActor(String firstName,String lastName) throws Exception {
        List<EpisodeDto> episodeDtoList = episodeRepository.findEpisodesByActorsFirstName(firstName,lastName)
                .stream()
                .map( e -> new EpisodeDto(e.getTitle(),e.getNumber(),e.getReleaseDate(),e.getRating()))
                .collect(Collectors.toList());

        if(episodeDtoList.isEmpty()) throw new Exception("No se encontraron episodios del actor: " +firstName);

        Actor actor = actorRepository.findActorByFirstNameAndLastName(firstName,lastName);

        if(actor==null)throw new Exception("No se encontro el actor: " +firstName);
        ActorDto actorDto = new ActorDto(actor.getFirstName(), actor.getLastName(), actor.getRating());

        return new EpisodeActorDto(actorDto,episodeDtoList);
    }
}
