package com.example.be_java_hisp_w16_g09.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private User user;
    private LocalDate date;
    private Product product;
    private int categoryId;
    private double price;

    public boolean wasPublicatedAfter(LocalDate aDate) {
        return date.isAfter(aDate);
    }
}
