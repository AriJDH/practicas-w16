package com.linkedin.api.repositories;

import com.linkedin.api.dtos.LinkDTO;
import com.linkedin.api.dtos.MetricDTO;
import com.linkedin.api.entities.Link;
import com.linkedin.api.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class LinkRepositoryImpl implements LinkRepository{

    private List<Link> links;

    public LinkRepositoryImpl() {
        this.links = new ArrayList<>();
    }

    @Override
    public LinkDTO saveLink(Link link) {
        this.links.add(link);
        return new LinkDTO(link.getId(), link.getUrl(),0);
    }

    @Override
    public LinkDTO getLink(Long id) throws NotFoundException {

        Link linkOb = this.links.stream().filter(link-> link.getId()==id).findFirst().orElse(null);

        if(linkOb==null) throw new NotFoundException("Url no encontrada");
        this.links.stream().forEach(link -> {
            if(link.getId()==id && link.isValid()){
                link.setCount(link.getCount()+1);
            }
            });
        Link linkOut = this.links.stream().filter(link-> link.getId()==id).findFirst().orElse(null);
        return new LinkDTO(linkOut.getId(), linkOut.getUrl(),linkOut.getCount());
    }

    @Override
    public List<LinkDTO> getLinks() {
        return this.links.stream().map(link -> new LinkDTO(link.getId(), link.getUrl(), link.getCount())).collect(Collectors.toList());

    }

    @Override
    public MetricDTO getMetric(Long id) {
        Link linkOut = this.links.stream().filter(link-> link.getId()==id).findFirst().orElse(null);

        return new MetricDTO(linkOut.getCount());
    }

    @Override
    public LinkDTO invalidLink(Long id) throws NotFoundException {
        Link linkOut = this.links.stream().filter(link-> link.getId()==id).findFirst().orElse(null);
        if(linkOut==null) throw new NotFoundException("Link no encontrado");
        this.links.stream().forEach(link -> {
            if(link.getId()==id){
                link.setValid(false);

            }
        });
        return new LinkDTO(linkOut.getId(),linkOut.getUrl(),linkOut.getCount());
    }


}
