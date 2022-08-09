package com.example.blog.service;


import com.example.blog.dtos.request.NuevaEntradaDTO;
import com.example.blog.dtos.response.EntradaDTO;

import java.util.List;

public interface IBlogService {


    EntradaDTO buscarEntrada(Long id);

    List<EntradaDTO> todasLasEntradas();

    EntradaDTO crearEntrada(NuevaEntradaDTO nuevaEntrada);

}
