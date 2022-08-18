package com.example.covid19.repository;

import com.example.covid19.entity.IPersonSympthomp;
import com.example.covid19.entity.ISympthomp;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SympthompRepository implements ISympthompRepository {
    private  List<ISympthomp> sympthomps = new ArrayList<>();
    @Override
    public List<ISympthomp> findAll() {
        return this.sympthomps;
    }

    @Override
    public void add(ISympthomp instance) {
        this.sympthomps.add(instance);
    }

    @Override
    public ISympthomp findByPK(Integer code) {
        return this.sympthomps
                .stream().filter(sympthomp -> sympthomp.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    @Override
    public ISympthomp findByName(String name) {
        return this.sympthomps
                .stream().filter(sympthomp -> sympthomp.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
