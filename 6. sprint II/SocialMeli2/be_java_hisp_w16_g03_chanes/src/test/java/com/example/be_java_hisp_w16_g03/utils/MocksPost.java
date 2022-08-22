package com.example.be_java_hisp_w16_g03.utils;

import com.example.be_java_hisp_w16_g03.entity.Post;
import com.example.be_java_hisp_w16_g03.entity.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MocksPost {

    public static final String DATE_DESC = "date_desc";
    public static final String DATE_ASC = "date_asc";

    public static List<Post> createPosts() {

        List<Post> list = new ArrayList<>();
        Post post1 = Post.builder().date(LocalDate.now().minusDays(2)).product(new Product()).build();
        Post post2 = Post.builder().date(LocalDate.now().minusDays(3)).product(new Product()).build();
        list.add(post1);
        list.add(post2);

        return list;

    }

}
