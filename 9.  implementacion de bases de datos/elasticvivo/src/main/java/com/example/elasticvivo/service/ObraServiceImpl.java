package com.example.elasticvivo.service;

import com.example.elasticvivo.model.Obra;
import com.example.elasticvivo.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraServiceImpl implements ObraService{

    @Autowired
    ObraRepository obraRep;
    @Override
    public Obra createObra(Obra obra) {
        return obraRep.save(obra);
    }

    @Override
    public List<Obra> getObrasAutor(String autor) {
        return obraRep.findAllByAutor(autor);
    }

    @Override
    public List<Obra> getObrasTitulo(String titulo) {
        return obraRep.findAllByNombreObraContaining(titulo);
    }

    @Override
    public List<Obra> getObrasCantPaginas(Integer paginas) {
        return obraRep.findAllByCantPaginasGreaterThan(paginas);
    }

    @Override
    public List<Obra> getObrasPosterior(Integer anho) {
        return obraRep.findAllByAnhoPublicacionGreaterThan(anho);
    }

    @Override
    public List<Obra> getObrasAnterior(Integer anho) {
        return obraRep.findAllByAnhoPublicacionLessThan(anho);
    }

    @Override
    public List<Obra> getObrasEditorial(String editorial) {
        return obraRep.findAllByEditorial(editorial);
    }
}
