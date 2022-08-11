package com.bootcamp.be_java_hisp_w16_g01_rodriguez.repository;

import com.bootcamp.be_java_hisp_w16_g01_rodriguez.entities.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository{
    private List<Post> postList;

    public PostRepository() {
        this.postList = new ArrayList<>();
    }
    @Override
    public int createPost(Post post) {
        int id = postList.size()+1;
        post.setPostId(id);
        postList.add(post);
        return post.getPostId();
    }

    @Override
    public List<Post> getPostsByUserId(int userId) {
        LocalDate dateWeek = LocalDate.now().minusWeeks(2);
        return postList.stream().filter(x ->x.getUserId()==userId && x.getDate().isAfter(dateWeek)).collect(Collectors.toList());
    }

    @Override
    public int getPromoPostCount(int userId) {
        return ((int) postList.stream().filter(x -> x.getUserId() == userId && x.isHasPromo()).count());
    }

    @Override
    public List<Post> getPromoPost(int userId) {
        return postList.stream().filter(x -> x.getUserId() == userId && x.isHasPromo()).collect(Collectors.toList());
    }

    @Override
    public List<Post> getFilteredPosts(int category, String type, String brand, double minPrice, double maxPrice, boolean hasPromo, String search) {
        return postList.stream().filter(x ->
                (category == 0 || x.getCategory() == category) &&
                (type.isEmpty() || x.getProduct().getType().equalsIgnoreCase(type)) &&
                (brand.isEmpty() || x.getProduct().getBrand().equalsIgnoreCase(brand)) &&
                (minPrice <= x.getPrice() && x.getPrice() <= maxPrice) &&
                (hasPromo || x.isHasPromo() == hasPromo) &&
                (search.isEmpty() || x.getProduct().getProductName().toLowerCase().contains(search.toLowerCase()))
        ).sorted(Comparator.comparing(Post::getDate).reversed()).collect(Collectors.toList());
    }
}
