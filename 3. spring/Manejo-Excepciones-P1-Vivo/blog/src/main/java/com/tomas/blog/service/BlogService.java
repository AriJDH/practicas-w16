package com.tomas.blog.service;

import com.tomas.blog.dto.BlogCreadoDTO;
import com.tomas.blog.dto.BlogDTO;
import com.tomas.blog.dto.ListaBlogDTO;
import com.tomas.blog.exception.BlogEmptyException;
import com.tomas.blog.exception.BlogFoundException;
import com.tomas.blog.exception.BlogNotFoundException;
import com.tomas.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService{

    @Autowired
    IBlogRepository blogRepository;

    @Override
    public BlogCreadoDTO crearBlog(BlogDTO entradaBlog) {

        boolean respuesta;
        BlogCreadoDTO blogCreadoDTO = new BlogCreadoDTO();

        respuesta = blogRepository.consultarExistenciaBlog(entradaBlog.getId());

        if(respuesta) {

            throw new BlogFoundException(entradaBlog.getId());

        } else {

            int idBlog = blogRepository.guardarEntradaBlog(entradaBlog.getId(), entradaBlog.getTitulo(), entradaBlog.getAutor(), entradaBlog.getFecha());

            blogCreadoDTO.setId_blog(idBlog);
            blogCreadoDTO.setMensaje("El blog ha sido creado");
            return blogCreadoDTO;

        }

    }

    @Override
    public BlogDTO consultarBlog(int id) {


        boolean respuesta;
        respuesta = blogRepository.consultarExistenciaBlog(id);

        if(respuesta) {

            BlogDTO blogDTO = new BlogDTO();
            List<String> informacionBlog;

            informacionBlog = blogRepository.traerInformacion(id);

            blogDTO.setId(Integer.valueOf(informacionBlog.get(0)));
            blogDTO.setTitulo(informacionBlog.get(1));
            blogDTO.setAutor(informacionBlog.get(2));
            blogDTO.setFecha(informacionBlog.get(3));

            return blogDTO;


        } else {

            throw new BlogNotFoundException(id);

        }


    }

    @Override
    public ListaBlogDTO obtenerBlogs() {

        List<BlogDTO> listaBlog = new ArrayList<>();

        blogRepository.obtenerTodosBlogs().forEach((clave, valor)->{
                BlogDTO blogDto = new BlogDTO();
                blogDto.setId(valor.getId());
                blogDto.setTitulo(valor.getTitulo());
                blogDto.setAutor(valor.getAutor());
                blogDto.setFecha(valor.getFecha());
                listaBlog.add(blogDto);
        });

        if(listaBlog.isEmpty()) {
            throw new BlogEmptyException();
        } else {
            ListaBlogDTO listaBlogDTO= new ListaBlogDTO(listaBlog);
            return listaBlogDTO;
        }

    }
}
