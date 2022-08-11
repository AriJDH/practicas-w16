package com.example.be_java_hisp_w16_g09.utility;

import com.example.be_java_hisp_w16_g09.model.Post;
import com.example.be_java_hisp_w16_g09.model.Product;
import com.example.be_java_hisp_w16_g09.model.User;
import com.example.be_java_hisp_w16_g09.repository.IPostRepository;
import com.example.be_java_hisp_w16_g09.repository.IUserRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class DataLoader {

    static User userA = new User(1, "Ricardo", new ArrayList<>(), new ArrayList<>());
    static User userB = new User(2, "Nicolas", new ArrayList<>(), new ArrayList<>());
    static User userC = new User(3, "Juan", new ArrayList<>(), new ArrayList<>());
    static User userD = new User(4, "Pedro", new ArrayList<>(), new ArrayList<>());

    public static void loadProducts(IPostRepository repo) {
        Product productA = new Product(1, "Silla Gamer", "Silla", "Corsair", "Negro", "");
        Product productB = new Product(2, "Heladera", "Electrodomestico", "Samsung", "Plateado", "");
        Product productC = new Product(3, "Escritorio", "Mueble", "A2", "Madera", "");
        Product productD = new Product(4, "Cafetera", "Electrodomestico", "Oster", "Negro", "");


        Post post1 = new Post(1, userB, LocalDate.of(2022, 8, 10), productA, 2, 20000,true,0.25);
        Post post2 = new Post(2, userB, LocalDate.of(2022, 8, 9), productB, 2, 20000,false,0);
        Post post3 = new Post(3, userB, LocalDate.of(2022, 2, 2), productC, 2, 20000,true,0.10);
        Post post4 = new Post(4, userB, LocalDate.of(2022, 3, 16), productD, 2, 20000,false,0);
        Post post5 = new Post(5, userD, LocalDate.now(), productB, 2, 20000,true,0.5);
        Post post6 = new Post(6, userD, LocalDate.now(), productD, 2, 20000,false,0);

        repo.createElement(post1);
        repo.createElement(post2);
        repo.createElement(post3);
        repo.createElement(post4);
        repo.createElement(post5);
        repo.createElement(post6);

    }

    public static void loadUsers(IUserRepository repo) {
        userA.addFollowed(userB);
        userB.addFollower(userA);
        userC.addFollowed(userB);
        userB.addFollower(userC);
        userC.addFollowed(userD);
        userD.addFollower(userC);

        repo.createElement(userA);
        repo.createElement(userB);
        repo.createElement(userC);
        repo.createElement(userD);

    }
}
