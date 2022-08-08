package com.grodriguez.linkTracker.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestLinkDTO {
    private String url;
    private String password;
}
