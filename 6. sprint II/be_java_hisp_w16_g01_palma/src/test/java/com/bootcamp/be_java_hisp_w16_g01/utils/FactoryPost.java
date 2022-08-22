package com.bootcamp.be_java_hisp_w16_g01.utils;

import com.bootcamp.be_java_hisp_w16_g01.dto.request.PostDto;
import com.bootcamp.be_java_hisp_w16_g01.dto.request.ProductDto;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.FollowedPostsDto;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.ResponsePostDto;
import com.bootcamp.be_java_hisp_w16_g01.entities.Post;
import com.bootcamp.be_java_hisp_w16_g01.entities.Product;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactoryPost {

    public static FollowedPostsDto generateGetFollowedPostsControllerTestResponse(int userId) {
        return new FollowedPostsDto(
                userId,
                new ArrayList<>(
                        Arrays.asList(
                                new ResponsePostDto(2, 1, LocalDate.now().minusDays(5), new ProductDto(1, "Mate", "Ceramico", "Canarias", "Marron", null), 100, 150.0),
                                new ResponsePostDto(3, 2, LocalDate.now().minusDays(10), new ProductDto(2, "Termo", "Metalico", "Stanley", "Verde", null), 100, 2500.0),
                                new ResponsePostDto(4, 3, LocalDate.now().minusDays(20), new ProductDto(3, "Matera", "Cuero", "Lincolns", "Marron", null), 110, 1500.0)
                        )
                )
        );

    }

    public static User generateFollower(int userId) {
        return new User(
                userId,
                "German",
                new ArrayList<>(),
                new ArrayList<>(
                        Arrays.asList(
                                new User(userId + 1, "Hernan"),
                                new User(userId + 2, "Camilo")
                        )
                ),
                new ArrayList<>()
        );
    }

    public static FollowedPostsDto generateGetFollowedPostsServiceTestResponse(int userId, String order) {

        if (order == "date_asc") {
            return new FollowedPostsDto(
                    userId,
                    new ArrayList<>(
                            Arrays.asList(
                                    new ResponsePostDto(3, 3, LocalDate.now().minusDays(10), new ProductDto(3, "Matera", "Cuero", "Lincolns", "Marron", null), 110, 1500.0),
                                    new ResponsePostDto(3, 2, LocalDate.now().minusDays(9), new ProductDto(2, "Termo", "Metalico", "Stanley", "Verde", null), 100, 2500.0),
                                    new ResponsePostDto(3, 1, LocalDate.now().minusDays(8), new ProductDto(1, "Mate", "Ceramico", "Canarias", "Marron", null), 100, 150.0),
                                    new ResponsePostDto(2, 3, LocalDate.now().minusDays(7), new ProductDto(3, "Matera", "Cuero", "Lincolns", "Marron", null), 110, 1500.0),
                                    new ResponsePostDto(2, 2, LocalDate.now().minusDays(6), new ProductDto(2, "Termo", "Metalico", "Stanley", "Verde", null), 100, 2500.0),
                                    new ResponsePostDto(2, 1, LocalDate.now().minusDays(5), new ProductDto(1, "Mate", "Ceramico", "Canarias", "Marron", null), 100, 150.0)
                            )
                    )
            );
        } else {
            return new FollowedPostsDto(
                    userId,
                    new ArrayList<>(
                            Arrays.asList(
                                    new ResponsePostDto(2, 1, LocalDate.now().minusDays(5), new ProductDto(1, "Mate", "Ceramico", "Canarias", "Marron", null), 100, 150.0),
                                    new ResponsePostDto(2, 2, LocalDate.now().minusDays(6), new ProductDto(2, "Termo", "Metalico", "Stanley", "Verde", null), 100, 2500.0),
                                    new ResponsePostDto(2, 3, LocalDate.now().minusDays(7), new ProductDto(3, "Matera", "Cuero", "Lincolns", "Marron", null), 110, 1500.0),
                                    new ResponsePostDto(3, 1, LocalDate.now().minusDays(8), new ProductDto(1, "Mate", "Ceramico", "Canarias", "Marron", null), 100, 150.0),
                                    new ResponsePostDto(3, 2, LocalDate.now().minusDays(9), new ProductDto(2, "Termo", "Metalico", "Stanley", "Verde", null), 100, 2500.0),
                                    new ResponsePostDto(3, 3, LocalDate.now().minusDays(10), new ProductDto(3, "Matera", "Cuero", "Lincolns", "Marron", null), 110, 1500.0)
                            )
                    )
            );
        }
    }

    public static List<Post> generateGetPostsByUserIdTestResponse(int userId, int daysToSubtract) {
        return new ArrayList<>(
                Arrays.asList(
                        new Post(1, userId, LocalDate.now().minusDays(daysToSubtract), new Product(1, "Mate", "Ceramico", "Canarias", "Marron", null), 100, 150.00),
                        new Post(2, userId, LocalDate.now().minusDays(daysToSubtract + 1), new Product(2, "Termo", "Metalico", "Stanley", "Verde", null), 100, 2500.00),
                        new Post(3, userId, LocalDate.now().minusDays(daysToSubtract + 2), new Product(3, "Matera", "Cuero", "Lincolns", "Marron", null), 110, 1500.00)
                )
        );
    }

    public static List<Post> loadRepoData() {
        return new ArrayList<>(
            Arrays.asList(
                    //Dentro de las 2 semanas
                    new Post(1, 2, LocalDate.now().minusDays(5), new Product(1, "Mate", "Ceramico", "Canarias", "Marron", null), 100, 150.00),
                    new Post(2, 3, LocalDate.now().minusDays(6), new Product(2, "Termo", "Metalico", "Stanley", "Verde", null), 100, 2500.00),
                    new Post(3, 2, LocalDate.now().minusDays(13), new Product(3, "Matera", "Cuero", "Lincolns", "Marron", null), 110, 1500.00),

                    //Fuera de las 2 semanas
                    new Post(4, 3, LocalDate.now().minusDays(14), new Product(1, "Mate", "Ceramico", "Canarias", "Marron", null), 100, 150.00),
                    new Post(5, 2, LocalDate.now().minusDays(15), new Product(2, "Termo", "Metalico", "Stanley", "Verde", null), 100, 2500.00),
                    new Post(6, 3, LocalDate.now().minusDays(200), new Product(3, "Matera", "Cuero", "Lincolns", "Marron", null), 110, 1500.00)
            )
        );
    }

    public static List<Post> generateGetPostsByUserId(int userId){

        List<Post> response;

        switch(userId){
            case 2:
                response = new ArrayList<>(
                    Arrays.asList(
                        new Post(1, 2, LocalDate.now().minusDays(5), new Product(1, "Mate", "Ceramico", "Canarias", "Marron", null), 100, 150.00),
                        new Post(3, 2, LocalDate.now().minusDays(13), new Product(3, "Matera", "Cuero", "Lincolns", "Marron", null), 110, 1500.00)
                    )
                );
                break;
            case 3:
                response = new ArrayList<>(
                    Arrays.asList(
                        new Post(2, 3, LocalDate.now().minusDays(6), new Product(2, "Termo", "Metalico", "Stanley", "Verde", null), 100, 2500.00)
                    )
                );
                break;
            default:
                response = new ArrayList<>();
        }

        return response;
    }

    public static PostDto generateNewPost() {
        ProductDto product = new ProductDto(1, "Silla Gamer", "Gamer", "Racer", "Black", "Gold Edition");
        return new PostDto(1, LocalDate.now(), product, 100, 1500.50);
    }

    public static PostDto generateNewPostIdNegative() {
        ProductDto product = new ProductDto(1, "Silla Gamer", "Gamer", "Racer", "Black", "Gold Edition");
        return new PostDto(-1, LocalDate.now(), product, 100, 1500.50);
    }
}
