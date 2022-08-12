package blog.blog.services;

import blog.blog.dtos.EntradaBlogDTO;
import blog.blog.dtos.ResponseApiDTO;

import java.util.List;

public interface IBlogService {
    ResponseApiDTO createBlog(EntradaBlogDTO blog);
    EntradaBlogDTO searchBlogById(Integer id);
    List<EntradaBlogDTO> listAllBlogs();
}
