package com.example.sports.repository;

import com.example.sports.entity.ISport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class SportRepository implements ISportRepository {
    private List<ISport> sports = new ArrayList<>();

    @Override
    public List<ISport> findAll() {
        return this.sports;
    }

    @Override
    public ISport findByName(String name) {
        return this.sports.stream()
                .filter(iSport -> iSport.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
    @Override
    public Map<Integer, ISport> findByIds(List<Integer> ids) {
        Map<Integer, Boolean> idsMap = new HashMap<>();
        ids.forEach(integer -> idsMap.put(integer, true));
        Map<Integer, ISport> map = new HashMap<>();
        this.sports.forEach(iSport -> {
            if(idsMap.get(iSport.getId()) == true) {
                map.put(iSport.getId(), iSport);
            }
        });
        return map;
    }
}
