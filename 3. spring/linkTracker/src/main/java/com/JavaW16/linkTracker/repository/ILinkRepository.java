package com.JavaW16.linkTracker.repository;

import com.JavaW16.linkTracker.dto.ResponseDTO;
import com.JavaW16.linkTracker.entity.Link;

import java.util.List;

public interface ILinkRepository {
    ResponseDTO cargarDatos(Link link);
    Link traerDatos(Integer linkId);
}
