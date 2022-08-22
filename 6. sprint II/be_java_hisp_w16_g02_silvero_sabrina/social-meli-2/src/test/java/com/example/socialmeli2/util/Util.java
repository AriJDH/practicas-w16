package com.example.socialmeli2.util;

import com.example.socialmeli2.model.Post;
import com.example.socialmeli2.model.Product;
import com.example.socialmeli2.model.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class Util {

    public static User getUser(Integer idUser, String name) {
        return new User(idUser, name, new ArrayList<User>(), new ArrayList<User>());
    }

    public static Post getPost(Integer idPost, Integer idUser, Product product) {
        return new Post(idPost, idUser, product, LocalDate.now(), 1, 15000.0, false, 0.0);
    }

    public static Post getPost(Integer idPost, Integer idUser, Product product, LocalDate localDate) {
        return new Post(idPost, idUser, product, localDate, 1, 15000.0, false, 0.0);
    }

    public static Product getProduct(Integer idProduct, String name) {
        return new Product(idProduct, name, "Generic", "Generic", "Generic", "Generic");
    }
}
