package com.example.ejblog.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data @NoArgsConstructor
public class BlogDtoException
{
    private String message;
    private String details;
}
