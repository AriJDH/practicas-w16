package com.bootcamp.linktracer.repository;

import com.bootcamp.linktracer.model.Link;

public interface ILinkRepository {
    Link createLink(Link link);

    Link getLink(int id);
}
