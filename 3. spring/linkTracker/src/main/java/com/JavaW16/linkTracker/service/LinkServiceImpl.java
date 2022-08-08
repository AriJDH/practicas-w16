package com.JavaW16.linkTracker.service;

import com.JavaW16.linkTracker.dto.LinkDTO;
import com.JavaW16.linkTracker.dto.ResponseDTO;
import com.JavaW16.linkTracker.dto.StatisticsDTO;
import com.JavaW16.linkTracker.entity.Link;
import com.JavaW16.linkTracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements ILinkService{
    @Autowired
    ILinkRepository linkRepository;

    @Override
    public ResponseDTO cargarDatos(LinkDTO linkDTO) {
        Link link = new Link(linkDTO.getLinkId(), linkDTO.getLinkURL(), linkDTO.getLinkPassword(), 0, true);
        ResponseDTO response = linkRepository.cargarDatos(link);
        return response;
    }

    @Override
    public String redirect(Integer linkId, String linkPassword) {
        Link aux = linkRepository.traerDatos(linkId);
        if (aux.getLinkPassword().equals(linkPassword) && aux.getIsValid()) {
            // Se suma el redireccionamiento
            aux.setRedirectCounter(aux.getRedirectCounter()+1);
            return aux.getLinkURL();
        }        return null;
    }

    @Override
    public StatisticsDTO traerStatistic(Integer linkId) {
        Link aux = linkRepository.traerDatos(linkId);
        StatisticsDTO stats = new StatisticsDTO(aux.getRedirectCounter());
        return stats;
    }

    @Override
    public LinkDTO invalidarLink(Integer linkId) {
        Link aux = linkRepository.traerDatos(linkId);
        aux.setIsValid(false);
        LinkDTO response = new LinkDTO(aux.getLinkId(), aux.getLinkURL(), aux.getLinkPassword());
        return response;
    }
}
