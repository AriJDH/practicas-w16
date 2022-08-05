package com.bootcamp.ejerciciocovid19.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Symphtom {

    private Integer code;
    private String name;
    private String dangerLevel;


}
