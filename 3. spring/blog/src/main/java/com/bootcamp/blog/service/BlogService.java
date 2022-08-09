package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogPostDTO;
import com.bootcamp.blog.dto.BlogResponseDTO;
import com.bootcamp.blog.exception.BadRequestException;
import com.bootcamp.blog.exception.NotFoundException;
import com.bootcamp.blog.model.BlogPost;
import com.bootcamp.blog.repository.IBlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BlogService implements IBlogService {

    private final IBlogRepository iBlogRepository;
    private final ModelMapper mapper;

    public BlogService(IBlogRepository iBlogRepository) {
        this.iBlogRepository = iBlogRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public BlogResponseDTO newBlogService(BlogPostDTO blogPostDTO) {

        BlogPost blogPost = mapper.map(blogPostDTO, BlogPost.class);
        List<BlogPost>  findBlog =  iBlogRepository.allBlogsRepo().stream().filter(b -> b.getId() == blogPost.getId()).collect(Collectors.toList());

        if(findBlog.size()>0){
            throw new BadRequestException("El id ingresado ya existe!");

        }else{
            boolean isCreated = iBlogRepository.newBlogRepo(blogPost);
            BlogResponseDTO blogResponseDTO = new BlogResponseDTO("Blog creado exitosamente!", blogPost.getId());
            return blogResponseDTO;
        }
    }

    @Override
    public List<BlogPostDTO> allBlogsService() {
        return iBlogRepository.allBlogsRepo().stream().map(blogPost -> mapper.map(blogPost, BlogPostDTO.class)).collect(Collectors.toList());
    }

    @Override
    public BlogPostDTO findBlogService(Integer id) {
        BlogPost blog = iBlogRepository.allBlogsRepo().stream()
                .filter(b -> b.getId() == id).findFirst()
                .orElseThrow(() -> new NotFoundException("El id: " + id + " no existe!"));
        return mapper.map(blog, BlogPostDTO.class);
    }
}
