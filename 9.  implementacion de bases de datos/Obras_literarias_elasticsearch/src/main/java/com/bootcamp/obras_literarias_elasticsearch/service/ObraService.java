package com.bootcamp.obras_literarias_elasticsearch.service;

import com.bootcamp.obras_literarias_elasticsearch.dto.ObraDto;
import com.bootcamp.obras_literarias_elasticsearch.model.Obra;
import com.bootcamp.obras_literarias_elasticsearch.repository.IObraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObraService implements IObraService{

    private final IObraRepository iObraRepository;
    private final ModelMapper mapper;

    public ObraService(IObraRepository iObraRepository) {
        this.iObraRepository = iObraRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public ObraDto createObra(ObraDto obraDto) {
        Obra obra = mapper.map(obraDto, Obra.class);
        Obra obra1 = iObraRepository.save(obra);
        return mapper.map(obra1, ObraDto.class);
    }

    @Override
    public List<ObraDto> getObrasByAuthor(String autor) {
        List<Obra> obras = iObraRepository.findByAutor(autor);
        return obras.stream().map(obra -> mapper.map(obra, ObraDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObraDto> findByNombreObra(String nombreObra) {
        List<Obra> obras = iObraRepository.findByNombreObra(nombreObra);
        return obras.stream().map(obra -> mapper.map(obra, ObraDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObraDto> getByCantidadPaginas(Integer cantidadPaginas) {
        List<Obra> obras = iObraRepository.findByCantidadPaginasGreaterThan(cantidadPaginas);
        return obras.stream().map(obra -> mapper.map(obra, ObraDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObraDto> getByAnioPublicacionGreaterThan(Integer anioPrimeraPublicacion) {
        List<Obra> obras = iObraRepository.findByAnioPrimeraPublicacionGreaterThan(anioPrimeraPublicacion);
        return obras.stream().map(obra -> mapper.map(obra, ObraDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObraDto> getByAnioPublicacionLessThan(Integer anioPrimeraPublicacion) {
        List<Obra> obras = iObraRepository.findByAnioPrimeraPublicacionLessThan(anioPrimeraPublicacion);
        return obras.stream().map(obra -> mapper.map(obra, ObraDto.class)).collect(Collectors.toList());
    }
}
