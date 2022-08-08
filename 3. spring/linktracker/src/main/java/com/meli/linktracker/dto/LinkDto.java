package com.meli.linktracker.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkDto {
    private int id;
    private String url;
    private int solicitudes;


    public void addSolicitudes()
    {
        this.solicitudes++;
    }


}
