package com.bootcamp.relacionesjpa.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="purchase")
public class Purchase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "date_buy")
  private Date DateBuy;

  @OneToMany(mappedBy = "product", cascade{})
  private List<Product> products;
}
