package com.meli.deportista.Repository;

import com.meli.deportista.Dto.SportDto;
import com.meli.deportista.Entity.Sport;
import com.meli.deportista.Util.Util;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SportRepository implements ISportRepository {

    List<Sport> sports;

    public SportRepository() {
        loadData();
    }

    public void loadData() {
        sports = new ArrayList<>();

        sports.add(new Sport("Atletismo", 1));
        sports.add(new Sport("Bádminton", 2));
        sports.add(new Sport("Baloncesto", 3));
        sports.add(new Sport("Balonmano", 1));
        sports.add(new Sport("Biatlón", 4));
    }

    @Override
    public List<SportDto> getSports() {
        return this.sports.stream().map(p-> Util.castTo(p, SportDto.class)).collect(Collectors.toList());
    }

    @Override
    public SportDto getByName(String name) {
        Sport sport = this.sports.stream().filter(sportFilter -> sportFilter.getName().equals(name)).findFirst().orElse(null);
        return sport != null ? new SportDto(sport.getName(), sport.getLevel()): null;
    }
}
