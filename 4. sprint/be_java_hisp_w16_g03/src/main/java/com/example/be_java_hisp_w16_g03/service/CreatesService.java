package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.exception.UserExisException;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CreatesService implements ICreateService {
    @Autowired
    IUserRepository repository;
    @Override
    public List<UserDTO> postData(List<UserDTO> userDTOList) {
        for(UserDTO p:userDTOList){
            User valida=repository.getUserById(p.getUserId());
            if (valida!=null){
                throw new UserExisException(p.getUserId());
            }
        }
        List<User> users= userDTOList.stream().map(userDTO -> {
            User user=new User(userDTO.getUserId(),userDTO.getUserName());
            return user;
        }).collect(Collectors.toList());
        List<User> userResponse=repository.postData(users);
        if(userResponse.size()==0){
            return null;
        }
        return userResponse.stream().map(user -> {
            UserDTO userdto=new UserDTO(user.getUserId(),user.getUserName());
            return userdto;
        }).collect(Collectors.toList());
    }
}
