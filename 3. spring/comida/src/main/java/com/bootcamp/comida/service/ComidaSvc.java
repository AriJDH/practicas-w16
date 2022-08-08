package com.bootcamp.comida.service;

import com.bootcamp.comida.entity.Ingrediente;
import com.bootcamp.comida.repository.Repository;
import org.springframework.stereotype.Service;

@Service
public class ComidaSvc {
    public final Repository<Ingrediente> Ingrediente = new Repository<>();


}
