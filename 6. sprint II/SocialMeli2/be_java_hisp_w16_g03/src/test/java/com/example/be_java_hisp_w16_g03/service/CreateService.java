package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import com.example.be_java_hisp_w16_g03.utils.Mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateService {
    @Mock
    IUserRepository repository;

    @InjectMocks
    CreatesService service;


    @Test
    public void createUserTest(){

        UserDTO userDTO1=new UserDTO(1,"jorge");
        UserDTO userDTO2=new UserDTO(2,"pedro");
        UserDTO userDTO3=new UserDTO(3,"felipe");
        List<UserDTO> listUserDTO= Arrays.asList(userDTO1,userDTO2,userDTO3);
        List<User> listUser=Mapper.UserDtoToUser(listUserDTO);
        //Preguntar mañana al equipo
        when(repository.postData(Mockito.anyList())).thenReturn(listUser);

        List<UserDTO> responseList=service.postData(listUserDTO);

        Assertions.assertEquals(listUserDTO,responseList);

    }
}
