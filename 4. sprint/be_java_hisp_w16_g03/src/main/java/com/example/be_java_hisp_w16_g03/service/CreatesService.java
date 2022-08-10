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

        List<User> users = userDTOList.stream().map(userDTO -> {
            return new User(userDTO.getUserId(), userDTO.getUserName());
        }).collect(Collectors.toList());
        List<User> userResponse = repository.postData(users);
        if (userResponse.size() == 0) {
            return new ArrayList<>();
        }
        return userResponse.stream().map(user -> {
            UserDTO userdto = new UserDTO(user.getUserId(), user.getUserName());
            return userdto;
        }).collect(Collectors.toList());
    }

    private void validateUsersId(List<UserDTO> userDTOList) {

        for (UserDTO p : userDTOList) {
            Optional<User> validate = repository.getUserById(p.getUserId());

            if (!validate.isEmpty()) {
                throw new UserExistsException(p.getUserId());
            }
        }
    }
}
