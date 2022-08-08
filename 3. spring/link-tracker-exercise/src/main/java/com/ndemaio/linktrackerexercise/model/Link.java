package com.ndemaio.linktrackerexercise.model;

import lombok.Getter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

@Getter
public class Link {

    private UUID id;
    private String url;
    private String password;
    public Boolean isValid;
    public Integer timesRedirected;

    public Link(String url, String password) throws MalformedURLException {
        validateUrl(url);
        id = UUID.randomUUID();
        this.url = url;
        this.password = password;
        isValid = true;
        timesRedirected = 0;
    }

    private void validateUrl(String anUrl) throws MalformedURLException {
        try {
            new URL(anUrl);
        } catch (MalformedURLException exception) {
            throw exception;
        }
    }

    public void invalidate() {
        if (isValid) {
            isValid = false;
        }
    }

    public void incrementTimesRedirected() {
        timesRedirected++;
    }
}
