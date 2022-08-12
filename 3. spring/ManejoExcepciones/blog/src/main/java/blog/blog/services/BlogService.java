package blog.blog.services;

import blog.blog.dtos.EntradaBlogDTO;
import blog.blog.dtos.ResponseApiDTO;
import blog.blog.exceptions.BlogIlegalId;
import blog.blog.exceptions.BlogNotFoundException;
import blog.blog.repositories.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{

    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public ResponseApiDTO createBlog(EntradaBlogDTO blog){
        boolean validate = iBlogRepository.validateBlog(blog);

        if (!validate){
            throw new BlogIlegalId("Blog entry already exists with id: "+blog.getId());
        }
        else {
            ResponseApiDTO responseApiDTO = new ResponseApiDTO("Successfully","Blog entry was created");
            return responseApiDTO;
        }
    }

    @Override
    public EntradaBlogDTO searchBlogById(Integer id){
        EntradaBlogDTO blog = iBlogRepository.getBlogById(id);

        if(blog == null){
            throw new BlogNotFoundException("Blog Not Found with Id: " + id);
        }

        EntradaBlogDTO entradaBlogDTO = new EntradaBlogDTO();
        entradaBlogDTO.setId(blog.getId());
        entradaBlogDTO.setTitle(blog.getTitle());
        entradaBlogDTO.setAuthorName(blog.getAuthorName());
        entradaBlogDTO.setPublicationDate(blog.getPublicationDate());

        return entradaBlogDTO;
    }

    @Override
    public List<EntradaBlogDTO> listAllBlogs(){
        List<EntradaBlogDTO> blogs = iBlogRepository.getBlogs();

        if (blogs.size() == 0){
            throw new BlogNotFoundException("There are not blogs to display");
        }
        return blogs;
    }
}
