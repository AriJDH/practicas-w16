package com.linkTracker.LinkTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LinkResponseDataDTO {

    private int id;
    private String url;
    private int contador;
}
