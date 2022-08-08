package com.bootcamp.linktracker.util;

public class LinkValidation {
    public static boolean validarUrl(String url)
    {
        return url.matches("(http[s]?:\\/\\/)?([^\\/\\s]+\\/)(.*)");
    }
}

