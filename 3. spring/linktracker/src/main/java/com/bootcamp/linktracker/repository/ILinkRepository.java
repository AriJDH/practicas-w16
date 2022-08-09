package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.model.Link;

import java.util.Optional;

public interface ILinkRepository {

    Link save(Link link);

    Optional<Link> findLinkById(Integer id);

    void delete(Link link);
}
