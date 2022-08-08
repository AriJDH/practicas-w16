package com.bootcamp.linktracer.model;

public class LinkFactory {
    private int counter = 0;

    public Link make(String url, String password) {
        return new Link(++counter, url, password, 0, true);
    }
}
