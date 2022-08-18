package com.bootcamp.SocialMeli2.unitary.util;

import com.bootcamp.SocialMeli2.dto.request.PostDto;
import com.bootcamp.SocialMeli2.dto.request.ProductDto;
import com.bootcamp.SocialMeli2.entiry.Post;
import com.bootcamp.SocialMeli2.entiry.Product;
import com.bootcamp.SocialMeli2.entiry.User;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static User getOneUser(int id, String name){
        User user = new User(id,name,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        return user;
    }

    public static List<User> getFourUsersTwoVendors(){

        List<User> list = new ArrayList<>();
        User user1=getOneUser(3,"Jose");
        List<Post> postUser1=new ArrayList<>();
        postUser1.add(getOnePost(1,user1,30,200, LocalDate.of(2022, 8,10)));
        postUser1.add(getOnePost(2,user1,30,700,LocalDate.of(2022,7,1)));
        user1.setPostMade(postUser1);
        list.add(user1);
        User user2=getOneUser(4,"Pepe");
        List<Post> postUser2=new ArrayList<>();
        postUser2.add(getOnePost(4,user1,30,100, LocalDate.of(2022, 8,14)));
        postUser2.add(getOnePost(5,user1,30,100,LocalDate.of(2022,7,4)));
        list.add(user2);
        list.add(getOneUser(5,"Antionio"));
        list.add(getOneUser(6,"Manuel"));

        return list;
    }
    public static PostDto getOnePostDto(){
        ProductDto productDto =  getOneProductDto(1,"Mouse","gamer","razer","black","");
        return new PostDto(1, LocalDate.now(),productDto,20,1500);

    }   public static Post getOnePost(int postId,User user,int category, double price,LocalDate date){

        Product product =  getOneProduct(1,"Mouse","gamer","razer","black","");
        return new Post(postId,user,date,category,price,product);
    }

    public static ProductDto getOneProductDto(int productId, String productName, String type, String brand, String color, String notes){
        return  new ProductDto(productId,productName,type,brand,color,notes);
    }
    public static Product getOneProduct(int productId, String productName, String type, String brand, String color, String notes){
        return  new Product(productId,productName,type,brand,color,notes);
    }
}
