package com.JavaW16.linkTracker.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Link {
    private Integer linkId;
    private String linkURL;
    private String linkPassword;
    private Integer redirectCounter;
    private Boolean isValid;
}
