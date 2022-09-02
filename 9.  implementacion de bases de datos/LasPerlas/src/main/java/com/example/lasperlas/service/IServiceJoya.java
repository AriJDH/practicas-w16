package com.example.lasperlas.service;

import com.example.lasperlas.model.Joya;

import java.util.List;

public interface IServiceJoya {
    List<Joya> getJoya();
    void saveJoya(Joya jo);
    void deleteJoya(long id);
    Joya findJoya(long id);
}
