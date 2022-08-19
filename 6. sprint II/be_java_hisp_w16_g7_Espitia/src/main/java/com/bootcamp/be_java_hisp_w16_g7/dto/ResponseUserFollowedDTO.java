package com.bootcamp.be_java_hisp_w16_g7.dto;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ResponseUserFollowedDTO {
    private int userId;
    private String userName;
    private List<ResponseUserDTO> followed;
}
