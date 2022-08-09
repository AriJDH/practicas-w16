package com.example.linkTraker.utils;

import com.example.linkTraker.exception.BadRequestException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;

@Component
public class ServiceUtils {

    public void catchMalformedURLException(MalformedURLException e){

        throw new BadRequestException(e.getMessage());

    }
    public void catchIOException(IOException e){

        throw new BadRequestException(e.getMessage());

    }
}
