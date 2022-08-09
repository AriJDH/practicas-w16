package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.PostDTO;
import com.example.be_java_hisp_w16_g03.entity.Post;
import com.example.be_java_hisp_w16_g03.entity.Product;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.exception.InvalidPostRequest;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {
    @Autowired
    IUserRepository repository;

    @Override
    public void addPost(PostDTO request) {
        // se valida el request en caso que de false se lanza excepcion
        if (!request.validate())
            throw new InvalidPostRequest();
        // se trae usuario del repo para luego castearlo a User y agregarle el post
        User requestUser = repository.getUserById(request.getUserId());
        if (requestUser != null) {
        // se delega responsabilidad a la entidad para agregar post a usuario
            requestUser.addPostToUser(request);
        } else {
            throw new InvalidPostRequest();
        }

    }


}
