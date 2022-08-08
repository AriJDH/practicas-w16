package com.example.ejerciciodeportistas.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repository<T> {

    private List<T> entity;


    public  List<T> getAll()
    {
        init();
        return this.entity;
    }

    public List<T> where(Predicate<T> where)
    {
        init();
        return this.entity.stream().filter(where).map(x -> x).collect(Collectors.toList());
    }
    public Optional<T> firstOrDefaul(Predicate<T> where){
        init();
        return where(where).stream().findFirst();
    }
    public void add(T object)
    {
        init();
        entity.add(object);
    }
    public void remove(T object)
    {
        init();
        entity.remove(object);
    }
    public boolean any()
    {
        init();
        return entity.size() >0 ?true: false;
    }
    private void init(){
        if(this.entity == null)
            entity = new ArrayList<>();
    }
}
