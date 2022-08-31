package com.joyeria.lasPerlas.service;
import com.joyeria.lasPerlas.model.Joya;

import java.util.List;

public interface IJoyaService {
    public List<Joya> getJoyas();
    public Long saveJoya(Joya joya);
    public void deleteJoya(Long id);
    public Joya findJoyaById(Long id);
    public Joya updateJoya(Long id, String nombre, String material, Double gramos, String particularidad, Boolean posee_piedra);
}
