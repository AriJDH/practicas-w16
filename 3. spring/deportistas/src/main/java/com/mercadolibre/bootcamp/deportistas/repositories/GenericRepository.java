package com.mercadolibre.bootcamp.deportistas.repositories;

import java.util.ArrayList;
import java.util.List;

public class GenericRepository <T>{

    protected List <T> data = new ArrayList<>();

    public void addNew(T newRecord){
        data.add(newRecord);
    }

    public List<T> getAll(){
        return data;
    }
}
