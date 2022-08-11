package com.example.socialmeli.service;

import com.example.socialmeli.dto.*;
import com.example.socialmeli.exception.UserNotFoundException;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.Product;
import com.example.socialmeli.model.User;
import com.example.socialmeli.repository.IRepository;
import com.example.socialmeli.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class PostService implements IPostService {
    @Autowired
    private IRepository<Post> postRepository;
    @Autowired
    private IUserService userService;
    public void addPost(PostDto newPost) {
        User user = userService.getById(newPost.getUserId());
        if (user == null) {
            throw new UserNotFoundException("El usuario con codigo " + newPost.getUserId() + " no existe.");
        }
        Post post = Mapper.mapperToPost(newPost);
        this.postRepository.add(post);
    }

    public void addPromoPost(PromoPostDto promoPostDto) {
        User user = userService.getById(promoPostDto.getUserId());
        if (user == null) {
            throw new UserNotFoundException("El usuario con codigo " + promoPostDto.getUserId() + " no existe.");
        }
        Post post = Mapper.mapperToPromoPost(promoPostDto);
        this.postRepository.add(post);
    }//US0010

    public PromoPostCountDto getPromoPostCount(Integer userId) {
        User user = userService.getById(userId);
        if (user == null) {
            throw new UserNotFoundException("El usuario con codigo " + userId + " no existe.");
        }
        Long promoPostCount = postRepository.getAll().stream()
                .filter(x -> x.getHasPromo()&&x.getUserId() == userId)
                .count();
        return Mapper.mapperToPromoPostCountDto(user, Math.toIntExact(promoPostCount));

    }//US0011

    public UserListPromoPostDto getListUserPromoPost(Integer userId) {

        User user = userService.getById(userId);
        if (user == null) {
            throw new UserNotFoundException("El usuario con codigo " + userId + " no existe.");
        }
        List<Post> postListPromo=postRepository.getAll().stream()
                .filter(x->x.getHasPromo()&&x.getUserId()==userId)
                .collect(Collectors.toList());

        return Mapper.mapperToUserListPromoPost(user, postListPromo);
    }//US00012

    public PostListLastTwoWeeksDto getFollowedPostListLastTwoWeeks(Integer userId, Optional<String> order) {
        String orderString= order.orElse("");
        User user = userService.getById(userId);

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
    @PostConstruct
    public void initPostData() {
        if (postRepository.getAll().isEmpty()) {
            User user1 = new User(0, "alberto", new ArrayList<User>(), new ArrayList<User>());
            User user2 = new User(0, "juan", new ArrayList<User>(), new ArrayList<User>());
            userService.add(user1);
            userService.add(user2);

            Product product1 = new Product(1, "Silla", "Gamer", "Razer", "Roja", "Cuidado que la silla está rota");
            Product product2 = new Product(2, "Headset", "Gamer", "HyperX", "Rojo", "Super cool");
            Product product3 = new Product(3, "Teclado", "Gamer", "RedDragon", "RGB", "Muy lindo");
            Product product4 = new Product(4, "Mouse", "Gamer", "HyperX", "RGB", "No anda");
            Product product5 = new Product(5, "Monitor", "Gamer", "Samsung", "Negro", "Nuevo");

            Post post1 = new Post(0, user1.getUserId(), product1, LocalDate.now(), 1, 15000.0, false, 0.0);
            Post post2 = new Post(0, user1.getUserId(), product2, LocalDate.of(2022, 8, 5), 10, 3500.0, false, 0.0);
            Post post3 = new Post(0, user1.getUserId(), product3, LocalDate.of(2021, 12, 1), 7, 65000.0, false, 0.0);
            Post post4 = new Post(0, user2.getUserId(), product4, LocalDate.of(2022, 7, 31), 5, 8000.0, true, 0.0);
            Post post5 = new Post(0, user2.getUserId(), product5, LocalDate.of(2022, 1, 1), 2, 5600.0, true, 0.0);
            Post post6 = new Post(0, user1.getUserId(), product5, LocalDate.of(2022, 1, 1), 2, 5600.0, true, 0.0);

            postRepository.add(post1);
            postRepository.add(post2);
            postRepository.add(post3);
            postRepository.add(post4);
            postRepository.add(post5);
            postRepository.add(post6);
        }
    }
}
