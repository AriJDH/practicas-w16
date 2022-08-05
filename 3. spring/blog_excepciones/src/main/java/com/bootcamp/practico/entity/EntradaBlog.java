package com.bootcamp.practico.entity;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class EntradaBlog {


    private int id;
    private String blog;
    private String name;
    private Date fecha;
}
