package com.bootcamp.ejerciciocovid19.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SymphtomDtoMessage {

    private String name;
    private String dangerLevel;
    private String message;

}
