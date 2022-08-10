package com.bootcamp.be_java_hisp_w16_g7.service;
import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersSellersDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.exception.InvalidQueryException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g7.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7.repository.IUserRepository;
import org.modelmapper.ModelMapper;

import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    private final IUserRepository userRepository;
    private final ModelMapper mapper;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        mapper = new ModelMapper();
    }


    @Override
    public ResponseUserFollowedDTO getUserFollowedList(int id, String order) {
        User user = userRepository.findUserById(id);
        if(user == null)
            throw new UserNotFoundException(id);
        Comparator<ResponseUserDTO> userComp = Comparator.comparing(ResponseUserDTO::getUserName);
        if("name_desc".equals(order))
            userComp = userComp.reversed();
        List<ResponseUserDTO> followed = user.getFollows().stream()
                .map(u -> mapper.map(u, ResponseUserDTO.class))
                .sorted(userComp)
                .collect(Collectors.toList());
        return new ResponseUserFollowedDTO(user.getId(), user.getName(), followed);
    }

    @Override
    public FollowersSellersDTO getSellersFollowers(int id, String order) {
        User response = userRepository.findUserById(id);
        if (response == null) {
            throw new UserNotFoundException(id);
        }
        //Verifica si la query es correcta
        if(order != null && !order.equals("name_asc") && !order.equals("name_desc")){
            throw new InvalidQueryException("unknown query");
        }
        Comparator<FollowersDTO> comparator = Comparator.comparing(FollowersDTO::getName);
        if("name_desc".equals(order)){
            comparator = comparator.reversed();
        }
        //Falta verificar si es vendedor.
        if(response.getPosts().size() > 0){
            //Falta verificar si es vendedor.
            List<FollowersDTO> followersToDTO = new ArrayList<>();
            response.getFollowers().forEach(u -> followersToDTO.add(new FollowersDTO(u.getId(), u.getName())));
            followersToDTO.sort(comparator);
            return new FollowersSellersDTO(response.getId(), response.getName(), followersToDTO);
        }

        return null;

    }
}
