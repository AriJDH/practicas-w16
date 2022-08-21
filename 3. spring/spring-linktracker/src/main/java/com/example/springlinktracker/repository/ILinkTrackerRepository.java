package com.example.springlinktracker.repository;

import com.example.springlinktracker.entity.Link;

public interface ILinkTrackerRepository {
    Integer add(Link link);

    Link getById(Integer id);

    void update(Link link);
}
