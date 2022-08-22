package com.example.socialmeli.service;

import com.example.socialmeli.dto.*;
import com.example.socialmeli.exception.UserNotFoundException;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.PostUS10;
import com.example.socialmeli.model.Product;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.IRepository;
import com.example.socialmeli.repository.PostUS10Repository;
import com.example.socialmeli.util.Mapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class PostService implements IPostService {
    @Autowired
    IRepository<Post> postRepository;
    @Autowired
    IRepository<User> userRepository;
    @Autowired
    PostUS10Repository postUS10Repository;


    public void addPost(PostDto newPost) {
        User user = userRepository.getById(newPost.getUserId());
        if (user == null) {
            throw new UserNotFoundException("El usuario con codigo " + newPost.getUserId() + " no existe.");
        }
        Post post = Mapper.mapperToPost(newPost);
        this.postRepository.add(post);
    }

    public void addPromoPost(PostUS10DTO postUS10DTO) {
        User user = userRepository.getById(postUS10DTO.getUserId());
        if (user == null) {
            throw new UserNotFoundException("El usuario con codigo " + postUS10DTO.getUserId() + " no existe.");
        }
        PostUS10 postUS10 = Mapper.mapperToPromoPost(postUS10DTO);
        postUS10Repository.addPromoPost(postUS10);
    }

    public PostListLastTwoWeeksDto getFollowedPostListLastTwoWeeks(Integer userId, Optional<String> order) {
        String orderString= order.orElse("");
        User user = userRepository.getById(userId);

        if (user == null) {
            throw new UserNotFoundException("El usuario con codigo " + userId + " no existe.");
        }

        List<Post> followedPostList = new ArrayList<>();

        List<Post> postList = postRepository.getAll();
        user.getFollowed().stream().forEach(followed -> {
            postList.stream()
                    .filter(post -> post.getUserId() == followed.getUserId())
                    .filter(post -> DAYS.between(post.getDate(), LocalDate.now()) <= 14)
                    .forEach(post -> followedPostList.add(post));
        });

        if (orderString.equals("date_asc"))
            followedPostList.sort(Comparator.comparing(Post::getDate));
        else if (orderString.equals("date_desc"))
            followedPostList.sort(Comparator.comparing(Post::getDate).reversed());

        return Mapper.mapperToPostListLastTwoWeeksDto(userId, followedPostList);
    }

    public List<PostUS10> listarPostsUS10(){
        return new ArrayList<>(postUS10Repository.getAll());
    }

    public ListPostsDTO listarPromoPostsById(Integer userId){
        User user = userRepository.getById(userId);
        if (user == null) {
            throw new UserNotFoundException("El usuario con codigo " + userId + " no existe.");
        }
        List<PostUS10> listaPosts = new ArrayList<>(postUS10Repository.getAll());
        List<PostUS10> listaPostsFiltrados;

        listaPostsFiltrados = listaPosts.stream()
                .filter(value -> Objects.equals(value.getUserId(), userId))
                .filter(PostUS10::isHasPromo)
                .collect(Collectors.toList());

        return Mapper.mapperToListProductsDTO(user, listaPostsFiltrados);
    }

    public CountProductsDTO productCountByUser(Integer userId){
        User user = userRepository.getById(userId);
        if (user == null) {
            throw new UserNotFoundException("El usuario con codigo " + userId + " no existe.");
        }
        List<PostUS10> listaPosts = new ArrayList<>(postUS10Repository.getAll());

        int cantidadProductos = (int) listaPosts.stream()
                .filter(value -> Objects.equals(value.getUserId(), userId))
                .filter(PostUS10::isHasPromo)
                .count();

        return Mapper.mapperToCountProductsDTO(user, cantidadProductos);
    }

    @PostConstruct
    public void initPostData() {
        if (postRepository.getAll().isEmpty()) {
            User user1 = new User(0, "alberto", new ArrayList<User>(), new ArrayList<User>());
            User user2 = new User(0, "juan", new ArrayList<User>(), new ArrayList<User>());
            userRepository.add(user1);
            userRepository.add(user2);

            Product product1 = new Product(1, "Silla", "Gamer", "Razer", "Roja", "Cuidado que la silla está rota");
            Product product2 = new Product(2, "Headset", "Gamer", "HyperX", "Rojo", "Super cool");
            Product product3 = new Product(3, "Teclado", "Gamer", "RedDragon", "RGB", "Muy lindo");
            Product product4 = new Product(4, "Mouse", "Gamer", "HyperX", "RGB", "No anda");
            Product product5 = new Product(5, "Monitor", "Gamer", "Samsung", "Negro", "Nuevo");

            PostUS10 post1 = new PostUS10(0, user1.getUserId(), product1, LocalDate.now(), 1, 15000.0, false, 0.0);
            PostUS10 post2 = new PostUS10(0, user1.getUserId(), product2, LocalDate.of(2022, 8, 5), 10, 3500.0, true, 20.0);
            PostUS10 post3 = new PostUS10(0, user1.getUserId(), product3, LocalDate.of(2021, 12, 1), 7, 65000.0, true, 30.0);
            PostUS10 post4 = new PostUS10(0, user2.getUserId(), product4, LocalDate.of(2022, 7, 31), 5, 8000.0, false, 0.0);
            PostUS10 post5 = new PostUS10(0, user2.getUserId(), product5, LocalDate.of(2022, 1, 1), 2, 5600.0, false, 0.0);

            postUS10Repository.addPromoPost(post1);
            postUS10Repository.addPromoPost(post2);
            postUS10Repository.addPromoPost(post3);
            postUS10Repository.addPromoPost(post4);
            postUS10Repository.addPromoPost(post5);
        }
    }
}
