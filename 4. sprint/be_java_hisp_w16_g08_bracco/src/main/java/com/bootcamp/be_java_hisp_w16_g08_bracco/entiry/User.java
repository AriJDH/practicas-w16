package com.bootcamp.be_java_hisp_w16_g08_bracco.entiry;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {
    private int userId;
    private String name;
    private List<User>  followerList;
    private List<User>  followedList;
    private List<Post> postMade;
}
