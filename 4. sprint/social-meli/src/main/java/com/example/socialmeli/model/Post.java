package com.example.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Post extends AbstractPost {
    private Integer postId;
    private Integer userId;
    private Product product;
    @JsonFormat(pattern="dd-MM-yyyy")
    //@JsonSerialize(using = LocalDateSerializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDate date;
    private Integer category;
    private Double price;


    public Post(Integer postId, Integer userId, Product product, LocalDate date, Integer category, Double price) {
        super(postId, userId, product, category, price);
        this.date = date;
    }

    public Post(){

    }

    @Override
    public Integer getPostId() {
        return postId;
    }

    @Override
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public Integer getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public Integer getCategory() {
        return category;
    }

    @Override
    public void setCategory(Integer category) {
        this.category = category;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public void setPrice(Double price) {
        this.price = price;
    }
}
