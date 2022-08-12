package blog.blog.repositories;

import blog.blog.dtos.EntradaBlogDTO;

import java.util.List;

public interface IBlogRepository {
    boolean validateBlog(EntradaBlogDTO blog);
    EntradaBlogDTO getBlogById(Integer id);
    List<EntradaBlogDTO> getBlogs();
}
