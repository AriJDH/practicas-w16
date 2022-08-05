package com.bootcamp.practico.dto;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BlogDto {

    private int id;
    private String blog;
    private String name;
    private Date fecha;


    public boolean validate() {

        return this.id > 0&& this.getFecha() != null
                && this.getFecha() != null
                && this.getBlog() != null
                && !this.getBlog().isEmpty()
                && this.getName() != null
                && !this.getName().isEmpty();
    }


}
