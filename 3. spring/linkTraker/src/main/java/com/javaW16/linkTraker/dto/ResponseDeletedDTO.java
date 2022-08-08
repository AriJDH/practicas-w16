package com.javaW16.linkTraker.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class ResponseDeletedDTO {
   String url;
   String message;
}
