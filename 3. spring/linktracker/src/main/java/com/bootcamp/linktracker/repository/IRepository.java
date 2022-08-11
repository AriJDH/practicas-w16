package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.entity.Link;

import java.util.List;

public interface IRepository {
    Link findById(Long id);
    List<Link> findAll();
    Link save(Link model);
    Link findByUrl(String url);
    Link findByIdAndPassword(Long id, String password);

    void update(Long id, Link link);

    void delete(Long id);
}
