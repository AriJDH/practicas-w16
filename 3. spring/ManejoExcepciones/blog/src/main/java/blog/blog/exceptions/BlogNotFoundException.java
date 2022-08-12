package blog.blog.exceptions;

public class BlogNotFoundException extends RuntimeException{
    public BlogNotFoundException(String message) {
        super(message);
    }
}
