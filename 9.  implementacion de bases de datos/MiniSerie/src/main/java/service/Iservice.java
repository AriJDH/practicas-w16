package service;

import entity.MiniSerie;

import java.util.List;

public interface Iservice
{

    public List<MiniSerie> getMiniseries();
    public void saveMiniSerie(MiniSerie miniSerie);
    public void deleteMiniSerie(long id);
    public MiniSerie findMiniserie(long ind);
}
