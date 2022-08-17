package com.javaw16.blog.services;

import com.javaw16.blog.dtos.request.ReqBlogEntryDTO;
import com.javaw16.blog.dtos.response.ResBlogEntryDTO;

import java.util.List;

public interface IBlogEntryService {

    void postEntry(ReqBlogEntryDTO reqBlogEntryDTO);
    ResBlogEntryDTO getEntryByID(Integer id);

    List<ResBlogEntryDTO> getEntries();
}
