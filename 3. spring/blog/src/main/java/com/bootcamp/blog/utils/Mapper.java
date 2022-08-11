package com.bootcamp.blog.utils;

import com.bootcamp.blog.dto.EntradaBlogDTO;
import com.bootcamp.blog.model.EntradaBlog;

public class Mapper {

  public static EntradaBlogDTO DTOfromEntradaBlog(EntradaBlog entradaBlog) {
    return new EntradaBlogDTO(entradaBlog.getId(), entradaBlog.getTitulo(), entradaBlog.getAutor(), entradaBlog.getFechaPublicacion());
  }
}
