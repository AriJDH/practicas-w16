package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.EntradaBlogDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBlogService {
  ResponseEntity<List<EntradaBlogDTO>> getAllSports();
  ResponseEntity<EntradaBlogDTO> getBlog(Integer id);
}
