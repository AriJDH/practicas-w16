package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.model.Joya;
import com.example.joyerialasperlas.repository.IJoyaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService {
    private IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository repo) {
        this.joyaRepository = repo;
    }

    @Override
    @Transactional
    public Long create(Joya joya) {
        joya.setVentaONo(true);
        Joya joyaReturned = this.joyaRepository.save(joya);

        return Long.valueOf(joyaReturned.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public Joya findById(Long id) {
        return this.joyaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Joya> getAll() {
        List<Joya> listaDeJoyasRegistradas = this.joyaRepository.findAll().stream()
                .filter(joya -> joya.isVentaONo())
                .collect(Collectors.toList());

        return listaDeJoyasRegistradas;
    }

    @Override
    @Transactional
    public Joya update(Joya joya) {
        return this.joyaRepository.save(joya);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Joya joya = this.joyaRepository.findById(id).orElse(null);

        if (joya != null) {
            joya.setVentaONo(false);
            this.joyaRepository.save(joya);
        }
    }
}
