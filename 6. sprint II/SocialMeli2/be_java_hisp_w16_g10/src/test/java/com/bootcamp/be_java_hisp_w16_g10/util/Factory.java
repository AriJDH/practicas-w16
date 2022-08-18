package com.bootcamp.be_java_hisp_w16_g10.util;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.ProductReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import com.bootcamp.be_java_hisp_w16_g10.entity.Product;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factory {
    static public Post generatePost() {
        return Factory.generatePost(1, 1, Factory.generateProduct(), LocalDate.now(), 1000D, 1);
    }

    static public List<Post> generateListOfPosts(Integer amount, Integer userId) {
        List<Post> posts = new ArrayList<>();
        for (Integer i = 1; i <= amount; i++) {
            String indexString = Integer.toString(i);
            posts.add(
                    Factory.generatePost(
                            i,
                            userId,
                            Factory.generateProduct(
                                i,
                                "name ".concat(indexString),
                                "type ".concat(indexString),
                                "brand ".concat(indexString),
                                "color ".concat(indexString),
                                "notes ".concat(indexString)
                            ),
                            LocalDate.now(),
                            i + 100D,
                            i
                    )
            );
        }
        return posts;
    }

    static public Post generatePost(Integer id, Integer userId, Product product, LocalDate date, Double price, Integer category) {
        return Post
                .builder()
                .id(id)
                .userId(userId)
                .product(product)
                .date(date)
                .price(price)
                .category(category)
                .build();
    }

    static public Product generateProduct(Integer id, String name, String type, String brand, String color, String notes) {
        return Product
                .builder()
                .id(id)
                .name(name)
                .type(type)
                .brand(brand)
                .color(color)
                .notes(notes)
                .build();
    }

    static public Product generateProduct() {
        return Factory
                .generateProduct(1, "Mati", "Programdor", "Bootcamper", "Amarillo", "a");
    }

    static public User generateUser(Integer id, String userName, List<User> followers, List<User> followed) {
        return User.builder()
                .id(id)
                .userName(userName)
                .followers(followers)
                .followed(followed)
                .build();
    }

    static public List<User> generateUserList (Integer amount, Integer firstId) {
        List<User> users = new ArrayList<>();
        for (Integer i = 0; i < amount; i++) {
            String indexString = Integer.toString(i);
            users.add(Factory.generateUser(firstId+i,
                            "User ".concat(indexString),
                            null, null));
        }
        return users;
    }


    static public PostReqDTO generateProductReqDTO() {
        ProductReqDTO productReqDTO = new ProductReqDTO(1, "Mac", "Compu", "Apple", "Gris","nada");
        PostReqDTO postReqDTO = new PostReqDTO(1,1, LocalDate.now(),productReqDTO,10,1500.0);
        return postReqDTO;
    }
    
}

