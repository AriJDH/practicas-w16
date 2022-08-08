package com.mercadolibre.bootcamp.repositories;

import com.mercadolibre.bootcamp.models.Link;

public interface ILinkRepository {

    public int addLink(Link newLink);
    public Link getLinkById(int id);
    public void updateLink(Link link);

    void updateIsActive(Link link);
}
