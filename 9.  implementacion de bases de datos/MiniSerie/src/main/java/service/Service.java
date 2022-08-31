package service;

import entity.MiniSerie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import repository.IMiniserieRepository;

import java.util.List;

public class Service implements  Iservice{

    @Autowired
    private IMiniserieRepository repo;

    @Override
    public List<MiniSerie> getMiniseries() {
       return repo.findAll();
    }

    @Override
    @Transactional
    public void saveMiniSerie(MiniSerie miniSerie) {
        repo.save(miniSerie);

    }

    @Override
    @Transactional
    public void deleteMiniSerie(long id) {
       repo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public MiniSerie findMiniserie(long id) {
        MiniSerie serie = repo.findById(id).orElse(null);
        return serie;
    }
}
