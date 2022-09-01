package com.example.lasperlas.service;

import com.example.lasperlas.model.Joya;
import com.example.lasperlas.repository.IRepositoryJoya;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceJoya implements IServiceJoya{
    private IRepositoryJoya repo;

    public ServiceJoya(IRepositoryJoya repo) {
        this.repo = repo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Joya> getJoya() {
        List<Joya> joyasList = repo.findAll()
                .stream().filter(joya -> joya.isVentaONo())
                .collect(Collectors.toList());
        return joyasList;
    }

    @Override
    @Transactional
    public void saveJoya(Joya jo) {
        repo.save(jo);
    }

    @Override
    @Transactional
    public void deleteJoya(long id) {
        Joya joya = repo.findById(id).orElse(null);
        if (joya != null){
            joya.setVentaONo(false);
            repo.save(joya);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Joya findJoya(long id) {
        Joya jo = repo.findById(id).orElse(null);
        return jo;
    }

}
