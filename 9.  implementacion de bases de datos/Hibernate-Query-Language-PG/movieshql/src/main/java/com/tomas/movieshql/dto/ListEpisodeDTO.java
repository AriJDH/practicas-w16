package com.tomas.movieshql.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ListEpisodeDTO {

    private List<EpisodeDTO> episodes;
}
