package com.bootcamp.linktracer.model;

public class LinkFactory {

    public Link make(String url, String password) {
        return new Link(0, url, password, 0, true);
    }
}
