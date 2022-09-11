package com.example.spring.joyeria.service;

import com.example.spring.joyeria.entity.Jewel;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IJewelService {

    public List<Jewel> getJewelry();
    public void saveJewel(Jewel jewel);
    public void deleteJewel(long id);
    public Jewel findJewel(long id);
}
