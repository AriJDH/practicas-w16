package com.example.hql.service;

import com.example.hql.dto.SiniestroDTO;
import com.example.hql.dto.SiniestroIdDTO;
import com.example.hql.dto.VehiculoDTO;
import com.example.hql.model.Siniestro;
import com.example.hql.model.Vehiculo;
import com.example.hql.repository.RepositorySiniestro;
import com.example.hql.repository.RepositoryVehiculo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ServiceSiniestroImp implements ServiceSiniestro{

    final RepositorySiniestro repositorySiniestro;
    final RepositoryVehiculo repositoryVehiculo;
    ModelMapper modelMapper = new ModelMapper();

    public ServiceSiniestroImp(RepositorySiniestro repositorySiniestro, RepositoryVehiculo repositoryVehiculo) {
        this.repositorySiniestro = repositorySiniestro;
        this.repositoryVehiculo = repositoryVehiculo;
    }

    @Override
    public String add(SiniestroDTO siniestroDTO) {
        Siniestro s = modelMapper.map(siniestroDTO,Siniestro.class);
        s.setVehiculo(repositoryVehiculo.getReferenceById(siniestroDTO.getVehiculo()));
        repositorySiniestro.save(s);
        return "Siniestro agregado";
    }

    @Override
    public SiniestroIdDTO getById(int id) {
        return modelMapper.map(repositorySiniestro.getReferenceById(id), SiniestroIdDTO.class);
    }

    @Override
    public List<SiniestroIdDTO> getAll() {
        List<Siniestro> siniestros = repositorySiniestro.findAll();
        return siniestros.stream()
                .map(siniestro -> modelMapper.map(siniestro, SiniestroIdDTO.class))
                .collect(Collectors.toList());
    }
}
