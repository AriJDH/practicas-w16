package com.bootcamp.demo.service;

import com.bootcamp.demo.model.Jewel;

import java.util.List;

public interface IJewelService {
    List<Jewel> getJewels();
    void saveJewel(Jewel jew);
    void deleteJewel(long id);
    Jewel findJewel(long id);
}
