package com.bootcamp.practico.service;

import com.bootcamp.practico.dto.BlogDto;
import com.bootcamp.practico.dto.ResponseMessageDto;

public interface BlogAction {

    public ResponseMessageDto addBlog(BlogDto blog);

    public BlogDto getBlogById(int id);
}
