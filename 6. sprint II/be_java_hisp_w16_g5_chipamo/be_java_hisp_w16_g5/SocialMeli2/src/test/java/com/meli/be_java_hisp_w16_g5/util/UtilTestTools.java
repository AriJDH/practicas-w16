package com.meli.be_java_hisp_w16_g5.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.be_java_hisp_w16_g5.dto.FollowedDto;
import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.dto.UserFollowedDto;
import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.entity.Product;
import com.meli.be_java_hisp_w16_g5.entity.User;


public class UtilTestTools {

    private static final double MAX_PRICE = 100000.0;
    
    private static class Pair{
        private String name;
        private Integer id;
        
        public Pair(String name, Integer id) {
            this.name = name;
            this.id = id;
        }
        
        public String getName() {
            return name;
        }
        
        public Integer getId() {
            return id;
        }
    }

    public static User createUser(String name, Integer id) {
        User user = new User();
        user.setUserId(id);
        user.setUserName(name);
        user.setFollowing(new ArrayList<>());
        user.setFollowers(new ArrayList<>());
        user.setPosts(new ArrayList<>());
        return user;
    }

    public static User createCompletedUser(String name, Integer id){

        List<User> userFollowers = UtilTestTools.getListUsers(
                new Pair("Johannes", 2),
                new Pair("Simon", 5)
                );
        
        List<User> following = UtilTestTools.getListUsers(
            new Pair("Sebastian", 3),
            new Pair("Simon", 5),
                new Pair("Alberto", 9)
        );

        List<Post> post = new ArrayList<>();

        return new User(id, name,post,userFollowers,following);
    }

    private static List<User> getListUsers(Pair ...users) {
        List<User> createdUsers = new ArrayList<>();

        for(Pair u: users) createdUsers.add(createUser(u.getName(), u.getId()));

        return createdUsers;
    }

    public static UserFollowedDto getFollowedUser(String name, Integer id){
        return new UserFollowedDto(
            id,
            name,
            getListFollowedUsers(
                new Pair("Karen", 2),
                new Pair("Francisco", 4)
            )
        );
    }

    private static List<FollowedDto> getListFollowedUsers(Pair ...users){
        List<FollowedDto> followed = new ArrayList<>();

        for(Pair u: users) followed.add(new FollowedDto(u.getId(), u.getName()));

        return followed;
    }

    public static List<Post> getListProductsForUser(User u, Integer numberOfPosts){
        List<Post> posts = new ArrayList<>();

        for(Integer i = 0; i < numberOfPosts; i++){
            posts.add(new Post(
                 u.getUserId(),
                i,
                getRandomDateWithDaysAgo(
                    (int) (Math.random() * 30)
                ),
                getProduct(i),
                i,
                randomBetween(1.0, MAX_PRICE),
                (int)(randomBetween(0.0, 1.0)) == 1,
                randomBetween(0.0, 100) / 100.0

            ));
        }

        return posts;
    }

    public static List<Post> getListProductsForUserByDays(User u, Integer ...days){
        List<Post> posts = new ArrayList<>();

        for(Integer i = 0; i < days.length; i++){
            posts.add(new Post(
                 u.getUserId(),
                i,
                getRandomDateWithDaysAgo(
                    days[i]
                ),
                getProduct(i),
                i,
                MAX_PRICE * (100 - days[i]) / 100.0,
                i % 2 == 0,
                (100 - days[i]) / 100.0

            ));
        }

        return posts;
    }


    public static boolean isEquals(List<FollowedDto> list, List<User> following) {
        if(list.size() != following.size()) return false;

        for(Integer i = 0; i < list.size(); i++) {
            if(!list.get(i).getUserName().equals(following.get(i).getUserName())) return false;
        }

        return true;
    }

    public static boolean isSorted(List<FollowedDto> list, Integer order) {
        for(Integer i = 0; i < list.size() - 1; i++) {
            if(list.get(i).getUserName().compareTo(list.get(i + 1).getUserName()) * order > 0) return false;
        }

        return true;
    }

    public static String generatePayload(Object o) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


        ObjectWriter writer = objectMapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        return writer.writeValueAsString(o);
    }

    public static String generateNoPrettyPayload(Object o) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


        ObjectWriter writer = objectMapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();//.withDefaultPrettyPrinter();

        return writer.writeValueAsString(o);
    }

    private static LocalDate getRandomDateWithDaysAgo(Integer daysAgo) {
        return LocalDate.now().minusDays(daysAgo);
    }

    private static List<Post> getListPostsForUser(User u){
        List<Post> posts = new ArrayList<>();
        for(Integer i = 0; i < 3; i++) {
            posts.add(
                new Post(
                    u.getUserId(),
                    i,
                    getRandomDateWithDaysAgo(
                        (int) (Math.random() * 13)
                    ),
                    getProduct(i),
                    i,
                    randomBetween(1.0, MAX_PRICE),
                    (int)(randomBetween(0.0, 1.0)) == 1,
                    randomBetween(0.0, 100) / 100.0
                )
            );
        }
        return posts;
    }

    public static Product getProduct(Integer productId){
        return new Product(productId, "Product " + productId, "Type " + productId, "Brand " + productId, "Color " + productId, "Notes " + productId);
    }

    public static Post getPost(User u, Integer postId){
        return new Post(u.getUserId(),  postId, getRandomDateWithDaysAgo(
            (int) (Math.random() * 13)
        ), getProduct(postId), postId, randomBetween(1.0, MAX_PRICE), (int)(randomBetween(0.0, 1.0)) == 1, randomBetween(0.0, 100) / 100.0);
    }

    private static double randomBetween(double min, double max) {
        return Math.abs(Math.random()) * (max - min) + min;
    }

    public static User createCompletedUserWithFollowedPosts(String name, Integer id){

        List<User> following = UtilTestTools.getListUsers(
                new Pair("Burr", 3),
                new Pair("Marcos", 4)
                );
        
        List<User> userfollowers = UtilTestTools.getListUsers(
                new Pair("Pepe", 123),
                new Pair("Sandra", 456)
        );

        List<Post> post = new ArrayList<>();

        for(User u: following) {
            List<Post> postsFollowed = getListPostsForUser(u);
            u.setPosts(postsFollowed);
        }

        return new User(id, name,post,userfollowers,following);
    }

    public static <Origen, Destino> boolean areEquals(List<Origen> list, List<Destino> list2, Class<?> clazz, String methodName) {
        if(list.size() != list2.size()) return false;

        
        try {
            Method method = clazz.getDeclaredMethod(methodName);

            for(Integer i = 0; i < list.size(); i++) {
                try {
                    if(!method.invoke(list.get(i)).equals(method.invoke(list2.get(i)))) return false;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    return false;
                }
            }

        } catch (NoSuchMethodException e) {
            return false;
        }

        return true;
    }

    public static List<PostDto> sortFollowedPosts(User user, Integer sortCondition) {
        List<PostDto> posts = user.getFollowing().stream().map(
            u ->  Util.castTo(u.getPosts(), PostDto.class)
                .stream()
                .filter( p -> p.getDate().compareTo(Util.timeAgo(2)) >= 0)
                .collect(Collectors.toList())
        ).collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);

        posts.sort( (p1, p2) -> p1.getDate().compareTo(p2.getDate()) * sortCondition);

        return posts;
    }
}
