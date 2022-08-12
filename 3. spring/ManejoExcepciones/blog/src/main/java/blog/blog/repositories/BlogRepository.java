package blog.blog.repositories;

import blog.blog.dtos.EntradaBlogDTO;
import blog.blog.dtos.ResponseApiDTO;
import blog.blog.entities.EntradaBlog;
import blog.blog.exceptions.BlogIlegalId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class BlogRepository implements IBlogRepository {

    List<EntradaBlogDTO> blogs = new ArrayList<>();

    @Override
    public boolean validateBlog(EntradaBlogDTO blog) {

        EntradaBlogDTO entradaBlog  = new EntradaBlogDTO(blog.getId(),
                blog.getTitle(),
                blog.getAuthorName(),
                blog.getPublicationDate()
        );

        Long countBlogs = blogs.stream()
                .filter(b -> b.equals(blog)).count();;

        if (countBlogs>0){
            return false;
        }
        else{
            blogs.add(entradaBlog);
            return true;
        }
    }

    @Override
    public EntradaBlogDTO getBlogById(Integer id) {
        return blogs.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<EntradaBlogDTO> getBlogs() {
        return blogs;
    }
}
