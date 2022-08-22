package com.example.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostUS10 extends AbstractPost {

    @JsonFormat(pattern="dd-MM-yyyy")
    //@JsonSerialize(using = LocalDateSerializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;
    private boolean hasPromo;
    private double discount;

    public PostUS10(Integer postId, Integer userId, Product product, LocalDate date, Integer category, Double price, boolean hasPromo, double discount) {
        super(postId, userId, product, category, price);
        this.date = date;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public PostUS10(){

    }

    public PostUS10(boolean hasPromo, double discount) {
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public boolean isHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
