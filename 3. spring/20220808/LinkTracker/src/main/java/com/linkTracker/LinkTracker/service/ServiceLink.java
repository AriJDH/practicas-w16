package com.linkTracker.LinkTracker.service;

import com.linkTracker.LinkTracker.dto.LinkResponseDTO;
import com.linkTracker.LinkTracker.dto.LinkResponseDataDTO;
import com.linkTracker.LinkTracker.model.Link;
import com.linkTracker.LinkTracker.repository.IRepositoryLink;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLink implements IServiceLink {
    IRepositoryLink repo;

    public ServiceLink (IRepositoryLink linkRepository){
        this.repo = linkRepository;
    }

    @Override
    public LinkResponseDTO addLink(String x) {
        Link nuevo = new Link(x,0);
        repo.addLink(nuevo);
        return new LinkResponseDTO("Se creo el objeto");
    }

    @Override
    public LinkResponseDataDTO findLink(int id) {
        return null;
    }

    @Override
    public List<LinkResponseDataDTO> findAll() {
        List<LinkResponseDataDTO> lista = new ArrayList<>();
        repo.findAll().forEach((e,n) -> lista.add(new LinkResponseDataDTO(e, n.getUrl(), n.getContador())));
        return lista;
    }
}
