package com.example.be_java_hisp_w16_g09_bariani.dto;

import com.example.be_java_hisp_w16_g09_bariani.exception.InvalidBlankUserNameException;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDtoRequest {
    private String userName;

    public void setUserName(String userName) {
        if (userName.isBlank()){
            throw new InvalidBlankUserNameException();
        }
        this.userName = userName;
    }
}
