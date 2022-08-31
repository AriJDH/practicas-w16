package com.example.joyerialp.service;

import com.example.joyerialp.model.Jewerly;
import com.example.joyerialp.repository.JewerlyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class JewerlyService implements IJewerlyService {

    private final JewerlyRepository jewerlyRepository;

    public JewerlyService(JewerlyRepository jewerlyRepo) {
        this.jewerlyRepository = jewerlyRepo;
    }

    @Override @Transactional
    public Jewerly findJewerly(Long id) {
        var res = jewerlyRepository.findById(id).orElse(null);
        return res;
    }

    @Override @Transactional
    public void saveJewerly(Jewerly jewerly) {
        jewerlyRepository.save(jewerly);
    }

    @Override @Transactional
    public void delete2Jewerly(Long id) {
        jewerlyRepository.deleteById(id);
    }

    @Override @Transactional
    public Jewerly deleteJewerly(Long id) {

       var res = jewerlyRepository.findById(id).orElse(null);
       res.setVentaONo(false);
       jewerlyRepository.save(res);
       return res;
    }

    @Override @Transactional
    public List<Jewerly> getJewerlys() {
        var res2 = jewerlyRepository.findAll();
        var res = res2.stream().filter(x -> x.isVentaONo()).collect(java.util.stream.Collectors.toList());
        return res;
    }

    @Override
    public Jewerly updateJewerly(Long id, Jewerly jewerly) {
        var res = jewerlyRepository.findById(id).orElse(null);
        if(res==null) return null;

        res.setMaterial(jewerly.getMaterial());
        res.setPeso(jewerly.getPeso());
        res.setNombre(jewerly.getNombre());
        res.setParticularidad(jewerly.getParticularidad());;
        res.setPosee_piedra(jewerly.isPosee_piedra());
        res.setVentaONo(jewerly.isVentaONo());

        jewerlyRepository.save(res);

        return res;
    }
}
