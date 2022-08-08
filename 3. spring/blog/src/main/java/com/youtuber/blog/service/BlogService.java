package com.youtuber.blog.service;

import com.youtuber.blog.dto.BlogDto;
import com.youtuber.blog.dto.ResponseApiDto;
import com.youtuber.blog.entity.Blog;
import com.youtuber.blog.exception.BlogDuplicateException;
import com.youtuber.blog.exception.BlogNotFoundException;
import com.youtuber.blog.repository.IBlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService {

    private final IBlogRepository blogRepository;
    private final ModelMapper mapper ;


    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
        mapper =  new ModelMapper();
    }

    @Override
    public ResponseApiDto createBlog(BlogDto blogDto) {

        if (getBlogById(blogDto.getIdBlog()) != null){
            throw new BlogDuplicateException(blogDto.getIdBlog());
        }else {
            Blog blog = new Blog();
            blog = mapper.map(blogDto, Blog.class);
            blogRepository.createBlog(blog);
        }
        return new ResponseApiDto("Blog Creado", "Blog con id: " + blogDto.getIdBlog() + " creado exitosamente");
    }

    @Override
    public BlogDto getBlogById(Integer id) {
        Optional<Blog> blog = blogRepository.getBlogById(id);
        if (blog.isEmpty()){
            return null;
        }

        Blog blogObj = blog.stream().findFirst().orElse(null);
        return mapper.map(blogObj, BlogDto.class);
    }

    @Override
    public List<BlogDto> listBlog() {
        return blogRepository.listBlog().stream().map(blog -> mapper.map(blog, BlogDto.class)).collect(Collectors.toList());
    }
}
