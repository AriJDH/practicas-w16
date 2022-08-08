package com.bootcamp.linktracer.repository;

import com.bootcamp.linktracer.model.Link;

public interface ILinkRepository {
    boolean createLink(Link link);

    Link getLink(int id);

    boolean putLink(Link link);
}
