package com.grodriguez.blog.service;

import com.grodriguez.blog.dto.BlogEntryDTO;
import com.grodriguez.blog.dto.MessageDTO;
import com.grodriguez.blog.entities.BlogEntry;
import com.grodriguez.blog.exception.NotFoundException;
import com.grodriguez.blog.exception.RepeatedException;
import com.grodriguez.blog.repository.BlogEntryRepository;
import com.grodriguez.blog.repository.IBlogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogEntryService implements IBlogEntryService {

    @Autowired
    private IBlogEntryRepository blogEntryRepository;

    @Override
    public MessageDTO createBlogEntry(BlogEntryDTO blogEntry) {

        if(blogEntryRepository.getBlogEntry(blogEntry.getId()) != null) {
            throw new RepeatedException("Ya existe una entrada con el Id: " + blogEntry.getId());
        }

        BlogEntry be = new BlogEntry(blogEntry.getId(), blogEntry.getTitulo(), blogEntry.getNombreAutor(), blogEntry.getFecha());

        return new MessageDTO(blogEntryRepository.createBlogEntry(be));
    }

    @Override
    public BlogEntryDTO getBlogEntry(int id) {

        BlogEntry be = blogEntryRepository.getBlogEntry(id);

        if(be == null){
            throw new NotFoundException("No existe una entrada con el Id: " + id);
        }

        return new BlogEntryDTO(be.getId(), be.getTitulo(), be.getNombreAutor(), be.getFecha());
    }

    @Override
    public List<BlogEntryDTO> getAll() {
        return blogEntryRepository.getAll()
                .stream()
                .map(be -> new BlogEntryDTO(be.getId(), be.getTitulo(), be.getNombreAutor(), be.getFecha()))
                .collect(Collectors.toList());
    }
}
