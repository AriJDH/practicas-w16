package com.JavaW16.linkTracker.repository;

import com.JavaW16.linkTracker.dto.ResponseDTO;
import com.JavaW16.linkTracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{
    List<Link> linkList;

    public LinkRepositoryImpl() {
        this.linkList = new ArrayList<>();
    }

    @Override
    public ResponseDTO cargarDatos(Link link) {
        linkList.add(link);
        ResponseDTO response = new ResponseDTO(link.getLinkId(), link.getLinkPassword());
        return response;
    }

    @Override
    public Link traerDatos(Integer linkId) {
        return this.linkList.stream()
                .filter(link -> link.getLinkId().equals(linkId))
                .findFirst().get();
    }
}
