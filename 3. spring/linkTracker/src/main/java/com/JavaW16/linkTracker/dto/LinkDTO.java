package com.JavaW16.linkTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LinkDTO {
    private Integer linkId;
    @URL private String linkURL;
    private String linkPassword;
}
