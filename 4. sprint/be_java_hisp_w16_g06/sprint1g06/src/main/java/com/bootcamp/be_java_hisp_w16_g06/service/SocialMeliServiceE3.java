package com.bootcamp.be_java_hisp_w16_g06.service;

import com.bootcamp.be_java_hisp_w16_g06.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.RequestPostDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.ResponsePostDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.UserDTO;
import com.bootcamp.be_java_hisp_w16_g06.entity.Follow;
import com.bootcamp.be_java_hisp_w16_g06.entity.Post;
import com.bootcamp.be_java_hisp_w16_g06.entity.Product;
import com.bootcamp.be_java_hisp_w16_g06.entity.User;
import com.bootcamp.be_java_hisp_w16_g06.exceptions.OrdenPostException;
import com.bootcamp.be_java_hisp_w16_g06.repository.PostRepository;
import com.bootcamp.be_java_hisp_w16_g06.repository.UserFollowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialMeliServiceE3 implements ISocialMeliServiceE3 {

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserFollowersRepository userFollowersRepository;
    @Autowired
    ISocialMeliServiceE1 socialMeliServiceE1;

    @Override
    public void createPost(RequestPostDTO requestPostDTO) {
        if (socialMeliServiceE1.findById(requestPostDTO.getUser_id())) {
            List<Post> lstRepository = postRepository.getPosts();
            lstRepository.add(requestDTOToEntity(requestPostDTO));
            postRepository.setPosts(lstRepository);
        }
    }

    @Override
    public ResponsePostDTO getAllPost(int userId) {

        List<Post> post = postRepository.getPosts();
        List<UserDTO> users = listUserDTO(userFollowersRepository.getUsersList().stream().filter(x -> (x.getUserId() == userId)).collect(Collectors.toList()));

        List<Follow> follows = users.get(0).getFollowed();

        List<Post> posts = new ArrayList<>();

        for (int i = 0; i < post.size(); i++) {
            for (int j = 0; j < follows.size(); j++) {
                if (follows.get(j).getId() == post.get(i).getUserId()) {
                    posts.add(post.get(i));
                }
            }
        }

        ResponsePostDTO responsePostDTO = responsePostDTO(posts, userId);

        return responsePostDTO;

    }

    @Override
    public ResponsePostDTO getAllPost(int userId, String Order) {
        ResponsePostDTO dto = getAllPost(userId);
        List<RequestPostDTO> lstPostDto;
        if (Order == null || Order.equalsIgnoreCase("date_asc")) {
            lstPostDto = dto.getPosts().stream().sorted((x, y) -> x.getDate().compareTo(y.getDate())).collect(Collectors.toList());
        } else if (Order.equalsIgnoreCase("date_desc")) {
            lstPostDto = dto.getPosts().stream().sorted((x, y) -> y.getDate().compareTo(x.getDate())).collect(Collectors.toList());
        } else
            throw new OrdenPostException("No se pudo ordenar la lista");

        dto.setPosts(lstPostDto);
        return dto;
    }

    private Post requestDTOToEntity(RequestPostDTO dto) {
        Product product = new Product(dto.getProduct().getProduct_id(), dto.getProduct().getProduct_name(), dto.getProduct().getType(), dto.getProduct().getBrand(), dto.getProduct().getColor(), dto.getProduct().getNotes());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dto.getDate(), formatter);

        return new Post(product, dto.getUser_id(), postRepository.getCorrelativo(), localDate, dto.getCategory(), dto.getPrice(), false, 0d);
    }

    private List<UserDTO> listUserDTO(List<User> Users) {

        return Users.stream().map(user -> {
            UserDTO userDto = new UserDTO();
            userDto.setUserId(user.getUserId());
            userDto.setUserName(user.getUserName());
            userDto.setFollowers(user.getFollowers());
            userDto.setFollowed(user.getFollowed());
            return userDto;
        }).collect(Collectors.toList());

    }

    private ResponsePostDTO responsePostDTO(List<Post> posts, int userId) {

        ResponsePostDTO responsePostDTO = new ResponsePostDTO();
        List<RequestPostDTO> requestPostDTOS = new ArrayList<>();

        responsePostDTO.setUserId(userId);
        for (Post post : posts) {

            RequestPostDTO requestPostDTO = new RequestPostDTO();
            ProductDTO productDTO = new ProductDTO();

            requestPostDTO.setCategory(post.getCategory());
            requestPostDTO.setDate(post.getDate().toString());
            requestPostDTO.setPrice(post.getPrice());
            requestPostDTO.setUser_id(post.getUserId());

            productDTO.setProduct_id(post.getProduct().getProductId());
            productDTO.setProduct_name(post.getProduct().getProductName());
            productDTO.setBrand(post.getProduct().getBrand());
            productDTO.setColor(post.getProduct().getColor());
            productDTO.setNotes(post.getProduct().getProductName());
            productDTO.setType(post.getProduct().getType());

            requestPostDTO.setProduct(productDTO);

            requestPostDTOS.add(requestPostDTO);

        }

        responsePostDTO.setPosts(requestPostDTOS);

        return responsePostDTO;


    }
}
