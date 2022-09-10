package com.bootcamp.blog.utils;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.model.EntradaBlog;

public class Mapper {//convierte de un dto a una entidad
    public static EntradaBlog modelFromBlogDto(BlogDTO blogDTO){
        return new EntradaBlog(blogDTO.getId(),blogDTO.getTitulo(),blogDTO.getAutor(),blogDTO.getFechaPublicacion());
    }

    public static BlogDTO blogDTOFromModel(EntradaBlog entradaBlog){
        return new BlogDTO(entradaBlog.getId(),entradaBlog.getTitulo(),entradaBlog.getAutor(),entradaBlog.getFechaPublicacion());
    }

}
