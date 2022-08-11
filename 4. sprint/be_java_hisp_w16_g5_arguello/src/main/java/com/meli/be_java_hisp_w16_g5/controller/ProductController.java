package com.meli.be_java_hisp_w16_g5.controller;

import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.exceptions.ProducNotFoundException;
import com.meli.be_java_hisp_w16_g5.exceptions.UnknownRequestException;
import com.meli.be_java_hisp_w16_g5.exceptions.UserNotFoundException;
import com.meli.be_java_hisp_w16_g5.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    /**
     * postService contiene los metodos necesarios para realizar las diferentes solicitudes existentes
     */
    @Autowired
    private IPostService postService;

    /**
     * US 0005: Metodo que recibe un objeto Post y hace el llamado a service para la creación de un post
     * @param post
     * @return PostDto
     * @throws UserNotFoundException
     * @throws ProducNotFoundException
     */
    @PostMapping("/post")
    public ResponseEntity<PostDto> savePost(@RequestBody Post post) throws UserNotFoundException, ProducNotFoundException {
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK);
    }

    /**
     * US 0006: Metodo que obtiene todos los post
     * @return PostDto
     */
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getPosts(){
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    /**
     * US 0006: Metodo para devolver los post de las ultimas dos semanas de las personas que sigue el usuario
     * @param userId
     * @param order
     * @return PostsByUserDto
     * @throws UserNotFoundException
     * @throws UnknownRequestException
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getFollowedProducts(@PathVariable int userId, @RequestParam Optional<String> order) throws UserNotFoundException, UnknownRequestException {
        return ResponseEntity.ok(postService.getFollowedProducts(userId, order.isPresent() ? order.get() : null));
    }

    /**
     * US 0012: Guardar post de producto si tiene promocion activa
     * @param post
     * @return PostPromoDto
     * @throws UserNotFoundException
     * @throws ProducNotFoundException
     */
    @PostMapping("/promo-post")
    public ResponseEntity<?> savePostPromo(@RequestBody Post post) throws UserNotFoundException, ProducNotFoundException {
        return new ResponseEntity<>(postService.savePromo(post), HttpStatus.OK);
    }

    /**
     * US 0011: Obtiene la cantidad de post en promo que tiene un usuario
     * @param userId
     * @return PostCountDto
     * @throws UserNotFoundException
     */
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoPostCount(@RequestParam(value = "user_id") int userId) throws UserNotFoundException {
        return new ResponseEntity<>(postService.getPromoPostCount(userId), HttpStatus.OK);
    }

    /**
     * US 0013: Obtiene los post por categoria
     * @return PostDto
     */
    @GetMapping("/post/category/{idCategory}")
    public ResponseEntity getPostByCategory(@PathVariable int idCategory) {
        return new ResponseEntity<>(postService.getPostPromoByCategory(idCategory), HttpStatus.OK);
    }
}
