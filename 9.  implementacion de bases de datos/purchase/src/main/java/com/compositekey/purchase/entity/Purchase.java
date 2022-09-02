package com.compositekey.purchase.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "purchase")
@IdClass(value = PurchaseId.class)
public class Purchase {

    @Id
    @Column(name = "client_id")
    private Integer clientId;

    @Id
    @Column(name = "date_purchase")
    private LocalDate datePurchase;

    private Integer amountProducts;
}
