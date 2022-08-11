package com.bootcamp.linktracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkCreatedResDTO extends LinkResDTO{
    private String password;
}
