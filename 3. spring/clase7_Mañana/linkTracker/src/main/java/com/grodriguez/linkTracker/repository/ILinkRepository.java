package com.grodriguez.linkTracker.repository;

import com.grodriguez.linkTracker.entities.Link;

public interface ILinkRepository {
    int createLink(String url, String password);
    Link getLink(int id, String password);
    Link getLink(int id);
    void addRedirection(int id);
    boolean invalidateLink(int id);
}
