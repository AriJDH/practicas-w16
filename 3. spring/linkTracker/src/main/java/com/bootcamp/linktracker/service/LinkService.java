package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.InvalidateDTO;
import com.bootcamp.linktracker.dto.LinkDTO;
import com.bootcamp.linktracker.dto.LinkMetricDTO;
import com.bootcamp.linktracker.dto.LinkResponseDTO;
import com.bootcamp.linktracker.exception.BadRequestException;
import com.bootcamp.linktracker.exception.NotFoundException;
import com.bootcamp.linktracker.model.Link;
import com.bootcamp.linktracker.repository.ILinkRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService implements ILinkService {

    private final ILinkRepository iLinkRepository;
    private final ModelMapper mapper;

    public LinkService(ILinkRepository iLinkRepository) {
        this.iLinkRepository = iLinkRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public LinkResponseDTO createLinkService(LinkDTO linkDTO) {

        if (validateUrl(linkDTO.getLink())) {
            Link link = mapper.map(linkDTO, Link.class);
            LinkResponseDTO linkResponse = mapper.map(iLinkRepository.save(link), LinkResponseDTO.class);
            return linkResponse;
        }else {
            throw new BadRequestException("----------- Formato de link incorrecto ----------- \n--> El formato debe ser tipo: \"https://xxxxxxx.xx\"");
        }
    }

    @Override
    public LinkDTO redirectService(Integer id, String password) {
        Optional<Link> link = iLinkRepository.findLinkById(id);
        LinkDTO result = null;
        if(link.isPresent()){
            Link linkVerified = checkLinkAndPassword(password, link.get());
            result = mapper.map(linkVerified, LinkDTO.class);
        }
        return result;
    }

    @Override
    public LinkMetricDTO metricService(Integer id) {
        Optional<Link> link = iLinkRepository.findLinkById(id);
        link.orElseThrow(()-> new NotFoundException("Ingrese un id valido!"));
        return mapper.map(link.get(), LinkMetricDTO.class);
    }

    @Override
    public InvalidateDTO invalidate(Integer linkId) {
        Optional<Link> link = iLinkRepository.findLinkById(linkId);
        link.orElseThrow(()-> new NotFoundException("Ingrese un id valido!"));
        link.ifPresent(iLinkRepository::delete);
        return new InvalidateDTO("Link eliminado exitosamente!", link.get().getLink());
    }

    private Link checkLinkAndPassword(String password, Link link) {
        Link result = null;
        if(link.getPassword() != null && link.getPassword().equals(password)){
            result = link;
            suMetric(link);
        }
        return result;
    }

    private void suMetric(Link link) {
        link.sumCount();
        iLinkRepository.save(link);
    }

    public static boolean validateUrl(String url) {
        UrlValidator urlValidator = new UrlValidator();
        return urlValidator.isValid(url);
    }
}
