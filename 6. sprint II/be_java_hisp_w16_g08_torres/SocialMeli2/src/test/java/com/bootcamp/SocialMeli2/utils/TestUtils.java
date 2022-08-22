package com.bootcamp.SocialMeli2.utils;

import com.bootcamp.SocialMeli2.dto.request.PostDto;
import com.bootcamp.SocialMeli2.dto.request.ProductDto;
import com.bootcamp.SocialMeli2.entiry.Post;
import com.bootcamp.SocialMeli2.entiry.Product;
import com.bootcamp.SocialMeli2.entiry.User;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static User getOneUser(int id, String name){
        User user = new User(id,name,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        return user;
    }

    public static PostDto getOnePostDto(int id){
        ProductDto productDto =  getOneProductDto(id,"Mouse","gamer","razer","black","");
        return new PostDto(id, LocalDate.now(),productDto,20,1500);
    }

    public static ProductDto getOneProductDto(int productId, String productName, String type, String brand, String color, String notes){
        return  new ProductDto(productId,productName,type,brand,color,notes);
    }

    public static Post getOnePost(int postId,User userPost,LocalDate postDate){
        Product product =  getOneProduct(1,"Mouse","gamer","razer","black","");
        Post post = new Post(1,userPost, postDate,20,1500,product);
        userPost.getPostMade().add(post);
        return  post;
    }

    public static Product getOneProduct(int productId, String productName, String type, String brand, String color, String notes){
        return  new Product(productId,productName,type,brand,color,notes);
    }

    public static User generateVendorWithTwoFollowersAndTwoFollowed(){
        User juan = TestUtils.getOneUser(3,"juan");
        User pepe = TestUtils.getOneUser(2,"pepe");
        User luis = TestUtils.getOneUser(1,"luis");

        Post postJuan1 = TestUtils.getOnePost(1,juan,LocalDate.now());
        Post postJuan2 = TestUtils.getOnePost(2,pepe,LocalDate.now().minusDays(1));
        Post postPepe1 = TestUtils.getOnePost(3,pepe,LocalDate.now().minusDays(2));
        Post postPepe2 = TestUtils.getOnePost(4,pepe,LocalDate.now().minusDays(3));
        Post postPepe3 = TestUtils.getOnePost(5,pepe,LocalDate.now().minusDays(15));
        Post postLuis = TestUtils.getOnePost(6,luis,LocalDate.now());

        luis.getFollowedList().add(pepe);
        luis.getFollowedList().add(juan);

        pepe.getFollowerList().add(luis);
        juan.getFollowerList().add(luis);

        pepe.getFollowedList().add(luis);
        juan.getFollowedList().add(luis);

        luis.getFollowerList().add(pepe);
        luis.getFollowerList().add(juan);

        return luis;
    }

    public static List<User> getFourUsersTwoVendors(){

        List<User> list = new ArrayList<>();
        User user1=getOneUser(3,"Jose");
        List<Post> postUser1=new ArrayList<>();
        postUser1.add(getOnePost(1,user1, LocalDate.of(2022, 8,10)));
        postUser1.add(getOnePost(2,user1,LocalDate.of(2022,7,1)));
        user1.setPostMade(postUser1);
        list.add(user1);
        User user2=getOneUser(4,"Pepe");
        List<Post> postUser2=new ArrayList<>();
        postUser2.add(getOnePost(4,user1, LocalDate.of(2022, 8,14)));
        postUser2.add(getOnePost(5,user1,LocalDate.of(2022,7,4)));
        list.add(user2);
        list.add(getOneUser(5,"Antionio"));
        list.add(getOneUser(6,"Manuel"));

        return list;
    }

}