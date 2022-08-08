package com.ndemaio.linktrackerexercise.dto;

import com.ndemaio.linktrackerexercise.model.Link;
import lombok.Data;

import java.util.UUID;

@Data
public class LinkDTOResponse {

    private UUID id;
    private String url;
    private Boolean isValid;
    private Integer timesRedirected;

}
