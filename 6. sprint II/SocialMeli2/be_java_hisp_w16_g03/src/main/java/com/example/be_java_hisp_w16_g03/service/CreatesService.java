package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.exception.UserExistsException;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreatesService implements ICreateService {

    @Autowired
    IUserRepository repository;

    @Override
    public List<UserDTO> postData(List<UserDTO> userDTOList) {
        validateUsersId(userDTOList);

        List<User> users = userDTOList
                .stream()
                .map(userDTO -> new User(userDTO.getUserId(), userDTO.getUserName()))
                .collect(Collectors.toList());
        List<User> userResponse = repository.postData(users);

        return userResponse
                .stream()
                .map(user -> new UserDTO(user.getUserId(), user.getUserName()))
                .collect(Collectors.toList());
    }

    private void validateUsersId(List<UserDTO> userDTOList) {

        for (UserDTO p : userDTOList) {
            Optional<User> validate = repository.getUserById(p.getUserId());

            if (validate.isPresent()) {
                throw new UserExistsException(p.getUserId());
            }
        }
    }
}
