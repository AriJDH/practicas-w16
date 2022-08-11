package com.bootcamp.be_java_hisp_w16_g06.dto;

import com.bootcamp.be_java_hisp_w16_g06.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePostAllPromoDto {
    private int user_id;
    private String user_name;
    private List<Post> posts;
}
