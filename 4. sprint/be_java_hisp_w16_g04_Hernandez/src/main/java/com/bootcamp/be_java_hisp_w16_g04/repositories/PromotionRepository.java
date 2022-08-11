package com.bootcamp.be_java_hisp_w16_g04.repositories;

import com.bootcamp.be_java_hisp_w16_g04.dto.PublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.Follower;
import com.bootcamp.be_java_hisp_w16_g04.model.Product;
import com.bootcamp.be_java_hisp_w16_g04.model.Promotion;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PromotionRepository implements IPromotionRepository {
    List<Promotion> promos = new ArrayList<>();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate date1 = LocalDate.parse("09-08-2022", dtf);
    LocalDate date2 = LocalDate.parse("18-04-2022", dtf);

    @PostConstruct
    private void loadData() {
        promos.add(new Promotion(100, date1, new Product(100, "Computador", "Gamer", "Racer", "Azul", "last"), 100, 250.0, true, 0.25));
        promos.add(new Promotion(104, date2, new Product(180, "Control Xbox", "Gamer", "Xbox", "Rojo", "new"), 190, 350.0, false, 0.0));

    }
    @Override
    public void productPromotion(Promotion promo) {

        Promotion promotion = new Promotion(promo.getUserId(),
                promo.getDate(),
                promo.getProduct(),
                promo.getCategory(),
                promo.getPrice(),
                promo.getHas_promo(),
                promo.getDiscount()
                );
        promos.add(promotion);
    }

    @Override
    public Boolean verifyPromotion(Promotion promo) {
        Long countPromos = promos.stream()
                .filter(promotion -> promotion.equals(promo))
                .count();

        if (countPromos > 0) {
            return false;
        }
        return true;
    }

    @Override
    public Long getPromoByUserId(Integer userId){
         Long countProductPromos = promos.stream()
                .filter(promotion -> promotion.getUserId() ==userId)
                .count();
        return countProductPromos;
    }

    @Override
    public List<Promotion> getListPromosByUserId(Integer userId){
        List<Promotion> promotions = promos.stream()
                .filter(promotion -> promotion.getUserId() ==userId)
                .collect(Collectors.toList());
        return promotions;
    }
}
