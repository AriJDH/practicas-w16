package blog.blog.controllers;

import blog.blog.dtos.EntradaBlogDTO;
import blog.blog.dtos.ResponseApiDTO;
import blog.blog.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BlogController {

    @Autowired
    IBlogService iBlogService;

    @PostMapping("/blog")
    public ResponseEntity<ResponseApiDTO> createBlog (@RequestBody EntradaBlogDTO blog) {
        return new ResponseEntity<>(iBlogService.createBlog(blog), HttpStatus.OK);
    }

    @RequestMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> searchBlogById(@PathVariable Integer id){
        return new ResponseEntity<>(iBlogService.searchBlogById(id), HttpStatus.OK);
    }
    @RequestMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDTO>> listAllBlogs(){
        return new ResponseEntity<>(iBlogService.listAllBlogs(), HttpStatus.OK);
    }
}
