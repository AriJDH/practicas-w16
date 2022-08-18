package com.bootcamp.be_java_hisp_w16_g10.util;

import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import com.bootcamp.be_java_hisp_w16_g10.entity.Product;

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
}
