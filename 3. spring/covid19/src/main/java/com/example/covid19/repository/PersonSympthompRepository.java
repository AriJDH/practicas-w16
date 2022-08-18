package com.example.covid19.repository;

import com.example.covid19.entity.IPersonSympthomp;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PersonSympthompRepository implements IPersonSymthompRepository {
    private  List<IPersonSympthomp> personSympthomp= new ArrayList<>();
    @Override
    public List<IPersonSympthomp> findAll() {
        return this.personSympthomp;
    }
    public Map<Integer, IPersonSympthomp> findByListPersonIds(List<Integer> ids) {
        Map<Integer, IPersonSympthomp> map = new HashMap<>();
        Map<Integer, Boolean> idMap = new HashMap<>();
        ids.forEach(integer -> idMap.put(integer, true));

        List<IPersonSympthomp> filteredPersonSympthomp = this.personSympthomp
                .stream()
                .filter(iPersonSympthomp -> idMap.get(iPersonSympthomp.getPersonId()))
                .collect(Collectors.toList());
        filteredPersonSympthomp.forEach(iPersonSympthomp -> map.put(iPersonSympthomp.getId(), iPersonSympthomp));
        return map;
    }
    @Override
    public void add(IPersonSympthomp instance) {
        this.personSympthomp.add(instance);
    }

    @Override
    public IPersonSympthomp findByPK(Integer id) {
        return this.personSympthomp
                .stream().filter(iPersonSympthomp -> iPersonSympthomp.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
