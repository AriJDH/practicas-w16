package utils;

import com.bootcamp.entradasblog.dto.BlogDto;
import com.bootcamp.entradasblog.model.Blog;

public class Mapper {

    public static BlogDto DTOFromBlog(Blog b){
        return new BlogDto(
                b.getId(),
                b.getTitle(),
                b.getAuthor(),
                b.getDate()
        );
    }

    public static Blog BlogFromDto(BlogDto b){
        return new Blog(
                b.getId(),
                b.getTitle(),
                b.getAuthor(),
                b.getDate()
        );
    }
}
