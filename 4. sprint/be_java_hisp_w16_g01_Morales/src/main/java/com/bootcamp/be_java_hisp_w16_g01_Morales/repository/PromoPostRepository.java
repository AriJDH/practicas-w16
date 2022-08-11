package com.bootcamp.be_java_hisp_w16_g01_Morales.repository;

import com.bootcamp.be_java_hisp_w16_g01_Morales.dto.CountPromoPostDTO;
import com.bootcamp.be_java_hisp_w16_g01_Morales.entities.PromoPost;
import com.bootcamp.be_java_hisp_w16_g01_Morales.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PromoPostRepository implements IPromoPostRepository {
    private List<PromoPost> promoPostList;

    public PromoPostRepository() {
        this.promoPostList = new ArrayList();
    }

    @Autowired
    UserRepository userRepository;

    @Override
    public int CreatePromoPost(PromoPost promoPost) {
        int id = promoPostList.size() + 1;
        promoPost.setPromoPostId(id);
        promoPostList.add(promoPost);

        return promoPost.getPromoPostId();
    }

    @Override
    public List<PromoPost> getPromoPostsByUserId(int userId) {
        return promoPostList.stream().filter(x -> x.getUserId() == userId).collect(Collectors.toList());
    }

    @Override
    public CountPromoPostDTO countPromoPost(int userId) {
        int count = promoPostList.stream().filter(x -> x.getUserId() == userId).collect(Collectors.toList()).size();
        User searchedUser = userRepository.users.stream().filter(x->x.getUserId()==userId).findFirst().get();
        String nameSearchedUser =searchedUser.getUserName();
        int idSearchedUser = searchedUser.getUserId();
        CountPromoPostDTO countPromoPostDTO= new CountPromoPostDTO(idSearchedUser,nameSearchedUser,count);
        return countPromoPostDTO;
    }
}
